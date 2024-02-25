import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int k = Integer.parseInt(args[1]);

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String title = in.readLine();
        String xLabel = in.readLine();
        String source = in.readLine();
        in.readLine();

        BarChart chart = new BarChart(title, xLabel, source);

        while (in.hasNextLine()) {
            int numberRecords = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[numberRecords];
            String year = "";
            for (int i = 0; i < numberRecords; i++) {
                String[] cityInfo = in.readLine().split(",");
                year = cityInfo[0];
                String city = cityInfo[1];
                int population = Integer.parseInt(cityInfo[3]);
                String continentArea = cityInfo[4];
                bars[i] = new Bar(city, population, continentArea);

            }
            Arrays.sort(bars);
            chart.setCaption(year);
            for (int i = numberRecords - 1; i > numberRecords - k - 1; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            in.readLine();
        }
    }
}
