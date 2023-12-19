public class MaximumSquareSubmatrix {

    // Returns the size of largest contiguous square submatrix
    // of a[][] containing only ones
    public static int size(int[][] a) {
        int n = a.length;
        int[][] subMatrixCount = new int[n][n];

        for (int i = 0; i < n; i++)
            subMatrixCount[i][0] = a[i][0];
        for (int i = 0; i < n; i++)
            subMatrixCount[0][i] = a[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1)
                    subMatrixCount[i][j] = Math.min(subMatrixCount[i - 1][j],
                            Math.min(subMatrixCount[i][j - 1], subMatrixCount[i - 1][j - 1]))
                            + 1;
                else
                    subMatrixCount[i][j] = 0;
            }
        }

        int max = subMatrixCount[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (subMatrixCount[i][j] > max)
                    max = subMatrixCount[i][j];
            }
        }

        return max;
    }


    // Reads an n-by-n matrix of 0s and 1s and is from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }

        int result = size(a);
        System.out.println(result);
    }
}
