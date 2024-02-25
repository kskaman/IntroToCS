public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x, y, radius = 0.5;
        int colorCode = 1;
        StdDraw.setScale(0, n);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < n; i++) {
            y = i + radius;
            for (int j = 0; j < n; j++) {
                x = j + radius;
                if (Math.abs(i - j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(x, y, radius);
            }
        }
        StdDraw.show();
    }
}
