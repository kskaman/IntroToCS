public class AudioCollage {

    // Returns a new array that rescales a[]
    // by a multiplicative factor of alpha
    public static double[] amplify(double[] a, double alpha) {
        int n = a.length;
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = alpha * a[i];
        }
        return b;
    }

    // Returns a new array that is the reverse of a[]
    public static double[] reverse(double[] a) {
        int n = a.length;
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[n - i - 1];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[]
    // and b[]
    public static double[] merge(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        double[] x = new double[m + n];

        for (int i = 0; i < m; i++) {
            x[i] = a[i];
        }

        for (int i = 0; i < n; i++) {
            x[m + i] = b[i];
        }

        return x;
    }

    // Returns a new array that is sum of a[] and b[]
    // padding the shorter arrays with trailing zeros if necessary
    public static double[] mix(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        int max = m;
        if (max < n) max = n;
        double[] c = new double[max];
        for (int i = 0; i < max; i++) {
            if (i < m && i < n) c[i] = a[i] + b[i];
            else {
                if (i >= m) c[i] = b[i];
                if (i >= n) c[i] = a[i];
            }
        }
        return c;
    }

    // Returns a new array that changes the speed by the
    // given factor
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = a.length;
        n = (int) (Math.floor(n / alpha));
        double[] b = new double[n];

        for (int i = 0; i < n; i++) {
            b[i] = a[(int) (i * alpha)];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio
    // See below for the requirements
    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] scratch = StdAudio.read("scratch.wav");

        double[] doublePiano = merge(piano, piano);
        double[] pianoAndBox = mix(doublePiano,
                merge(merge(merge(beatbox, beatbox), beatbox), beatbox));
        double[] slowDial = changeSpeed(amplify(dialup, 0.2), 1.1);
        double[] revScratch = reverse(scratch);

        double[] newSound = amplify(merge(harp,
                merge(mix(merge(merge(doublePiano, pianoAndBox),
                        changeSpeed(reverse(harp), 0.45)),
                        slowDial),
                        changeSpeed(amplify(revScratch, 0.3), 3))), 0.6);

        StdAudio.play(newSound);
    }

}
