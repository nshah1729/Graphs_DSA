import java.util.ArrayList;

public class GetNumberOfIslands {
    public static void main(String[] args) {
        int[][] m={{0,0,1,1,1,1,1,1},
                   {0,0,1,1,1,1,1,1},
                   {1,1,1,1,1,1,1,0},
                   {1,1,0,0,0,1,1,0},
                   {1,1,1,1,0,1,1,0},
                   {1,1,1,1,0,1,1,0},
                   {1,1,1,1,1,1,1,0},
                   {1,1,1,1,1,1,1,0}};

        boolean[][] visited=new boolean[m.length][m[0].length];

        int count=0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(m[i][j]==0&&!visited[i][j]){
                    dfs(m,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println("There are "+count +" connected islands");

    }
    public static void display(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print( m[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] m,int i,int j,boolean[][] visited){
        if(i<0||j<0||i>=m.length||j>=m[i].length||visited[i][j]||m[i][j]==1)return;
            visited[i][j]=true;
        dfs(m,i+1,j,visited);
        dfs(m,i-1,j,visited);
        dfs(m,i,j+1,visited);
        dfs(m,i,j-1,visited);
    }
}
