import java.util.ArrayList;

public class PerfectFriends {
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
        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,4));

        graph[5].add(new Edge(5,6));
        graph[6].add(new Edge(6,5));


        graph[4].add(new Edge(4,6));
        graph[6].add(new Edge(6,4));

        boolean[] visited=new boolean[7];
        ArrayList<ArrayList<Integer>> comps=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            if(!visited[i]){
                ArrayList<Integer> comp=new ArrayList<>();
                dfs(graph,i,visited,comp);
                comps.add(comp);
            }
        }
//        System.out.println(comps);
        int numberOfPairs=0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i+1; j < comps.size(); j++) {
                numberOfPairs+= (comps.get(i).size()*comps.get(j).size());
            }
        }
        System.out.println(numberOfPairs);
    }

    private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
       visited[src]=true;
       comp.add(src);
       for (Edge e:graph[src]){
           if(!visited[e.nbr])dfs(graph,e.nbr,visited,comp);
       }
    }
}
