package dp;

import java.util.Arrays;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {4,5,2},
                {7,8,9}
        };
        System.out.println(minCostDp(arr));
        System.out.println(minCostMemo(arr));
        System.out.println(minCostRec(arr));
    }

    //REC
    public static int minCostRec(int[][] arr) {
        return recHelper(arr,0,0);
    }

    private static int recHelper(int[][] arr, int i, int j) {
        int m = arr.length;
        int n = arr[0].length;

        if(i==m-1 && j==n-1) {
            return arr[i][j];
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        int op1 = recHelper(arr,i+1,j);
        int op2 = recHelper(arr,i+1,j+1);
        int op3 = recHelper(arr,i,j+1);

        return arr[i][j] + Math.min(op1, Math.min(op2,op3));
    }

    //MEMO
    public static int minCostMemo(int[][] arr) {
        int[][] store = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[0].length; j++) {
                store[i][j] = -1;
            }
        }
        return memoHelper(arr,0,0, store);
    }

    public static int memoHelper(int[][] arr, int i, int j, int[][] store) {
        int m = arr.length;
        int n = arr[0].length;

        if(i==m-1 && j==n-1) {
            store[m-1][n-1] = arr[i][j];
            return store[m-1][n-1];
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(store[i][j] != -1){
            return store[i][j];
        }
        int op1 = memoHelper(arr,i+1,j,store);
        int op2 = memoHelper(arr,i+1,j+1,store);
        int op3 = memoHelper(arr,i,j+1,store);

        store[i][j] = arr[i][j] + Math.min(op1, Math.min(op2,op3));
        return store[i][j];
    }

    //DP
    public static int minCostDp(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1]=arr[m-1][n-1];

        for(int i=m-2; i>=0 ;i--){
            dp[i][n-1] = dp[i+1][n-1]+arr[i][n-1];
        }
        for(int j=n-2;j>=0;j--){
            dp[m-1][j] = dp[m-1][j+1]+arr[m-1][j];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], Math.min(dp[i+1][j+1],dp[i+1][j]));
            }
        }
        return dp[0][0];
    }
}
