import java.util.Scanner;

public class MaximumIncreaseCodeForces702A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < n; i++)
            a[i]= sc.nextInt();
        int k=1;
        int max=1;
        for (int i = 0; i < n-1; i++) {
            if(a[i+1]>a[i]){
                k++;
                max=Math.max(max,k);
            }
            else k=1;
        }
        System.out.println(max);
    }
}
