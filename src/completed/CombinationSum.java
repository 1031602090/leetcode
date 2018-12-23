package completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see  <a herf="https://leetcode.com/problems/combination-sum/" />
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{8,7,4,3},11));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        return func(result,candidates,target,0, new ArrayList<>());
    }

    private static List<List<Integer>> func(List<List<Integer>> result, int[] candidates, int target, int left,List<Integer> t) {
        if(left == candidates.length) return result;
        for(int i = left;i < candidates.length ;i++){
            if(candidates[i] > target){
                return result;
            }
            if(candidates[i] == target){
                List<Integer> t1 = new ArrayList<>(t);
                t1.add(candidates[i]);
                result.add(t1);
                return result;
            }
            t.add(candidates[i]);
            func(result,candidates,target - candidates[i],i,t);
            t.remove(t.size()-1);
        }
        return result;
    }


}
