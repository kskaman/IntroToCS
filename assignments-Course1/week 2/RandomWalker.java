public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int distance = 0;
        boolean notReachedManhattain = true;
        int x = 0;
        int y = 0;
        double dir = 0.0;
        int count = 0;

        System.out.println("(" + x + ", " + y + ")");

        while (notReachedManhattain) {    
            if (r == 0) break;
            count += 1;            
            dir = Math.random();

            if (dir < 0.25) x = x + 1;
            else if (dir < 0.5) y = y + 1;
            else if (dir < 0.75) x = x - 1;
            else if (dir <= 1.0) y = y - 1;
            
            distance = Math.abs(x) + Math.abs(y);
            if (distance >= r) notReachedManhattain = false;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + count);
    }    
}
