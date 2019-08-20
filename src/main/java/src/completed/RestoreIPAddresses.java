package completed;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    private static List<String> res = new LinkedList<>();

    public static List<String> restoreIpAddresses(String s) {
        restoreIpAddressesHelper(s, new StringBuilder(), 0, 12);
        return res;
    }

    private static void restoreIpAddressesHelper(String s, StringBuilder t, int dots, int max) {
        int remain = s.length();
        if (remain==0 && dots == 4) {
            res.add(t.toString().substring(0, t.length() - 1));
            return;
        }
        int m = t.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() && i < 3; i++) {
            if (remain < 4 - dots)
                return;
            if (remain > max)
                continue;
            sb.append(s.charAt(i));
            if(i==1 && sb.charAt(0) == '0') return;
            if(Integer.parseInt(sb.toString()) > 255)
                break;
            t.append(sb).append(".");
            restoreIpAddressesHelper(s.substring(i + 1), t, dots + 1, 12 - i - 1);
            t.delete(m, t.length());
        }
    }
}
