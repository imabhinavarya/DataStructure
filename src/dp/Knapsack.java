package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] w = {6, 1, 2, 4, 5};
        int[] v = {10, 5, 4, 8, 6};
        int maxW = 5;
        System.out.println(knapRec(w,v,maxW));
    }

    private static int knapRec(int[] w, int[] v, int maxW) {
        return helper(w, v, maxW,0);
    }

    private static int helper(int[] w, int[] v, int maxW, int i) {
        if(w.length == i || maxW == 0){
            return 0;
        }
        if(w[i] > maxW){
            return helper(w,v,maxW,i+1);
        }else {
            int op1 = v[i] + helper(w,v,maxW-w[i],i+1);
            int op2 = helper(w,v,maxW,i+1);
            return Math.max(op1, op2);
        }
    }
}
