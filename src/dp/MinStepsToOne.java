package dp;

import java.util.Arrays;

public class MinStepsToOne {

    private static int minStepsDp(int n){
        int[] dp = new int[n+1];
        dp[1]=0;
        for(int i=2;i<=n; i++){
            int min = dp[i-1];
            if(i%3==0){
                min = Math.min(min, dp[i/3]);
            }
            if(i%2==0){
                min = Math.min(min, dp[i/2]);
            }
            dp[i] = 1+min;
        }
        return dp[n];
    }

    public static int minStepsMemo(int n){
        int[] store = new int[n+1];
        Arrays.fill(store, -1);
        return memoHelper(n, store);
    }

    private static int memoHelper(int n, int[] store){
        if(n==1){
            store[0] = 0;
            return store[0];
        }
        if(store[n] != -1){
            return store[n];
        }
        int op1 = memoHelper(n-1, store);
        int min = op1;
        if(n%3==0){
            int op2 = memoHelper(n/3, store);
            if(op2 < min){
                min = op2;
            }
        }
        if(n%2==0){
            int op3 = memoHelper(n/2, store);
            if(min < op3){
                min = op3;
            }
        }
        return 1 + min;
    }

    public static int minStepsRec(int n){
        if(n==1){
            return 0;
        }
        int op1 = minStepsRec(n-1);
        int min = op1;
        if(n%3==0){
            int op2 = minStepsRec(n/3);
            if(op2 < min){
                min = op2;
            }
        }
        if(n%2==0){
            int op3 = minStepsRec(n/2);
            if(min < op3){
                min = op3;
            }
        }
        return 1 + min;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(minStepsDp(n));
        System.out.println(minStepsMemo(n));
        System.out.println(minStepsRec(n));
    }
}
