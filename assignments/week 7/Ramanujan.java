public class Ramanujan {
    public static boolean isRamanujan(long n) {
        int cubeRootN = (int) Math.cbrt(n);
        int count = 0;
        int startIndex = cubeRootN;
        int start = startIndex;
        int end = 0;
        int middle = 0;

        while (count < 2) {
            if (start - end <= 1) {
                startIndex--;
                start = startIndex;
                end = 0;
                continue;
            }

            if (startIndex * startIndex * startIndex + (startIndex - 1) * (startIndex - 1) * (startIndex - 1) < n)
                break;

            middle = (start + end) / 2;

            double cubeSum = startIndex * startIndex * startIndex + middle * middle * middle;
            if (cubeSum == n) {
                count++;
                startIndex--;
                start = startIndex;
                end = 0;
                continue;
            } else if (cubeSum > n) {
                start = middle;
            } else {
                end = middle;
            }

        }

        if (count < 2)
            return false;

        return true;
    }

    // Takes a long integer command line argument n and prints
    // true if n is a ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        boolean result = isRamanujan(n);
        System.out.println(result);
    }
}
