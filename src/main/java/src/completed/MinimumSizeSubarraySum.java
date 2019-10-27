package completed;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum - nums[l] > s) {
                sum -= nums[l++];
            }
        }
        return r - l + 1;
    }
}
