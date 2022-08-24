import java.util.*;

public class frameworks {
    public static void main(String[] args) {
        int N = 4;
        long a[] = {1, 4, 3, 5};
        long b[] = {1, 4, 3, 5};
        int[][] ae={{0 ,0, 0, 1, 1, 1, 1, 1, 1},
                   {0, 0, 0, 0, 1, 1, 1, 1, 1},
                   {0, 0, 0, 0, 1, 1, 1, 1, 1}};

    }
    public static int rowWithMax1s(int a[][], int n, int m) {
        int i=0;
        for(;i<m;i++)
            if(a[0][i]==1)break;
        int max=m-i;
        if(i==0)return 0;
        int maxRow=0;
        for(int j=1;j<n;j++){
            if(a[j][i-1]==1){
                max+=1;
                maxRow=j;
            }
        }
        return maxRow;
    }



    public static int modified_binary_search(int [] a, int n) {
        if(n==1)return 1;
        int[] NGL=new int[n];
        NGL[0]=a[0];
        int[] NLR=new int[n];
        NLR[n-1]=a[n-1];
        for(int i=1;i<n;i++){
            if(a[i]>=NGL[i-1])NGL[i]=a[i];
            else NGL[i]=NGL[i-1];
        }
        for(int i=n-2;i>=0;i--){
            if(a[i]<=NLR[i+1])NLR[i]=a[i];
            else NLR[i]=NLR[i+1];
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            if(a[i]>NGL[i-1]&&a[i]<NLR[i+1])ans++;
        }
        if(a[0]<NLR[1])ans++;
        if(a[n-1]>NGL[n-2])ans++;
        return ans;
    }

    public static void immediateSmaller(int a[], int n) {
        int[] t=new int[n];
        t[n-1]=-1;
        t[n-2]=Math.min(a[n-1], t[n-2]);
        for(int i=n-2;i>=0;i--)
            t[i]= Math.min(a[i], t[i + 1]);
        System.out.println(Arrays.toString(t));
    }
}
