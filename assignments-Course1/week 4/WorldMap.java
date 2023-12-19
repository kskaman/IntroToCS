public class WorldMap {
    public static void main(String[] args) {
        int n, width, height;
        width = StdIn.readInt();
        height = StdIn.readInt();
        double[] x, y;
        String dropString;
        StdDraw.setCanvasSize(width, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        while (!StdIn.isEmpty()) {
            dropString = StdIn.readString();
            n = StdIn.readInt();
            x = new double[n];
            y = new double[n];
            for (int i = 0; i < n; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
