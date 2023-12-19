public class Lines {
    public static void main(String[] args) {
        int n = 50;
        StdDraw.setXscale(-2, n + 2);
        StdDraw.setYscale(-2, n + 2);
        for (int i = 0; i <= n; i++) {
            StdDraw.line(0, n - i, i, 0);
        }
    }
}
