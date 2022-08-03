import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPath {
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
        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 2));
        graph[2].add(new Edge(2, 3));

        graph[5].add(new Edge(5, 2));
        graph[2].add(new Edge(2, 5));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));

        graph[4].add(new Edge(4, 6));
        graph[6].add(new Edge(6, 4));

        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        HashSet<Integer> visited=new HashSet<>();
        dfs(graph,visited,0,0,""+0);

    }
    public static void dfs(ArrayList<Edge>[] graph, HashSet<Integer> visited,int s,int originalSource,String psf){
        if(visited.size()==graph.length-1){
            for(Edge e:graph[s]){
                if(e.nbr==originalSource){
                    System.out.println(psf+"*");
                    break;
                }
            }
            System.out.println(psf+".");
        }
        visited.add(s);
        for(Edge e:graph[s]){
            if(!visited.contains(e.nbr)){
                dfs(graph,visited,e.nbr,originalSource,psf+e.nbr);
            }
        }
        visited.remove(s);
    }
}
