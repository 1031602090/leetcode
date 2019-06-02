package completed;


import org.junit.Assert;

/**
 * @link <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"></a>
 */
public class SearchInRotatedSortedArrayII81 {
    public static void main(String[] args) {
        Assert.assertTrue(search(new int[]{1, 1, 3, 1}, 3));
        Assert.assertTrue(!search(new int[]{2, 5}, -100));
        Assert.assertTrue(!search(new int[]{2, 5}, 100));
        Assert.assertTrue(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        Assert.assertTrue(!search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        Assert.assertTrue(!search(new int[]{2, 5, 6, 0, 0, 1, 2}, 100));
        Assert.assertTrue(!search(new int[]{2, 5, 6, 0, 0, 1, 2}, -100));
        Assert.assertTrue(search(new int[]{5, 2}, 2));
        Assert.assertTrue(search(new int[]{2, 5}, 5));
        Assert.assertTrue(!search(new int[]{2, 5, 6}, 8));
        Assert.assertTrue(!search(new int[]{}, 8));

    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int mid;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid] || target == nums[right] ) return true;
            if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
                ++left;
                --right;
            }else if (nums[mid] >= nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            }
        }
        return false;
    }

}
