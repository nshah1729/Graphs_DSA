import java.util.ArrayList;
import java.util.Scanner;

public class Custom {

    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i]=new ArrayList<>();
        }

        /*

        |----------|-----|\
        |          |     | \
        |          |     |  \
        |          |     |   \
        |          |     |    \
        |----------|-----|-----|

        */
        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,0,10));

        graph[1].add(new Edge(1,2,10));
        graph[2].add(new Edge(2,1,10));

        graph[2].add(new Edge(2,3,10));
        graph[3].add(new Edge(3,2,10));

        graph[0].add(new Edge(0,3,10));
        graph[3].add(new Edge(3,0,10));

        graph[3].add(new Edge(3,4,10));
        graph[4].add(new Edge(4,3,10));

        graph[4].add(new Edge(4,5,10));
        graph[5].add(new Edge(5,4,10));
//
        graph[2].add(new Edge(2,5,10));
        graph[5].add(new Edge(5,2,10));

        graph[3].add(new Edge(3,5,10));
        graph[5].add(new Edge(5,3,10));

        graph[2].add(new Edge(2,4,10));
        graph[4].add(new Edge(4,2,10));
//
        graph[5].add(new Edge(5,6,10));
        graph[6].add(new Edge(6,5,10));

        graph[4].add(new Edge(4,6,10));
        graph[6].add(new Edge(6,4,10));
        int src=0,dest=6;
        boolean[] visited=new boolean[7];
//        System.out.println(hasPath(graph,src,dest,visited));
        printAllPaths(graph,src,dest,""+src,visited);
        System.out.println("There are "+count+" paths");
    }

    static int count=0;
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        if(src==dest)return true;
        else{
            visited[src]=true;
            for(Edge edge:graph[src]){
                if(!visited[edge.nbr]) {
                    if (hasPath(graph, edge.nbr, dest, visited)) return true;
                }
            }
            visited[src]=false;
        }

        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,String psf,boolean[] visited){
            if(src==dest){
                System.out.println(psf);
                count++;
                return;
            }
            visited[src]=true;
            for(Edge edge:graph[src]){
                if(!visited[edge.nbr]){
                    printAllPaths(graph,edge.nbr,dest,psf+edge.nbr,visited);
                }
            }
            visited[src]=false;
    }
}
