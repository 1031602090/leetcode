package completed;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strNum = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNum[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNum, (o1, o2) -> {
            String a = o1+o2;
            String b = o2+o1;
            return a.compareTo(b);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strNum) {
            sb.append(s);
        }
        String s = sb.toString();
        return s.startsWith("0") ? "0" : s;
    }
}
