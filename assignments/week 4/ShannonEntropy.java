public class ShannonEntropy {
    public static void main(String[] args) {
        double entropy = 0;
        int m = Integer.parseInt(args[0]);
        int p = 0;
        double[] arr = new double[m + 1];
        int count = 0;
        while (!StdIn.isEmpty()) {
            p = StdIn.readInt();
            arr[p] += 1;
            count++;
        }
        for (int i = 1; i <= m; i++) {
            arr[i] /= count;
            if (arr[i] != 0)
                entropy -= (arr[i] * Math.log(arr[i]) / Math.log(2));
        }
        StdOut.printf("%.4f", entropy);
    }
}
