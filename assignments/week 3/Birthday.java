public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double[] fraction = new double[n];
        fraction[0] = 0;
        int i = 0; // number of trial being done
        boolean isBirthSame = false;
        int[] count = new int[n];
        count[0] = 0;
        int[] birthday = new int[n];

        while (i < trials) {

            int j = 0;
            isBirthSame = false;
            while (!isBirthSame && j < n) {
                birthday[j] = (int) (Math.random() * (n-1));
                for (int k = j-1; k >= 0; k--) {
                    if (birthday[j] == birthday[k]) {
                        isBirthSame = true;
                        count[j]++;
                        break;
                    }
                }
                j++;
            }
            i++;
        }

        for (int k = 0; k < n; k++) {
            for (int m = 0; m <= k; m++) {
                fraction[k] += count[m];
            }
            fraction[k] = fraction[k]/trials;
        }

        for (int k = 0; k < n; k++) {
            System.out.println((k+1) + "\t" + count[k] + "\t" + fraction[k]);
            if (fraction[k] >= 0.5)
                break;
        }
    }
}
