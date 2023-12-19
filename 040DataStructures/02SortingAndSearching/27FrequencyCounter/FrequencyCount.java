import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/******************************************************************************
 *  Compilation:  javac FrequencyCount.java
 *  Execution:    java FrequencyCount < file.txt
 *  Dependencies: StdIn.java Counter.java
 *  Data files:   mobydicks.txt
 *                Leipzig100K.txt
 *
 *  Read in a sequence of words, separated by whitespace.
 *  Compute the number of times each word appears, and print,
 *  sorted by frequency.
 *
 *  % java FrequencyCount mobydick.txt
 *  the: 13527
 *  of: 6374
 *  and: 5857
 *  a: 4457
 *  to: 4388
 *  in: 3773
 *  that: 2666
 *  his: 2404
 *  I: 1742
 *  with: 1615
 *  ...
 *
 ******************************************************************************/

 public class FrequencyCount {

    private static String[] readAll(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String content = scan.useDelimiter("\\A").next();
        String[] tokens = Pattern.compile("\\p{javaWhitespace}+").split(content);
        scan.close();
        return tokens;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = null;
        if (args.length == 1) {
            file = new File(args[0]);
        } else {
            System.out.println("Incorrect number of command line arguments");
            System.exit(0);
        }
        // read in the words as an array
        String[] words = readAll(file);

        // sort the words
        Merge.sort(words);

        // tabulate frequencies of each word
        Counter[] zipf = new Counter[words.length];
        int m = 0;                                        // number of distinct words
        for (int i = 0; i < words.length; i++) {
            if (i == 0 || !words[i].equals(words[i-1]))   // short-circuiting OR
                zipf[m++] = new Counter(words[i], words.length);
            zipf[m-1].increment();
        }

        // sort by frequency and print
        Merge.sort(zipf, 0, m);                           // sorting a subarray
        for (int j = m-1; j >= 0; j--) {
            System.out.println(zipf[j]);
        }
    }
}