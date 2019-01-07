/**
 * @see <a href="https://leetcode.com/problems/jump-game/"></a>
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+i >= nums.length-1) return true;
            int max = 0;
            int t = nums[i] - 1;
            int x = nums[i]+i;
            for(int j=i+1;j <= x;j++){
                if(nums[j]-t > max) {
                    i = j;
                    max = nums[j]-t;
                    i--;
                }
                t--;
            }
            if(max == 0) return false;
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if(nums.length == 0) return true;
        return true;
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{3,2,1,0};
        int[] t2 = new int[]{2,1,0,1,4};
        int[] t3 = new int[]{1,0};
        int[] t4 = new int[]{2,3,1,1,4};
        int[] t5 = new int[]{1,2,0,1};
//        System.out.println(canJump(t1));
//        System.out.println(canJump(t2));
//        System.out.println(canJump(t3));
//        System.out.println(canJump(t4));
        System.out.println(canJump(t5));
    }
}
