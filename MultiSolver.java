import java.util.*;

public class MultiSolver {
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

    graph[4].add(new Edge(4, 6,8));
    graph[6].add(new Edge(6, 4,8));

    graph[5].add(new Edge(5, 6,3));
    graph[6].add(new Edge(6, 5,3));

    boolean[] visited=new boolean[7];
    PriorityQueue<Integer> q=new PriorityQueue<>();
    multiSolver(graph,0,6,visited,0,""+0,q);
    System.out.println("Smallest Path: "+ smallestPath+"@"+smallest);
    System.out.println("Largest Path: "+ largestPath+"@"+largest);
    System.out.println("Ceil Path @ 40 : "+ CeilPath+"@"+ceil40);
    System.out.println("Floor Path @ 40 : "+ FloorPath+"@"+floor40);
    System.out.println("Third Largest Path : "+ thirdLargestPath+"@"+q.poll());

  }
  static int smallest=Integer.MAX_VALUE;
  static int largest=Integer.MIN_VALUE;

  static int ceil40=Integer.MAX_VALUE;
  static int floor40=Integer.MIN_VALUE;

  static String smallestPath="";
  static String largestPath="";
  static String CeilPath="";
  static String FloorPath="";
  static String thirdLargestPath="";
  public static void multiSolver(ArrayList<Edge>[] graph,int src,int d,boolean[] visited,int wsf,String psf,PriorityQueue<Integer> q){

    if(src==d){
      if(wsf<smallest){
        smallestPath=psf;
        smallest=wsf;
      }
      if(wsf>largest){
        largestPath=psf;
        largest=wsf;
      }
      if(wsf>40&&wsf<ceil40){
        ceil40=wsf;
        CeilPath=psf;
      }
      if(wsf<40&&wsf>floor40){
        floor40=wsf;
        FloorPath=psf;
      }
      if(q.size()<3){
        q.add(wsf);
        thirdLargestPath=psf;
      }else if(q.peek()<wsf){
        q.poll();
        q.add(wsf);
        thirdLargestPath=psf;
      }
    }
    visited[src]=true;
    for(Edge e:graph[src]){
      if(!visited[e.nbr])multiSolver(graph,e.nbr,d,visited,wsf+e.wt,psf+e.nbr,q);
    }
    visited[src]=false;
  }
}
