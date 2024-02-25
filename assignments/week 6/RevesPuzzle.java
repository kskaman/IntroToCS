public class RevesPuzzle {
    private static void hanoi(int n, int k, String from, String sec, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, sec);
        System.out.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, sec, from, to);
    }

    private static void reves(int n, String from, String sec, String sec2, String to) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (k == 0) {
            System.out.println("Move disc " + 1 + " from " + from + " to " + to);
            return;
        }
        reves(k, from, to, sec2, sec);
        hanoi(n - k, k, from, sec2, to);
        reves(k, sec, from, sec2, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
