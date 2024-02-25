public class ColorHSB {
    private int hue;
    private int saturation;
    private int brightness;

    // Creates a color with hue h, saturation s, and brightness b
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("arguments out of range");
        } else {
            hue = h;
            saturation = s;
            brightness = b;
        }
    }

    // Returns a string representation of this color, using the format (h, s, b)
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Returns the squared distance between two colors
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Null object");
        } else {
            int dist1 = (hue - that.hue) * (hue - that.hue);
            int dist2 = (360 - Math.abs(hue - that.hue)) * (360 - Math.abs(hue - that.hue));
            return Math.min(dist1, dist2) +
                    (saturation - that.saturation) * (saturation - that.saturation) +
                    (brightness - that.brightness) * (brightness - that.brightness);
        }
    }

    // client
    public static void main(String[] args) {
        int hue = Integer.parseInt(args[0]);
        int saturation = Integer.parseInt(args[1]);
        int brightness = Integer.parseInt(args[2]);
        ColorHSB givenColor = new ColorHSB(hue, saturation, brightness);
        int distance = 0;
        int minDistance = 0;
        ColorHSB reqColor = null;
        String reqName = null;
        ColorHSB color = null;
        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int colorH = StdIn.readInt();
            int colorS = StdIn.readInt();
            int colorB = StdIn.readInt();
            color = new ColorHSB(colorH, colorS, colorB);
            distance = givenColor.distanceSquaredTo(color);
            if (minDistance == 0) {
                minDistance = distance;
                reqColor = color;
                reqName = colorName;
            } else {
                if (minDistance > distance) {
                    minDistance = distance;
                    reqColor = color;
                    reqName = colorName;
                }
            }
        }

        System.out.println(reqName + " " + reqColor.toString());
    }
}
