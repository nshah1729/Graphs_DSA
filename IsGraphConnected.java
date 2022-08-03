import java.util.ArrayList;

public class IsGraphConnected {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    /*        (3)
        (0)|----------|-----|\(4)
           |          |     | \
           |          |     |  \
           |          |     |   \
           |          |     |    \
        (1)|----------|(2)  |-----|(6)
           */
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
        boolean[] visited=new boolean[7];
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if(!visited[i]){
                ArrayList<Integer> comp=new ArrayList<>();
                dfs(graph,i,visited,comp);
                comps.add(comp);
                count++;
            }
        }
        System.out.println(comps);
        if(count==1) System.out.println("Yes Connected");
        else System.out.println("Not Connected");
    }
    static int count=0;
    public static void dfs(ArrayList<Edge>[] graph,int s,boolean[] visited,ArrayList<Integer> comp){
        visited[s]=true;
        comp.add(s);
        for(Edge e:graph[s]){
            if(!visited[e.nbr])dfs(graph,e.nbr,visited,comp);
        }
    }
}
