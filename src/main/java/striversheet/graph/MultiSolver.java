//package striversheet.graph;
//
//import javafx.util.Pair;
//
//import javax.swing.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//
//public class MultiSolver {
//
//
//    static class Edge {
//        int sir;
//        int nbr;
//        int wt;
//
//        Edge(int src, int nbr, int wt) {
//            this.sir = src;
//            this.nbr = nbr;
//            this.wt = wt;
//        }
//    }
//
//    static String smallestPath;
//    static Integer smallestPathWeight = Integer.MAX_VALUE;
//    static String largestPath;
//    static Integer largestPathWeight = Integer.MIN_VALUE;
//    static String ceilPath;
//    static Integer ceilPathWeight = Integer.MAX_VALUE;
//    static String fpath;
//    static Integer fpathwt = Integer.MIN_VALUE;
//    static PriorityQueue<Pair> pq = new PriorityQueue<> ();
//    public static void main(String[] args) throws Exception {
//        int vtces = 7; // 0, 1, 2, 3, 4, 5, 6
//        ArrayList<Main.Edge>[] graph = new ArrayList[7];
//        for (int i = 0; i < vtces ; i++){
//            graph[i] = new ArrayList<Main.Edge>();
//        }
//        graph[0].add(new Main.Edge(0, 3, 40));
//        graph[0].add(new Main.Edge(0, 1, 10));
//        graph[1].add(new Main.Edge(1, 0, 10));
//        graph[1].add(new Main.Edge(1, 2, 10));
//        graph[2].add(new Main.Edge(2, 3, 10));
//        graph[2].add(new Main.Edge(2, 1, 10));
//        graph[3].add(new Main.Edge(3, 0, 40));
//        graph[3].add(new Main.Edge(3, 2 , 10));
//        graph[3].add(new Main.Edge(3, 4, 2));
//        graph[4].add(new Main.Edge(4, 3, 2));
//        graph[4].add(new Main.Edge(4,
//                5, 3));
//        graph[4].add(new Main.Edge(4, 6, 3));
//        graph[5].add(new Main.Edge(5, 4, 3));
//        graph[5].add(new Main.Edge(5, 6, 3));
//        graph[6].add(new Main.Edge(6, 5, 3));
//        graph[6].add(new Main.Edge(6,
//                4, 8));
//        BufferedReader br=new BufferedReader(new  InputStreamReader(System.in));
//        int src = Integer.parseInt (br.readLine ());
//        int dest = Integer.parseInt(br.readLine ());
//        int criteria = Integer.parseInt(br.readLine());
//        int k = Integer.parseInt(br.readLine ());
//        boolean[] visited = new boolean [vtces];
//        multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
//        System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
//        System.out.println("Largest Path = " + largestPath + "@" + largestPathWeight);
//        System.out.println("Just Larger Path than " + criteria + " + path + "@" + cpathwt);
//        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@' + fpathwt);
//                System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
//    }
//    public static void multisolver(ArrayList[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int psfPath) {
//        if (src == dest) {
//// 1. Smallest Path logic
//            if (psf < smallestPathWeight) { smallestPathWeight = psf; smallestPath = psfPath; }
//
//// 2. Largest Path logic
//            if (psf > largestPathWeight) { largestPathWeight = psf; largestPath = psfPath; }
//
//// 3. Ceil Path logic (Just larger than criteria)
//            if (psf > criteria && psf < ceilPathWeight) { ceilPathWeight = psf; ceilPath = psfPath; }
//
//// 4. Floor Path logic (Just smaller than criteria)
//            if (psf < criteria && psf > floorPathWeight) { floorPathWeight = psf; floorPathWeight = psfPath; }
//
//// 5. Kth Largest Path (using PriorityQueue pq)
//            if (pq.size() < k) { pq.add(new Pair(psf, psfPath)); }
//            else if (psf > pq.peek().wsf) { pq.remove(); pq.add(new Pair(psf, psfPath)); }
//            return;
//        }
//
//        visited[src] = true;
//        for (Edge edge : graph[src]) {
//            if (!visited[edge.nbr]) {
//                multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.wt, psfPath + edge.nbr);
//            }
//        }
//        visited[src] = false; // Backtracking
//    }
//
//
//
//}
