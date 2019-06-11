package completed;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hang
 * @link <a href="https://leetcode.com/problems/decode-ways/"></a>
  */
public class SubsetsII90 {


    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,3});
        System.out.println(integers);
    }

    private static List<List<Integer>> integers = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        integers.add(Collections.emptyList());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            subsetsWithDupHelper(nums, 0, i + 1, new ArrayList<>());
        }
        return integers;
    }

    private static void subsetsWithDupHelper(int[] nums, int start, int len, ArrayList<Integer> objects) {
        if (len == 0) {
            integers.add(new ArrayList<>(objects));
            return;
        }
        for (int i = start; i < nums.length - len + 1; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            objects.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, len - 1, objects);
            objects.remove(objects.size() - 1);
        }
    }
}
