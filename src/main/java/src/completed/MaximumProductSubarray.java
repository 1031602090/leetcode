package completed;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max,res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2}));
    }

}