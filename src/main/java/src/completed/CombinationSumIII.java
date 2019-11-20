package completed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Helper(1,k, n, new LinkedList<>(), 0);
        return res;
    }

    private void combinationSum3Helper(int start,int depth, int target, LinkedList<Integer> temp, int sum) {
        if (depth == 0 && sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (sum + i > target)
                return;
            temp.add(i);
            combinationSum3Helper(i+1,depth - 1, target, temp, sum + i);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        new CombinationSumIII().combinationSum3(3,9).forEach(System.out::println);
    }
}
