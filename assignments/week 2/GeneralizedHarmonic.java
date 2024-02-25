/* The folloing code computes the sum :
   1/(1^r) + 1/(2^r) + ... + 1/(n^r) 
 */
public class GeneralizedHarmonic {
    public static void main(String[] args) {
        double sum = 0;
        double term = 0;
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        for (int i = 1; i <= n; i++) {
            term = 1/(Math.pow(i, r));
            sum += term;
        }
        System.out.println(sum);
    }
}