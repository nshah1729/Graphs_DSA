import java.util.ArrayList;

public class Custom {
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
    }
}
