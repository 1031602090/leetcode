package completed;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author hang
 * @see <a href="https://leetcode.com/problems/permutations/"/>
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums, 0, lists);
        return lists;
    }

    private static void permute(int[] nums, int t, List<List<Integer>> lists) {
        if (t == nums.length - 1) {
            func(nums, lists);
        }
        for (int i = t; i < nums.length; i++) {
            swap(nums, i, t);
            permute(nums, t + 1, lists);
            swap(nums, t, i);
        }
    }

    /**
     * @see <a href="https://leetcode.com/problems/permutations-ii/"></a>
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] b = new boolean[nums.length];
        permute2(nums, 0, lists);
        return lists;
    }

    private static void permute2(int[] nums, int t, List<List<Integer>> lists) {
        if (t == nums.length) {
            func(nums, lists);
            return;
        }
        HashSet<Integer> integers = new HashSet<>();
        for (int i = t; i < nums.length; i++) {
            if(integers.add(nums[i])) {
                swap(nums, i, t);
                permute2(nums, t + 1, lists);
                swap(nums, t, i);
            }
        }
    }

    private static void func(int[] nums, List<List<Integer>> lists) {
        List<Integer> integers = new ArrayList<>();
        for (int i : nums) {integers.add(i);}
        lists.add(integers);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(permute2(new int[]{0, 1, 0, 1}));
    }
}