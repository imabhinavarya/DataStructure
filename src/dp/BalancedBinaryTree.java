package dp;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        int h = 5;
        System.out.println(noOfBalancedBTDp(h));
        System.out.println(noOfBalancedBTRec(h));
    }

    public static long noOfBalancedBTRec(int h) {
        if(h==0 || h==1) return 1;
        long x = noOfBalancedBTRec(h - 1);
        long y = noOfBalancedBTRec(h - 2);

        return (x*x) + (2*x*y);
    }

    public static long noOfBalancedBTDp(int h) {
        long[] dp = new long[h+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=h;i++){
            dp[i] = dp[i-1]*dp[i-1] + 2*dp[i-1]*dp[i-2];
        }
        return dp[h];
    }
}
