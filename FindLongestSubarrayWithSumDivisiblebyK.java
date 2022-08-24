public class FindLongestSubarrayWithSumDivisiblebyK {
    public static void main(String[] args) {
        int[] a={2, 7, 6, 1, 4, 5};
        int n=a.length;
        int v=3;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum=0;
                for (int k = i; k <=j; k++) {
                    sum+=a[k];
                }
                if(sum%3==0)max=Math.max(max,j-i+1);
            }
        }
        System.out.println(max);
    }
}
