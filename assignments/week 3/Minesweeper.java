public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]); // number of rows
        int n = Integer.parseInt(args[1]); // number of columns
        int k = Integer.parseInt(args[2]); // number of mines
        int mines = 0;
        char[][] gameFrame = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameFrame[i][j] = (char) (48);
            }
        }

        int mr, nr; // random numbers for placing mines
        while (mines < k) {
            mr = (int) (Math.random() * m);
            nr = (int) (Math.random() * n);

            if (gameFrame[mr][nr] == '*') 
            {    continue;  }
            else {
                gameFrame[mr][nr] = '*';
                mines++;
            }
        }

        int count = 0; // number of mines in neighbourhood

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (gameFrame[i][j] == '*') 
                    continue;
                else {
                    if ((i-1) >= 0 && gameFrame[i-1][j] == '*') {
                        count++;
                    }
                    if ((i+1) < m && gameFrame[i+1][j] == '*') {
                        count++;
                    }
                    if ((j-1) >= 0 && gameFrame[i][j-1] == '*') {
                        count++;
                    }
                    if ((j+1) < n && gameFrame[i][j+1] == '*') {
                        count++;
                    }
                    if ((i-1) >= 0 && (j-1) >= 0 && gameFrame[i-1][j-1] == '*') {
                        count++;
                    }
                    if ((i+1) < m && (j-1) >= 0 && gameFrame[i+1][j-1] == '*') {
                        count++;
                    }
                    if ((i-1) >= 0 && (j+1) < n && gameFrame[i-1][j+1] == '*') {
                        count++;
                    }
                    if ((i+1) < m && (j+1) < n && gameFrame[i+1][j+1] == '*') {
                        count++;
                    }
                    gameFrame[i][j] = (char) (48 + count);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(gameFrame[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
