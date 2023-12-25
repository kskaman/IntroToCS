import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/******************************************************************************
 *  Compilation:  javac SmallWorld.java
 *  Execution:    java SmallWorld filename delimiter
 *  Dependencies: Graph.java PathFinder.java
 *  Data files:   tinyMovies.txt
 *                moviesG.txt
 *
 *  % java Performer tinyMovies.txt "/"
 *  number of vertices     =       5
 *  average degree         =   2.800
 *  average path length    =   1.300
 *  clustering coefficient =   0.767
 *
 *  % java Performer moviesG.txt "/"
 *  [ after a long time ]
 * number of vertices     =    2458
 * average degree         =  58.146
 * average path length    =   1.257
 * clustering coefficient =   0.985
 *
 ******************************************************************************/

public class Performer {

    public static void main(String[] args) throws FileNotFoundException {
        String filename  = args[0];
        String delimiter = args[1];
        Graph graph = new Graph();
        Scanner in = new Scanner(new File(filename));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                for (int j = i+1; j < names.length; j++) {
                    graph.addEdge(names[i], names[j]);
                }
            }
        }
        in.close();
        double degree  = SmallWorld.averageDegree(graph);
        double length  = SmallWorld.averagePathLength(graph);
        double cluster = SmallWorld.clusteringCoefficient(graph);
        System.out.printf("number of vertices     = %7d\n", graph.V());
        System.out.printf("average degree         = %7.3f\n", degree);
        System.out.printf("average path length    = %7.3f\n", length);
        System.out.printf("clustering coefficient = %7.3f\n", cluster);
    }
}