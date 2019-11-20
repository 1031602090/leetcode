package completed;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int kthLargest = new KthLargestElementInAnArray().findKthLargest(new int[]{3}, 1);
        System.out.println(kthLargest);
    }

    private int findKthLargest(int[] nums, int k) {
        int l, ll = 0, rr = nums.length - 1, r;
        int len = nums.length;
        while (true) {
            l = ll;
            r = rr;
            int t = nums[l];
            while (l < r) {
                while (r > l && nums[r] >= t) r--;
                nums[l] = nums[r];
                while (l < r && nums[l] <= t) l++;
                nums[r] = nums[l];
            }
            nums[l] = t;
            if (l == len - k)
                break;
            if (l > len - k)
                rr = l - 1;
            else
                ll = l + 1;
        }
        return nums[l];
    }
}
