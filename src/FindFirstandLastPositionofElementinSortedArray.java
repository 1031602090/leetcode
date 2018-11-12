import com.google.gson.Gson;

import java.util.Arrays;

/**
 * leetcode 第34 题
 * @link  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionofElementinSortedArray {

      private static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0,right = nums.length-1;
        int pos = (left + right)/2;
        while (left < right){
            int t = nums[pos];
            if(nums[pos] == target) break;
            if(t < target){
                left = pos + 1;
            }else {
                right = pos;
            }
            pos = (left + right)/2;
        }
        if(nums.length==0 || nums[pos] != target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        System.out.println(left+" "+pos+" "+right);
        res[0] = findLeft(nums,left,pos,target);
        res[1] = findRight(nums,pos,right,target);
        return res;
    }

    private static int findRight(int[] nums, int left, int right, int target) {
        int pos = (left+right)/2;
        while (left < right){
            if(nums[pos] == target) {
                if(nums[pos+1] == target) left = pos + 1;
                else return pos;
            }
            else
                right = pos - 1;
            pos = (left+right)/2;
        }
        return left;
    }

    private static int findLeft(int[] nums, int left, int right, int target) {
        if(nums[left] == target) return left;
        int pos = (left+right)/2;
        while (left<right){
            if(nums[pos] == target){
                right = pos;
            }else
                left = pos + 1;
            pos = (left + right)/2;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 5)));
    }
    /*
    * [5,7,7,8,8,10]
8
    * */
}
