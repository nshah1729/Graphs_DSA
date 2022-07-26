import java.util.*;
import java.util.PriorityQueue;

public class Multisolver {
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

        graph[1].add(new Edge(1,2,10));
        graph[2].add(new Edge(2,1,10));

        graph[2].add(new Edge(2,3,10));
        graph[3].add(new Edge(3,2,10));

        graph[0].add(new Edge(0,3,40));
        graph[3].add(new Edge(3,0,40));

        graph[3].add(new Edge(3,4,2));
        graph[4].add(new Edge(4,3,2));

        graph[4].add(new Edge(4,5,3));
        graph[5].add(new Edge(5,4,3));

        graph[5].add(new Edge(5,6,3));
        graph[6].add(new Edge(6,5,3));

        graph[4].add(new Edge(4,6,8));
        graph[6].add(new Edge(6,4,8));
        int src=0;
        int dest=6;
        boolean[] visited=new boolean[7];
        multisolver(graph,src,dest,40,visited,0,""+src);
        System.out.println("largest sum path sum: "+largest);
        System.out.println("smallest sum path sum: "+smallest);
        System.out.println("ceil sum path sum: "+ceil);
        System.out.println("floor sum path sum: "+floor);
        System.out.println("3rd largest sum path sum: "+q.peek());
    }
    static int largest=Integer.MIN_VALUE;
    static int smallest=Integer.MAX_VALUE;
    static int ceil=Integer.MAX_VALUE;
    static int floor=Integer.MIN_VALUE;
    static PriorityQueue<Integer> q=new PriorityQueue<>();
    private static void multisolver(ArrayList<Edge>[] graph, int src, int dest, int i, boolean[] visited,int sum,String psf) {
        if(src==dest){
            if(sum>largest){
                largest=sum;
            }
            if(sum<smallest){
                smallest=sum;
            }
             if(sum>42&&sum<ceil){
                ceil=sum;
            }
             if(sum>floor&&sum<42){
                 floor=sum;
            }
                 if(q.isEmpty()||q.size()<3)q.add(sum);
                 else {
                     if(sum>q.peek()){
                         q.poll();
                         q.add(sum);
                     }
                 }

            return;
        }
        visited[src]=true;
        for(Edge e:graph[src]){
            if(!visited[e.nbr]){
                multisolver(graph,e.nbr,dest,42,visited,sum+e.wt,psf+e.nbr);
            }
        }
    }


}
