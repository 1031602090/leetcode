package todo;

import org.junit.Assert;

public class JumpGameII {
    public static void main(String[] args) {
        Assert.assertEquals(jump(new int[]{2,3,1,1,4}),2);
    }

    public static int jump(int[] nums) {
        int max = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i > nums.length) {
                return step + 1;
            }
            if (nums[i] + i > max) {
                max = nums[i] + i;
                step++;
            }
        }
        return step + 1;
    }

}
