package leetCode.leetCode_500;

public class leetCode_343_整数拆分 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(integerBreak(n));
    }

    private static int integerBreak(int n) {
        int []dp=new int[n+1];
        for (int i = 2; i <= n; i++) {
            int curMax=0;
            for (int j = 1; j < i; j++) {
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;
        }
        return dp[n];
    }
}
