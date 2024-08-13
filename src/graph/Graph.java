package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
         int[][] edges = createGraph();
         printDfs(edges);
         System.out.println();
         printBfs(edges);

    }

    public static void printBfs(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                printBfsHelper(edges,visited,i);
            }
        }
    }

    private static void printBfsHelper(int[][] edges, boolean[] visited, int sv) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;

        while(!q.isEmpty()){
            Integer fv = q.poll();
            System.out.print(fv+" ");
            for(int i=0;i<edges.length;i++){
                if(edges[fv][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void printDfs(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                printDfsHelper(edges,visited,i);
            }
        }
    }

    private static void printDfsHelper(int[][] edges, boolean[] visited, int sv) {
        System.out.print(sv+" ");
        visited[sv]=true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i]==1 && !visited[i]){
                printDfsHelper(edges,visited,i);
            }
        }
    }

    public static int[][] createGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no of edges");
        int e = sc.nextInt();
        int[][] edges = new int[n][n];
        for(int i=0;i<e;i++){
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        return edges;

    }
}
