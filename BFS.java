import java.util.*;

public class BFS {
        static class Edge {
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

        Queue<Integer> q=new ArrayDeque<>();
        boolean[] visited=new boolean[7];
        q.add(0);
        while(!q.isEmpty()){
            int rem=q.poll();
            if(!visited[rem]){
                visited[rem]=true;
            }
            for(Edge e:graph[rem]){
                if(!visited[e.nbr])q.add(e.nbr);
            }
        }
    }
}
