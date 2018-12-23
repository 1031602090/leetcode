package completed;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(mySolution(new int[]{8,7},7));
    }

    /**
     * 问题简述：在一串旋转的递增数组中找到给定值，要求复杂度低于log(n)。(旋转：源{1,2,3,4,5}->{3,4,5,1,2})
     *思路：二分查找的一种变体，在旋转后必然在中值两侧有一段是有序的
     * 1、先取中值，
     * 2、判断中值两侧那一侧为单调递增，
     * 3、若为递增，目标值是否落在该区间，若在该区间，使用二分查找即可。
     * 4、若不在该区间，执行1步骤
     * @param nums 数组
     * @param target 目标值
     * @return
     */
    private static int mySolution(int[] nums, int target){
        if(nums.length == 0) return -1;//处理特殊情况
        int left=0,right=nums.length-1;
        int pos,t;
        while (left!=right){
            pos = (left+right)/2;
            t = nums[pos];
            if(t == target) return pos;
            if(nums[left]<=t ){//判断中值左侧是否有序
                if(target>=nums[left] && target<=t)
                    right = pos - 1;
                else
                    left = pos + 1;
            }else {//右侧有序
                if(target>=t && target<=nums[right])
                    left = pos + 1;
                else
                    right = pos - 1;
            }
        }
        return nums[left]==target?left:-1;
    }
}
