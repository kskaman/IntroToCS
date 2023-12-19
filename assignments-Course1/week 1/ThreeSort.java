public class ThreeSort {
    public static void main(String[] args) {


        double max = Math.max(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        double min = Math.min(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        //System.out.println(max + " " + min);
        max = Math.max(max, Double.parseDouble(args[2]));
        double temp = Math.min(max, Double.parseDouble(args[2]));
        //System.out.println(max + " " + temp + " " + min);

        double tempMin = Math.min(temp, min);
        temp = Math.max(temp, min);
        min = tempMin;
        //System.out.println(min + " " + temp);

        System.out.println(min + " " + temp + " " +  max);
    }
}
