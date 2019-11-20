package completed;

public class HouseRobberII {

    private int rob(int[] nums) {
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        return Math.max(rob(nums, 0, len - 1), rob(nums, 1, len));
    }

    private int rob(int[] nums, int s, int end) {
        int[] temp = new int[nums.length];
        temp[0] = nums[s];
        temp[1] = nums[s + 1];
        int res = Math.max(temp[0], temp[1]);
        for (int i = s + 2; i < end; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i - 1 - s; j++) {
                max = Math.max(max, temp[j]);
            }
            temp[i - s] = nums[i] + max;
            res = Math.max(res, temp[i - s]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3}));
    }
}
