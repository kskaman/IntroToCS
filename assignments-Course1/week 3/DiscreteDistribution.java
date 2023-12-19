public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] a = new int[n];
        int[] s = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            a[i] = Integer.parseInt(args[i]);
            sum += a[i];
            s[i] = sum;
        }

        int r;

        for (int i = 0; i < m; i++) {
            r = (int) (Math.random() * s[n-1]);
            for (int j = 1; j < n; j++) {
                if ((r >= s[j-1]) && (r < s[j])) {
                    System.out.print(j + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
} 