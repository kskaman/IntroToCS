/******************************************************************************
 *  Compilation:  javac DeDup.java
 *  Execution:    java DeDup words.txt
 *  Dependencies: SET.java
 *
 *  Read in a list of words from standard input and print out
 *  each word, removing any duplicates.
 *
 ******************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class DeDup {
    public static void main(String[] args) throws FileNotFoundException {
        SET<String> distinct = new SET<String>();

        if (args.length != 1) {
            System.out.println("Incorrect number of arguments.");
            System.exit(0);
        }
        
        File file = new File(args[0]);
        Scanner in  = new Scanner(file);

        while (in.hasNext()) {
            String key = in.next();
            if (!distinct.contains(key)) {
                distinct.add(key);
                System.out.println(key);
            }
        }
        in.close();
    }
}
