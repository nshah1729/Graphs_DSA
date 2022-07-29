public class KnightsTour {
    public static void main(String[] args) {
        int[][] a=new int[6][6];
        print(a,2,3,1);
    }
    public static void display(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] chess,int r,int c,int move){
        if(r<0||c<0||r>= chess.length||c>=chess.length||chess[r][c]!=0)return;
        else if(move== chess.length*chess.length){
            chess[r][c]=move;
            display(chess);
            chess[r][c]=0;
            return;
        }
        chess[r][c]=move;
        print(chess,r-2,c+1,move+1);
        print(chess,r-1,c+2,move+1);
        print(chess,r+1,c+2,move+1);
        print(chess,r+2,c+1,move+1);
        print(chess,r-2,c-1,move+1);
        print(chess,r-1,c-2,move+1);
        print(chess,r+2,c-1,move+1);
        print(chess,r-1,c-2,move+1);
        chess[r][c]=0;
    }
}
