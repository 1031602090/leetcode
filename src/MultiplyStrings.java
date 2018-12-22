import java.util.ArrayList;
import java.util.List;

/**
 * @see  <a href="https://leetcode.com/problems/multiply-strings/"></a>
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("999","999"));
    }
    public static String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0') return "0";
        int c=0,t;
        if(num1.length()<num2.length()){
            String a = num1;
            num1 = num2;
            num2 = a;
        }
        String result = "0";
        StringBuilder p = new StringBuilder();
        StringBuilder q = new StringBuilder();

        for(int i=num2.length()-1;i>=0;i--){
            int a = num2.charAt(i) - '0';
            for(int j = num1.length()-1;j>=0;j--){
                t = a*(num1.charAt(j)-'0') + c;
                c = t/10;
                t = t%10;
                q.append(t);
            }
            if(c!=0) {q.append(c); c=0;}
            result=add(q.reverse().toString()+p,result);
            q = new StringBuilder();
            p.append("0");
        }
        return result;
    }

    private static String add(String a,String b){
        int c=0,x;
        StringBuilder stringBuilder = new StringBuilder();
        int i = b.length()-1;
        int j = a.length()-1;
        while (i!=-1){
            x = (a.charAt(j--)-'0')+(b.charAt(i--)-'0')+c;
            c = x/10;
            x = x%10;
            stringBuilder.append(x);
        }
        while (j!=-1){
            x = a.charAt(j--)-'0' + c;
            c = x/10;
            x = x%10;
            stringBuilder.append(x);
        }
        return c == 0 ? stringBuilder.reverse().toString() : stringBuilder.append(c).reverse().toString();
    }
}
