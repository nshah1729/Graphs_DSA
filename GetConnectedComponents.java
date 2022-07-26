import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetConnectedComponents {
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
        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,0,10));

        graph[2].add(new Edge(2,3,10));
        graph[3].add(new Edge(3,2,10));

        graph[4].add(new Edge(4,5,10));
        graph[5].add(new Edge(5,4,10));

        graph[5].add(new Edge(5,6,10));
        graph[6].add(new Edge(6,5,10));

        graph[4].add(new Edge(4,6,10));
        graph[6].add(new Edge(6,4,10));

        boolean[] visited=new boolean[7];
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ArrayList<Integer> comp=new ArrayList<>();
            if(!visited[i]){
                drawTree(graph,i,visited,comp);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }

    private static void drawTree(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> comp){
        visited[src]=true;
        comp.add(src);
        for(Edge e:graph[src]){
            if(!visited[e.nbr])drawTree(graph,e.nbr,visited,comp);
        }
    }
}
