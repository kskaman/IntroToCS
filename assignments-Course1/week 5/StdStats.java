public class StdStats {
    public static double max(double[] a) {
        // Computes maximum value in a[]
        double max = a[0];
        int n = a.length;
        for (int i = 1; i < n; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    public static double min(double[] a) {
        // Computes the minimum value in a[]
        double min = a[0];
        int n = a.length;
        for (int i = 1; i < n; i++)
            if (a[i] < min) min = a[i];
        return min;
    }

    public static double mean(double[] a) {
        // Computes the mean of elements of a[]
        double avg, sum = 0.0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        avg = sum / n;
        return avg;
    }

    public static double var(double[] a) {
        // calculates the variance of elements of a[]
        double sum = 0.0;
        int n = a.length;
        double avg = mean(a);
        for (int i = 0; i < n; i++) {
            sum += (a[i] - avg) * (a[i] - avg);
        }
        return sum / (n - 1);
    }

    public static double stddev(double[] a) {
        // Computes standard deviation of elements of a[]
        return Math.sqrt(var(a));
    }

    public static void plotPoints(double[] a) {
        int n = a.length;
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setYscale(min(a) - 1, max(a) + 1);
        StdDraw.setPenRadius(1 / (3.0 * n));
        for (int i = 0; i < n; i++)
            StdDraw.point(i, a[i]);
    }

    public static void plotLines(double[] a) {
        int n = a.length;
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setYscale(min(a) - 1, max(a) + 1);
        for (int i = 1; i < n; i++)
            StdDraw.line(i - 1, a[i - 1], i, a[i]);
    }

    public static void plotBars(double[] a) {
        int n = a.length;
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setYscale(min(a) - 1, max(a) + 1);
        for (int i = 0; i < n; i++)
            StdDraw.filledRectangle(i, a[i] / 2, 0.25, a[i] / 2);
    }

    public static void main(String[] args) {
        StdOut.println("Enter an array : ");
        double[] a = StdArrayIO.readDouble1D();

        if (a.length == 1) {
            System.out.println("Please enter an array with more than 1 element !");
        } else {
            StdOut.printf(" minimum = %7.3f\n", min(a));
            StdOut.printf(" maximum = %7.3f\n", max(a));
            StdOut.printf(" mean = %7.3f\n", mean(a));
            StdOut.printf(" variance = %7.3f\n", var(a));
            StdOut.printf(" standard deviation = %7.3f\n", stddev(a));
        }
        int n = 1;
        double[] b = new double[n];
        for (int i = 0; i < n; i++)
            b[i] = 1.0 / (i + 1);

        // plotPoints(b);
        // plotLines(b);
        plotBars(b);
    }
}
