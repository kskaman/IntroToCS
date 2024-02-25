public class TrinomialDP {
    // Returns the trinomial coefficient T(n k)
    public static long trinomial(int n, int k) {
        k = Math.abs(k);
        long[][] trinomials = new long[n+1][k+n+1];
        int colSt = Math.abs(k-n);
        int colIndex = 0;
        for (int i = 0; i <= n ; i++) {
            
            int j = colIndex;
             
            while (j <= n+k-i) {
                if (i == 0) {
                    if (j == 0) 
                        trinomials[i][j] = 1;
                    else
                        trinomials[i][j] = 0;
                }    
                else if (j == 0)
                    trinomials[i][j] = trinomials[i-1][j] + 2*trinomials[i-1][j+1];
                else
                    trinomials[i][j] = trinomials[i-1][j-1] + trinomials[i-1][j]
                        + trinomials[i-1][j+1];
             
                j++;
            }
            if (colIndex < colSt) {
                colSt--;
            }
            else
                colIndex++;
        }
        return trinomials[n][k];
    }

    // Takes two integer command-line arguments n and k
    // and prints trinomial(n, k)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
        System.out.println();
        
    }
}
