import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/******************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum input.txt
 *                
 *  Data files:   8ints.txt
 *                1Kints.txt
 *                4Kints.txt
 *                8Kints.txt
 *
 *  A program with cubic running time. Reads in n integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  % java ThreeSum 8ints.txt
 *  4
 *  30 -30 0
 *  30 -20 -10
 *  -30 -10 40
 *  -10 0 10
 *
 *  % java ThreeSum 1Kints.txt
 *  0
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 ******************************************************************************/

 public class ThreeSum {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int[] readAllInts(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String str = scan.useDelimiter("\\A").next();
        String[] strTokens = Pattern.compile("\\p{javaWhitespace}+").split(str);
        scan.close();
        int len = strTokens.length;
        int[] tokens = new int[len];
        for (int i = 0; i < len; i++) {
            if (strTokens[i].equals("")) continue;
            tokens[i] = Integer.parseInt(strTokens[i]);
        }
        return tokens;
    }

    public static void main(String[] args) throws FileNotFoundException  {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments");
            System.exit(0);
        }    
        File file = new File(args[0]);
        
        int[] a = readAllInts(file);
        long start = System.currentTimeMillis();
        int count = count(a);
        long end = System.currentTimeMillis();
        System.out.println("elapsed time = " + ((end-start)/1000.0));
        System.out.println(count);
    }
}