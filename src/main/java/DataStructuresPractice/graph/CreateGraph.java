package DataStructuresPractice.graph;

import java.util.ArrayList;
import java.util.List;

class CreateGraph{

    // Function to add an edge between two vertices
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create a graph with 3 vertices and 3 edges
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        addEdge(adj, 1, 0);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);

        System.out.println("Adjacency List Representation:");
        displayAdjList(adj);
    }
}