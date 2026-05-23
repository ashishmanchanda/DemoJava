package striversheet.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class PrintAllPaths {

     static class Edge {
        int sir;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.sir = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }
            visited[src] = true;
            for (Edge edge : graph[src]) {
                if (visited[edge.nbr] == false) {
                    printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
                }
            }
        }


    public static void main(String[] args) throws Exception {
        int vces = 7; // 0, 1, 2, 3, 4, 5, 6
        ArrayList<PrintAllPaths.Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < vces; i++) {
            graph[i] = new ArrayList<PrintAllPaths.Edge>();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int edges = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new PrintAllPaths.Edge(v1, v2, wt));
            graph[v2].add(new PrintAllPaths.Edge(v2, v1, wt));
        }
        int src = Integer.parseInt(bufferedReader.readLine());
        int dest = Integer.parseInt(bufferedReader.readLine());
        boolean[] visited = new boolean[vces];
        printAllPaths(graph, src, dest, visited, src + " ");
    }
}

