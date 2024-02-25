public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        if (n > 0) {
            int[] thueMorseSequence = new int[n];        
            thueMorseSequence[0] = 1;
            int divisor = 1;
            for (int i = 0; i < n ; i++) {
                if (i % divisor == 0 && i != 0)  divisor = i;
                thueMorseSequence[i] = 1 - thueMorseSequence[i % divisor];
            }
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (thueMorseSequence[j] == thueMorseSequence[i]) 
                        System.out.print("+  ");
                    else 
                        System.out.print("-  ");
                }
                System.out.println();
            }
        }
    }   
}
