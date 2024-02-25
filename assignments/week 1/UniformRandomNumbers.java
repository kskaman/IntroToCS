public class UniformRandomNumbers {
    public static void main(String[] args) {
        double x1 = Math.random();
        double x2 = Math.random();
        double x3 = Math.random();
        double x4 = Math.random();
        double x5 = Math.random();

        double average = (x1 + x2 + x3 + x4 + x5)/5.0;
        double min = Math.min(x1, x2);
        min = Math.min(min, x3);
        min = Math.min(min, x4);
        min = Math.min(min, x5);
        double max = Math.max(x1, x2);
        max = Math.max(max, x3);
        max = Math.max(max, x4);
        max = Math.max(max, x5);

        System.out.println("We have following five random numbers : " + x1 + " " + x2 + " " + x3 + " " + x4 + " " + x5);
        System.out.println("Average : " + average);
        System.out.println("Maximum : " + max);
        System.out.println("Minimum : " + min);
    }
}