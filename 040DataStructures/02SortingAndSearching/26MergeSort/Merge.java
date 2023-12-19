import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge input.txt
 *  Data files:   8words.txt
 *                TomSawyer.txt
 *                tinyText.txt
 *
 *  A bare-bones n log n implementation of mergesort.
 *
 *  Remarks
 *  ---------
 *     - number of comparisons is guaranteed to be at most n lg n
 *     - sort is stable
 *
 *  % java Merge 8words.txt
 *  and but had him his the was you
 *
 ******************************************************************************/

public class Merge {
    /***************************************************************************
    *  Merge the subarrays a[lo] .. a[mid-1] and a[mid] .. a[hi-1] into
    *  a[lo] .. a[hi-1] using the auxiliary array aux[] as scratch space.
    *
    *  Precondition:   the two subarrays are in ascending order
    *  Postcondition:  a[lo] .. a[hi-1] is in ascending order
    *
    ***************************************************************************/
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid;
        Comparable[] aux = new Comparable[hi-lo];
        for (int k = lo; k < hi; k++) {
            if (i == mid)   aux[k-lo] = a[j++];
            else if (j == hi) aux[k-lo] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k-lo] = a[j++];
            else aux[k-lo] = a[i++];
        }

        // copy back
        for (int k = lo; k < hi; k++) {
            a[k] = aux[k-lo];
        }
    }

    /***************************************************************************
    *  Mergesort the subarray a[lo] .. a[hi-1], using the
    *  auxiliary array aux[] as scratch space.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        // base case
        if (hi - lo <= 1) return;

        // sort each half, recursively
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid, hi);

        // merge back together
        merge(a, lo, mid, hi);
    }

    /***************************************************************************
    *  Sort the array a using mergesort.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n);
    }

    /***************************************************************************
    *  Sort the subarray a[lo..hi] using mergesort.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, lo, hi);
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

   /***************************************************************************
    *  Show results.
    ***************************************************************************/
    @SuppressWarnings("rawtypes")
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }


    private static String[] readAllStrings(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        final Pattern WHITESPACE = Pattern.compile("\\p{javaWhitespace}+");
        String str = in.useDelimiter("\\A").next();
        String[] tokens = WHITESPACE.split(str);
        in.close();
        return tokens;
    }

    /***************************************************************************
    *  Test client.
     * @throws FileNotFoundException
    ***************************************************************************/
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1) {
            System.out.println("Incorrect number of arguments.");
            System.exit(0);
        }
        
        File file = new File(args[0]);

        String[] a = readAllStrings(file);
        Merge.sort(a);
        assert isSorted(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}