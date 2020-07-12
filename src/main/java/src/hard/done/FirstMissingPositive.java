package hard.done;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
        System.out.println(firstMissingPositive(new int[]{2, 1}));
        System.out.println(firstMissingPositive(new int[]{0, 2}));
        System.out.println(firstMissingPositive(new int[]{2, 1}));

    }

    public static int firstMissingPositive(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length || nums[i] < 1) {
                nums[i] = -1;
            } else {
                var t = nums[i];
                if (t == nums[t-1]) {
                    continue;
                }
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
                i--;
            }
        }
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}
