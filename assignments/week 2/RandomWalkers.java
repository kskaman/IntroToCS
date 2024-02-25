public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        long trials = Integer.parseInt(args[1]);
        int distance, x, y, count;
        boolean notReachedManhattain;
        double dir = 0.0;
        double steps = 0;

        for (int i = 0; i < trials; i++) {
            notReachedManhattain = true;
            count = 0;
            x = 0;
            y = 0;
            distance = 0;
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
                
            }
            steps +=  count;
        }
        steps = steps/trials;
        System.out.println("average number of steps = " + steps);
    }    
}
