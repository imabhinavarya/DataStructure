package dp;

public class EditDist {
    public static void main(String[] args) {
        String s = "abef";
        String t = "gbde";

        System.out.println(editDistDp(s,t));
        System.out.println(editDistMemo(s,t));
        System.out.println(editDistRec(s,t));
    }

    public static int editDistDp(String s, String t){
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i<=m ; i++) {
            for (int j = 1; j<=n ; j++) {
                if(s.charAt(m-i)==t.charAt(n-j)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }

        }
        return dp[m][n];
    }

    private static int editDistMemo(String s, String t) {
        int[][] store = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <s.length()+1; i++) {
            for (int j = 0; j < t.length()+1; j++) {
                store[i][j]= -1;
            }
        }
        return memoHelper(s,t,store);
    }

    private static int memoHelper(String s, String t, int[][] store) {
        int m=s.length();
        int n = t.length();
        if(m==0) {
            store[m][n]= n;
            return store[m][n];
        }
        if(n==0) {
            store[m][n]= m;
            return store[m][n];
        }
        if(store[m][n] != -1){
            return store[m][n];
        }

        if(s.charAt(0) == t.charAt(0)){
            store[m][n] = editDistRec(s.substring(1), t.substring(1));
        } else {
            int op1 = editDistRec(s, t.substring(1));
            int op2 = editDistRec(s.substring(1), t);
            int op3 = editDistRec(s.substring(1), t.substring(1));

            store[m][n] = 1 + Math.min(op1, Math.min(op2,op3));

        }
        return store[m][n];
    }

    private static int editDistRec(String s, String t) {
        if(s.length()==0) return t.length();
        if(t.length()==0) return s.length();
        if(s.charAt(0) == t.charAt(0)){
            return editDistRec(s.substring(1), t.substring(1));
        } else {
            int op1 = editDistRec(s, t.substring(1));
            int op2 = editDistRec(s.substring(1), t);
            int op3 = editDistRec(s.substring(1), t.substring(1));

            return 1 + Math.min(op1, Math.min(op2,op3));
        }
    }


}
