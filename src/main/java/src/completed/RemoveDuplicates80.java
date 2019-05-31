package completed;

import org.junit.Assert;

import java.util.Arrays;

public class RemoveDuplicates80 {
    public static void main(String[] args) {
        int[] t1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] t2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assert.assertEquals(5, removeDuplicates1(t1));
        Assert.assertEquals(7, removeDuplicates1(t2));
        System.out.println(Arrays.toString(t1));
        System.out.println(Arrays.toString(t2));
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int cIndex = 1;
        int t = 1;
        int pre = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (pre != nums[i]) {
                nums[cIndex++] = nums[i];
                pre = nums[i];
                res += t > 2 ? 2 : t;
                t = 1;
            } else if (pre == nums[i] && t < 2) {
                nums[cIndex++] = nums[i];
                t++;
            }
        }
        res += t > 2 ? 2 : t;
        return res;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int c = 1;
        int r = 0;
        int l = nums[0];
        int cIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (l == nums[i]) {
                c++;
                if (c > 2) {
                    while (i < nums.length && l == nums[i]) i++;
                    c = 2;
                }
            }
            if (i < nums.length && l != nums[i]) {
                r += c;
                c = 1;
                l = nums[i];
            }
            if (i < nums.length)
                nums[cIndex++] = nums[i];
        }
        r += c;
        return r;
    }
}