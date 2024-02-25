import java.awt.Color;

public class KernelFilter {

    private static Picture filter(Picture picture, double[][] weights) {
        int w = picture.width();
        int h = picture.height();
        int n = weights.length/2;
        Picture target = new Picture(w, h);
        double rnew = 0.0;
        double gnew = 0.0;
        double bnew = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row++) {
                for (int i = -n; i < n+1; i++) {
                    for (int j = -n; j < n+1; j++) {
                        Color color = picture.get((w + col + i) % w, (h + row + j) % h);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        rnew += r * weights[i + n][j + n];
                        gnew += g * weights[i + n][j + n];
                        bnew += b * weights[i + n][j + n];
                    }
                }
                int red = (int) Math.round(rnew);
                int green = (int) Math.round(gnew);
                int blue = (int) Math.round(bnew);
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                if (red < 0) red = 0;
                if (green < 0) green = 0;
                if (blue < 0) blue = 0;
                Color newcolor = new Color(red, green, blue);
                target.set(col, row, newcolor);
                rnew = 0.0;
                gnew = 0.0;
                bnew = 0.0;
            }
        }
        return target;
    }


    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                {1.0/16.0, 2.0/16.0, 1.0/16.0}, 
                {2.0/16.0, 4.0/16.0, 2.0/16.0}, 
                {1.0/16.0, 2.0/16.0, 1.0/16.0}
        };
        return filter(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {{0.0, -1.0, 0.0}, {-1.0, 5.0, -1.0}, {0.0, -1.0, 0.0}};
        return filter(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {{-1.0, -1.0, -1.0}, {-1.0, 8.0, -1.0}, {-1.0, -1.0, -1.0}};
        return filter(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {{-2.0, -1.0, 0.0}, {-1.0, 1.0, 1.0}, {0.0, 1.0, 2.0}};
        return filter(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++)
            kernel[i][i] = 1.0/9.0;
        return filter(picture, kernel);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        source.show();
        Picture target1 = identity(source);
        target1.show();
        Picture target2 = gaussian(source);
        target2.show();
        Picture target3 = sharpen(source);
        target3.show();
        Picture target4 = laplacian(source);
        target4.show();
        Picture target5 = emboss(source);
        target5.show();
        Picture target6 = motionBlur(source);
        target6.show();
    }

}
