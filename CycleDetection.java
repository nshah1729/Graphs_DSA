import java.security.interfaces.EdECKey;
import java.util.*;

public class CycleDetection {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 2));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        graph[4].add(new Edge(4, 6));
        graph[6].add(new Edge(6, 4));
        boolean[] visited=new boolean[7];
        boolean cycle=false;
        for (int v = 0; v < 7; v++) {
            if(!visited[v]){
                dfs(graph,v,visited,cycle,0);
                if(cycle){
                    System.out.println("Cycle Present");
                    return;
                }
            }
        }
        System.out.println("Cycle Not Present");
    }

    private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, boolean cycle,int parent) {
        if (visited[src]&&src!=parent){
            cycle=true;
            return;
        }
            visited[src]=true;
            for (Edge e:graph[src]){
                if(!visited[e.nbr]){
                    dfs(graph,e.nbr,visited,cycle,src);
                }
            }
    }
}
