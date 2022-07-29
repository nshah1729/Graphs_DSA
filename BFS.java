import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair{
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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

//        graph[2].add(new HamiltonianPathCycle.Edge(2, 5));
//        graph[5].add(new HamiltonianPathCycle.Edge(5, 2));

        boolean[] visited=new boolean[7];
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(2,2+""));
        while(q.size()>0){
            //r m* w a*
            Pair rem=q.remove();
            if(!visited[rem.v]){
                visited[rem.v]=true;
                System.out.println(rem.v+"@"+rem.psf);
                for(Edge e:graph[rem.v]){
                    if(!visited[e.nbr]){
                        q.add(new Pair(e.nbr,rem.psf+e.nbr));
                    }
                }
            }
        }

    }
}
