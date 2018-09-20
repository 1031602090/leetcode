public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(mySolution(new int[]{4,5,6,7,0,1,2},0));
    }
    private static int mySolution(int[] nums, int target){
        int left=0,right=nums.length;
        int pos,t;
        while (left<right){
            pos = (left+right)/2;
            t = nums[pos];
            if(nums[left]<t && (target>=nums[left] && target<=t)){
                right = pos;
            }else {
                left = pos;
            }
        }
        return left;
    }
}
