/********************************************************************************
 * Compilation:     javac Insertion.java
 * Execution:       java Insertion input.txt
 *                  or
 *                  java Insertion
 * Data files:      8words.txt
 *                  TomSawyer.txt
 * 
 * Reads in strings and prints then in sorted order
 * Uses Insertion Sort.
 * 
 * % java Insertion 8 words
 * 
 * and     but     had     him     his     the     was     you
 * 
 * % java Insertion 8 words
 * Enter file name : 8words.txt
 * 
 * and     but     had     him     his     the     was     you
 ********************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
  * @author Kevin Wayne
  * @author Robert Sedgewick
  */

public class Insertion {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j-1].compareTo(a[j]) > 0)     exchange(a, j-1, j);
                else                                break;
            }
        }
    }

    @SuppressWarnings({"rawtypes"})
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j]; 
        a[j] = temp;
    }

    private static String[] readAllStrings(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        final Pattern WHITESPACE = Pattern.compile("\\p{javaWhitespace}+");
        String content = scan.useDelimiter("\\A").next();
        String[] list = WHITESPACE.split(content);
        scan.close();

        return list;
    }

    // read in a sequence of words from standard input
    // and print out in sorted order
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(System.in);
        File file = null;

        if (args.length == 1) {
            file = new File(args[0]);
        } else if (args.length == 0) {
            System.out.print("Enter file name : ");
            String fileName = in.next();
            System.out.println();
            file = new File(fileName);            
        } else {
            System.out.println("Incorrect number of inline arguments entered.");
        }

        String[] a = readAllStrings(file);
        sort(a);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();

        in.close();
    }
}