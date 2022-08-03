import java.util.ArrayList;

public class FindAllPaths {
   static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i]=new ArrayList<>();
        }
        /*        (3)
     (0)|----------|-----|\(4)
        |          |     | \
        |          |     |  \
        |          |     |   \
        |          |     |    \
     (1)|----------|(2)  |-----|(6)
        */
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

        graph[4].add(new Edge(4, 6));
        graph[6].add(new Edge(6, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        int src=0;int d=6;
        boolean[] visited=new boolean[7];
        printAllPaths(graph,src,d,visited,""+src);
    }

    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int d, boolean[] visited,String psf) {
       if(src==d){
           System.out.println(psf);
           return;
       }
       visited[src]=true;
       for(Edge e:graph[src]){
           if(!visited[e.nbr])printAllPaths(graph,e.nbr,d,visited,psf+e.nbr);
       }
        visited[src]=false;
    }
}
