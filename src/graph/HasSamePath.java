package graph;

import java.util.ArrayList;
import java.util.List;

public class HasSamePath {
    public static void main(String[] args) {
        int[][] edges = new int [][] {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        System.out.println(new HasSamePath().validPath(3, edges, 0, 2));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Edge(edge[0], edge[1]));
            graph.get(edge[1]).add(new Edge(edge[1], edge[0]));
        }

        boolean[] vis = new boolean[n];
        return hasPath(graph, vis, source, destination);
    }

    boolean hasPath(List<List<Edge>> graph, boolean[] vis, int src, int dest) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;

        for (Edge edge : graph.get(src)) {
            if (vis[edge.nbr] == false && hasPath(graph, vis, edge.nbr, dest)) {
                return true;
            }
        }

        return false;
    }
}
