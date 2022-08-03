import java.util.ArrayList;
import java.util.Scanner;

public class HasPath {
    static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src,int nbr,int wt ){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[] graph=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3,10));
        graph[3].add(new Edge(3, 0,10));

        graph[0].add(new Edge(0, 1,10));
        graph[1].add(new Edge(1, 0,10));

        graph[1].add(new Edge(1, 2,10));
        graph[2].add(new Edge(2, 1,10));

        graph[3].add(new Edge(3, 2,10));
        graph[2].add(new Edge(2, 3,10));

        graph[3].add(new Edge(3, 4,10));
        graph[4].add(new Edge(4, 3,10));

        graph[4].add(new Edge(4, 5,10));
        graph[5].add(new Edge(5, 4,10));

        graph[5].add(new Edge(5, 6,10));
        graph[6].add(new Edge(6, 5,10));

        graph[4].add(new Edge(4, 6,10));
        graph[6].add(new Edge(6, 4,10));

        int s=0,d=6;
        boolean[] visited=new boolean[7];
        System.out.println(hasPath(graph,s,d,visited));

    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int s, int d, boolean[] visited) {
        if(s==d)return true;
        visited[s]=true;
        for(Edge e:graph[s]){
            if(!visited[e.nbr]){
                if(hasPath(graph,e.nbr,d,visited))return true;
            }
        }
        return false;
    }
}
