public class Inversions {

    // Returns the number of inversions in the permutation a[]
    public static long count(int[] a) {
        long count = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j])
                    count++;
            }
        }

        return count;
    }

    // Return a permutation of length n with exactly k inversions
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;

        int index = n - 1;
        if (k > (n * (n - 1) / 2.0)) {
            k = (long) (n * (n - 1) / 2.0);
            System.out.println("Number of permutations is greater " +
                    "than possible for given length.\nThe permuatation " +
                    "with maximum inversions is  :");
        }
        while (k > 0) {
            if (k >= index) {
                a[n - index - 1] = index;
                for (int i = n - index; i < n; i++) {
                    a[i] = i - n + index;
                }
                k -= index;
                index--;
            } else {
                int p = (int) k;
                int temp = a[n - 1];
                for (int i = n - 1; i > n - p - 1; i--) {
                    a[i] = a[i - 1];
                }
                a[n - p - 1] = temp;
                break;
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command line arguments.
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
