package completed;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public static void main(String[] args) {
        getRow(3).forEach(System.out::print);
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] t = new int[rowIndex + 1];
        t[0] = 1;
        for(int i=1;i<=rowIndex;i++){
            for(int j=i;j>=1;j--)
                t[j] += t[j-1];
        }
        List<Integer> res = new ArrayList<>();
        for(int i:t)
            res.add(i);
        return res;
    }
}
