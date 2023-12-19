
/******************************************************************************
 *  Compilation:  javac Questions.java
 *  Execution:    java Questions k
 *  Dependencies  None
 *
 *  This code uses binary search to play the game of twenty questions.
 *  It takes an integer command-line argument k, asks you to think of a
 *  number between 0 and n-1, where n = 2^k, and always guesses the answer
 *  with n questions.
 *
 *  %  java Questions 7
 *  Think of an integer between 0 and 127
 *  Greater than or equal to 64?  true
 *  Greater than or equal to 96?  false
 *  Greater than or equal to 80?  false
 *  Greater than or equal to 72?  true
 *  Greater than or equal to 76?  true
 *  Greater than or equal to 78?  false
 *  Greater than or equal to 77?  true
 *  Your number is 77
 *
 ******************************************************************************/
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Kevin Wayne
 * @author Robert Sedgewick
 * @author Kamanpreet Singh Manoor
 */


public class Questions {

    // invariant: answer is in [lo, hi)
    public static int searchNonRecursive(int n, Scanner in) {
        int lo = 0; 
        int hi = n;
        int mid = lo + (hi - lo) / 2;
        
        while(hi > lo) {
            if ((hi - lo) == 1) break;

            System.out.printf("Greater than or equal to %d?  ", mid);
            if (readBoolean(in))        lo = mid;
            else                        hi = mid;

            mid = lo + (hi - lo) / 2;
        }

        return mid;
    }

    public static int searchRecursive(int lo, int hi, Scanner in) {
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        System.out.printf("Greater than or equal to %d?  ", mid);
        if (readBoolean(in)) return searchRecursive(mid, hi, in);
        else                     return searchRecursive(lo, mid, in);
    }

    public static int search(int n) {
        Scanner in = new Scanner(System.in);
        int ans = searchNonRecursive(n, in);
        // int ans = searchRecursive(0, n, in);
        in.close();
        return ans;
    }

    /**
     * Reads the next token from standard input, parses it as a boolean,
     * and returns the boolean.
     *
     * @return the next boolean on standard input
     * @throws NoSuchElementException if standard input is empty
     * @throws InputMismatchException if the next token cannot be parsed as a {@code boolean}:
     *    {@code true} or {@code 1} for true, and {@code false} or {@code 0} for false,
     *    ignoring case
     */
    public static boolean readBoolean(Scanner in) {
        try {
            String token = in.next();
            if ("true".equalsIgnoreCase(token))  return true;
            if ("false".equalsIgnoreCase(token)) return false;
            if ("1".equals(token))               return true;
            if ("0".equals(token))               return false;
            throw new InputMismatchException("attempts to read a 'boolean' value from standard input but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'boolean' value from standard input but no more tokens are available");
        }

    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int n = (int) Math.pow(2, k);
        
        System.out.printf("Think of an integer between %d and %d.\nEnter either 'true/false' or '1/0'.\n", 0, n-1);
        
        int secret = search(n);
        
        System.out.printf("Your number is %d\n", secret);
    }

}