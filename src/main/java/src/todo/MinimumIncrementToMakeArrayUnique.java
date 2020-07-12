package todo;

import java.util.Arrays;
import java.util.TreeSet;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
// 5
        set.add(7);
        set.add(8);

        System.out.println(set.ceiling(2));
//        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int c = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                c += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return c;
    }
}
