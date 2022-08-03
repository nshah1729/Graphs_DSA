import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstra {
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
    static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf-o.wsf;
        }
    }
    public static void main(String[] args) {

        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3,40));
        graph[3].add(new Edge(3, 0,40));

        graph[0].add(new Edge(0, 1,10));
        graph[1].add(new Edge(1, 0,10));

        graph[1].add(new Edge(1, 2,10));
        graph[2].add(new Edge(2, 1,10));

        graph[3].add(new Edge(3, 2,10));
        graph[2].add(new Edge(2, 3,10));

        graph[3].add(new Edge(3, 4,2));
        graph[4].add(new Edge(4, 3,2));

        graph[4].add(new Edge(4, 5,3));
        graph[5].add(new Edge(5, 4,3));

        graph[5].add(new Edge(5, 6,3));
        graph[6].add(new Edge(6, 5,3));

        graph[4].add(new Edge(4, 6,8));
        graph[6].add(new Edge(6, 4,8));

        boolean[] visited=new boolean[7];
        PriorityQueue<Pair> q=new PriorityQueue<Pair>();
        q.add(new Pair(0,""+0,0));
        while(!q.isEmpty()){
            Pair rem=q.poll();
            if(!visited[rem.v]){
                visited[rem.v]=true;
                System.out.println(rem.v+" via "+rem.psf+"@"+rem.wsf);
                for(Edge e:graph[rem.v]){
                    if(!visited[e.nbr]){
                        q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt));
                    }
                }
            }
        }
    }
}
