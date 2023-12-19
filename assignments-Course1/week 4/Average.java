public class Average {
    public static void main(String[] args) {
        // Average the numbers on standard input.
        double sum = 0.0;
        int n = 0;
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            sum += value;
            n++;
        }
        double average = sum / n;
        StdOut.println("Average is " + average);
    }
}
