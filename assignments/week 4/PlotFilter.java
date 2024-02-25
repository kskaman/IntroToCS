public class PlotFilter {
    public static void main(String[] args) {
        // Scale as per first four values
        double x0 = StdIn.readDouble();
        double x1 = StdIn.readDouble();
        double y0 = StdIn.readDouble();
        double y1 = StdIn.readDouble();
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);

        // Read the points and plot to standard drawing
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            StdDraw.point(x, y);
        }
    }
}
