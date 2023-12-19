/******************************************************************************
 *  Compilation:  javac Lookup.java
 *  Execution:    java Lookup file.csv keyField valField
 *  Dependencies: ST.java In.java StdIn.java
 *  Data files:   amino.csv
 *                ip.csv
 *                DJIA.csv
 *                morse.csv
 *                elements.csv
 *
 *  Reads in a set of key-value pairs from a two-column CSV file
 *  specified on the command line; then, reads in keys from standard
 *  input and prints out corresponding values.
 *
 *  % java Lookup amino.csv 0 3      % java Lookup ip.csv 0 1
 *  TTA                              google.com
 *  Leucine                          64.233.167.99
 *  ABC
 *  Not found                        % java Lookup ip.csv 1 0
 *  TCT                              64.233.167.99
 *  Serine                           google.com
 *
 *  % java Lookup amino.csv 3 0      java Lookup DJIA.csv 0 1
 *  Glycine                          29-Oct-29
 *  GGG                              252.38
 *                                   20-Oct-87
 *                                   1738.74
 *
 ******************************************************************************/
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Lookup {

     /**
     * Reads all remaining lines from standard input and returns them as an array of strings.
     * @return all remaining lines on standard input, as an array of strings
     */
    public static String[] readAllLines(File file) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException f) {
            System.out.println("File not Found");
            System.exit(0);
        }
        String line;
        while (scan.hasNext()) {
            try {
                line = scan.nextLine();
            }
            catch (NoSuchElementException e) {
                line = null;
            }
            lines.add(line);
        }
        scan.close();
        return lines.toArray(new String[0]);
    }


    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 3) {
            System.out.println("Incorrect number of arguments. Please enter Filename followed by key-column and value-column");
        }
        File file = new File(args[0]);

        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        String[] database = readAllLines(file);

        ST<String, String> st = new ST<String, String>();
        for (int i = 0; i < database.length; i++) {
            String[] tokens = database[i].split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            if (st.contains(s)) System.out.println(st.get(s));
            else                System.out.println("Not found");
        }
        in.close();
    }
}