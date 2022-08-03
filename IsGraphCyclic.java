import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class IsGraphCyclic {

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
//        graph[0].add(new Edge(0, 3));
//        graph[3].add(new Edge(3, 0));

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 2));
        graph[2].add(new Edge(2, 3));

//        graph[5].add(new Edge(5, 2));
//        graph[2].add(new Edge(2, 5));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

//        graph[4].add(new Edge(4, 5));
//        graph[5].add(new Edge(5, 4));

        graph[4].add(new Edge(4, 6));
        graph[6].add(new Edge(6, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
        System.out.println(isCycle(graph));

    }

    private static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[7];
//        for (int v = 0; v < graph.length; v++) {
//            if(!visited[v]) {
//                if (dfs(graph, 0, visited, -1)) {
//                    return true;
//                }
//            }
//        }
//        return false;
        return (bfs(graph,visited));
    }
    private static boolean dfs(ArrayList<Edge>[] graph, int s, boolean[] visited, int parent) {
        visited[s]=true;
        for(Edge e:graph[s]){
            if(!visited[e.nbr]) {
                if( dfs(graph, e.nbr, visited, s))return true;
            }else if(parent!=e.nbr){
                return true;
            }
        }
        return false;
    }

    private static boolean bfs(ArrayList<Edge>[] graph, boolean[] visited) {

        Queue<Integer> q=new ArrayDeque<>();
        int parent=-1;
        q.add(0);
        while(!q.isEmpty()){
            int rem=q.poll();
            if(!visited[rem]){
               visited[rem]=true;
               for(Edge e:graph[rem]){
                   if(!visited[e.nbr]){
                       q.add(e.nbr);
                       parent=rem;
                   }
               }
            }else if(parent!=rem)return true;
        }
        return false;
    }
}
