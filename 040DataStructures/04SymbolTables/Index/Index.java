import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/******************************************************************************
 *  Compilation:  javac Index.java
 *  Execution:    java Index i j input.txt
 *  Dependencies: ST.java Queue.java
 *  Data files:   TaleOfTwoCities.java
 *
 *  Create an index of all words in the given input file such that
 *  the word has length >= i and occurs >= j times.
 ******************************************************************************/

public class Index {

    private static String[] readAllStrings(File file) throws FileNotFoundException {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException f) {
            System.out.println("File not found.");
            System.exit(0);
        }
        final Pattern WHITESPACE = Pattern.compile("\\p{javaWhitespace}+");
        String content = scan.useDelimiter("\\A").next();
        String[] list = WHITESPACE.split(content);
        scan.close();

        return list;
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 3) {
            System.out.println("Incorrect number of arguments.");
            System.exit(0);
        }
        int minLength     = Integer.parseInt(args[0]);    // min length of word
        int minOccurrence = Integer.parseInt(args[1]);    // min number of occurrences
        File file = new File(args[2]);
        // read in the words from standard input
        String[] words = readAllStrings(file);

        // build symbol table of words and locations
        ST<String, Queue<Integer>> st = new ST<String, Queue<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() < minLength) continue;
            if (!st.contains(s)) {
                st.put(s, new Queue<Integer>());
            }
            Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }
        for (String s : st.keys()) {
            Queue<Integer> q = st.get(s);
            if (q.size() >= minOccurrence) {
                System.out.println(s + ": " + q);
            }
        }
    }
}
