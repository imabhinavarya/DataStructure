package extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPrint {
    public static void main(String[] args) {
        char c = 'Y';
        System.out.println(printFiveChar(c));
        System.out.println(printString("a1c11b5"));
    }

    private static String printFiveChar(char c) {
        StringBuilder sb = new StringBuilder();
        int sum=(int)c;
        for(int i=0; i<5; i++){
            sb.append((char) sum);
            sum+=1;
            if((char)sum == 'z' + 1){
                sum= 65;
            }
            if((char)sum == 'Z' + 1){
                sum=97;
            }
        }
        return sb.toString();
    }

    //Print String based on their count;
    //Eg: a1b2c3   =   abbccc
    public static String printString(String s){
        Pattern p = Pattern.compile("[a-z][0-9]+");
        Matcher matcher = p.matcher(s);
        String ans = "";
        while(matcher.find()){
            String[] arr = matcher.group().split("(?<=[a-z])(?=[0-9])");
            for(int i = 0; i<Integer.parseInt(arr[1]); i++){
                ans+=arr[0];
            }
        }
        return ans;
    }
}
