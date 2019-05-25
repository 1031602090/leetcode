package completed;

/**
 * leetcode 35
 * @link https://leetcode.com/problems/search-insert-position/
 * 二分插入
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int pos = (left+right)/2;
        while (left<right){
            if(nums[pos] == target){
                return pos;
            }
            if(nums[pos] > target){
                right = pos ;
            }else {
                left = pos + 1;
            }
            pos = (left+right)/2;
        }
        if(nums[left] == target) return left;
        return (nums[left] > target) ? left : (left + 1);
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2},-10));
    }
}
