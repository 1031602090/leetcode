package completed;

import org.junit.Assert;

public class AddBinary {

    public static void main(String[] args) {
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("10", addBinary("1", "1"));
        Assert.assertEquals("0", addBinary("0", "0"));
        Assert.assertEquals("1", addBinary("0", "1"));
        Assert.assertEquals("100001010", addBinary("1100101", "10100101"));
    }

    public static String addBinary(String a, String b) {
        int x, y, c = 0;
        int l = a.length() - 1;
        int m = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || l >= 0) {
            x = l >= 0 ? a.charAt(l--) & 1 : 0;
            y = m >= 0 ? b.charAt(m--) & 1 : 0;
            int t = x ^ y ^ c;
            c = x & y | x & c | y & c;
            sb.append(t);
        }
        if (c == 1) sb.append(c);
        return sb.reverse().toString();
    }
}