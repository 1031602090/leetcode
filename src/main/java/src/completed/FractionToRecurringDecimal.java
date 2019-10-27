package completed;

import java.util.*;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int dividend, int divisor) {
        if(dividend==0)return "0";
        StringBuilder sb = new StringBuilder();
        if (divisor > 0 ^ dividend > 0) {
            sb.append("-");
        }
        long numerator = Math.abs(Long.valueOf(dividend));
        long denominator = Math.abs(Long.valueOf(divisor));
        sb.append(numerator / denominator);
        StringBuilder dem = new StringBuilder();
        long remainder = numerator % denominator;
        List<Long> remainders = new LinkedList<>();
        remainder *= 10;
        while (remainder != 0) {
            if (remainders.contains(remainder)) {
                dem.insert(remainders.indexOf(remainder), '(');
                dem.append(')');
                break;
            }
            remainders.add(remainder);
            dem.append(remainder / denominator);
            remainder %= denominator;
            remainder *= 10;
        }
        if(dem.length() != 0)
            sb.append(".").append(dem);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}
