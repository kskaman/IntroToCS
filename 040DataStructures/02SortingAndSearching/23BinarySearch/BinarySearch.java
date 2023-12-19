import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BinarySearch {

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, String[] a) {
        //return searchRecursive(key, a, 0, a.length);
        return searchIterative(key, a);
    }
    public static int searchRecursive(String key, String[] a, int lo, int hi) {
        // possible key indices in [lo, hi)
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo) / 2;
        int cmp = a[mid].compareTo(key);
        if      (cmp > 0) return searchRecursive(key, a, lo, mid);
        else if (cmp < 0) return searchRecursive(key, a, mid+1, hi);
        else              return mid;
    }
    public static int searchIterative(String key, String[] a) {
        int lo = 0;
        int hi = a.length;

        
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;

            if (a[mid].compareTo(key) == 0) return mid;
            else if (a[mid].compareTo(key) < 0) lo = mid+1;
            else hi = mid;
        }
        return -1;
        
    }

    private static String[] readAll(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        String list = in.useDelimiter("\\A").next();
        in.close();

        final Pattern WHITESPACE = Pattern.compile("\\p{javaWhitespace}+");
        String[] tokens = WHITESPACE.split(list);
        return tokens;
    }


    // allowlist, exception filter
    public static void main(String[] args) throws FileNotFoundException {
        File file = null;
        File inputFile = null;
        Scanner in = new Scanner(System.in);
        
        if (args.length == 2) {
            file = new File(args[0]);
            inputFile = new File(args[1]);
        } else if (args.length == 0) {
            System.out.println("Enter data file name : ");
            String filename = in.next();
            System.out.println("Enter input file : ");
            String input = in.next();

            file = new File(filename);
            inputFile = new File(input);
        } else {
            System.out.println("Incorrect number of arguments. Only 2 or 0 arguments are valid.");
            System.exit(0);
        }

        String[] allowList = readAll(file);
        Arrays.sort(allowList);
        //System.out.println(Arrays.toString(allowList));
        String[] list = readAll(inputFile);
        //System.out.println(Arrays.toString(list));
        in.close();
        
        System.out.println();

        for (String key : list) {
            int index = search(key, allowList);
            if (index < 0) {
                System.out.println(key + " not found in file '" + file.getName() + "'");
            } else {
                System.out.println(key + " found in file '" + file.getName() + "'");
            }
        }

        System.out.println();
    }
}

