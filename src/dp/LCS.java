package dp;

public class LCS {
    public static void main(String[] args) {
        String s ="sacdefhin";
        String t = "sadefdweg";

        System.out.println(lcsDp(s,t));
        System.out.println(lcsMemo(s,t));
        System.out.println(lcsRec(s,t));
    }

    public static int lcsRec(String s, String t) {
        if(s.length()==0 || t.length()==0) return 0;
        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcsRec(s.substring(1), t.substring(1));
        }
        int op1 = lcsRec(s,t.substring(1));
        int op2 = lcsRec(s.substring(1),t);

        return Math.max(op1,op2);
    }

    public static int lcsMemo(String s, String t) {
        int[][] store = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j <t.length()+1; j++) {
                store[i][j] = -1;
            }
        }
        return memoHelper(s,t,store);
    }

    public static int memoHelper(String s, String t, int[][] store) {
        int m = s.length(), n = t.length();
        if(m==0 || n==0){
            store[m][n]=0;
            return store[m][n];
        }
        if (s.charAt(0) == t.charAt(0)) {
            store[m][n] = 1 + memoHelper(s.substring(1), t.substring(1),store);

        } else {
            int op1 = memoHelper(s,t.substring(1),store);
            int op2 = memoHelper(s.substring(1),t,store);
            store[m][n] = Math.max(op1,op2);
        }
        return store[m][n];
    }

    public static int lcsDp(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <=n; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if(s.charAt(m-i) == t.charAt(n-j)){
                    dp[i][j] = 1+dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
