import java.util.Scanner;

/******************************************************************************
 *  Compilation:  javac IndexGraph.java
 *  Dependencies: Graph.java
 *  Execution:    java IndexGraph input.txt "delimiter"
 *  Data files:   tinyGraph.txt
 *                movies.txt
 *
 *  Builds a graph, then accepts vertex names from standard input
 *  and prints its neighbors.
 *
 *  % java IndexGraph tinyGraph.txt " "
 *  C
 *    A
 *    B
 *    G
 *  A
 *    B
 *    C
 *    G
 *    H
 *  ^Z
 ******************************************************************************/

public class IndexGraph {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Incorrect number of arguments");
            System.exit(0);
        }
        // read in the graph from a file
        String filename = args[0];
        String delimiter = args[1];
        Graph G = new Graph(filename, delimiter);

        Scanner scan = new Scanner(System.in);
        // read a vertex and print its neighbors
        while (scan.hasNext()) {
            String v = scan.next();
            if (G.hasVertex(v)) {
                for (String w : G.adjacentTo(v)) {
                    System.out.println("  " + w);
                }
            }
        }
        scan.close();
    }

}