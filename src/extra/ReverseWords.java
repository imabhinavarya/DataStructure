package extra;

public class ReverseWords {
    public static void main(String[] args) {
        String str = "this is a java program";
        revWords(str);
    }

    private static void revWords(String str) {
        String[] s = str.split(" ");
        String ans="";
        for(String st : s){
            StringBuilder sb = new StringBuilder(st);
            ans += sb.reverse() + " ";
            char[] ch = st.toCharArray();
            for(int i=ch.length-1;i>=0;i--){
                ans += ch[i];
            }
            ans += " ";
        }
        System.out.println(ans);
    }
}
