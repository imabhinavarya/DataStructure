package dp;

public class Fibbonacci {
    public static void main(String[] args) {
        int n=45;
        System.out.println(fibMemo(n));
        System.out.println(fibRec(n));
        System.out.println(fibDp(n));

    }

    private static int fibDp(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int fibMemo(int n) {
        int[] store = new int[n+1];
        for(int i=0;i<=n;i++){
            store[i] = -1;
        }
        return fibMemoHelper(n,store);
    }

    private static int fibMemoHelper(int n, int[] store) {
        if(n==0 || n==1){
            store[n] = n;
            return store[n];
        }
        if(store[n] != -1){
            return store[n];
        }
        store[n] = fibMemoHelper(n-1, store) + fibMemoHelper(n-2,store);
        return store[n];
    }

    private static int fibRec(int n) {
        if(n==0 || n==1) return n;
        return fibRec(n-1)+fibRec(n-2);
    }
}
