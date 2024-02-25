public class PiecewiseLinearApprox {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        for (int i = 0; i <= n; i++)
            x[i] = Math.PI * i / n;
        for (int i = 0; i <= n; i++)
            y[i] = Math.sin(4 * x[i]) + Math.sin(20 * x[i]);
        StdDraw.setXscale(-1, Math.PI + 1);
        StdDraw.setYscale(-2, 2);
        for (int i = 1; i <= n; i++)
            StdDraw.line(x[i - 1], y[i - 1], x[i], y[i]);
    }
}
