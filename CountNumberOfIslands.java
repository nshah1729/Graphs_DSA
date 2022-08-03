public class CountNumberOfIslands {
    public static void main(String[] args) {
        int[][] m= {{0,0,1,1,1,1,1,1},
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
            for (int j = 0; j < m[0].length; j++) {
                if (!visited[i][j] && m[i][j] == 0) {
                    dfs(m,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void dfs(int[][] m, int i, int j, boolean[][] visited) {
        if(i<0||j<0||i>=m.length||j>=m[0].length||visited[i][j]||m[i][j]==1)return;
        visited[i][j]=true;
        dfs(m,i+1,j,visited);
        dfs(m,i,j+1,visited);
        dfs(m,i,j-1,visited);
        dfs(m,i-1,j,visited);
    }
}
