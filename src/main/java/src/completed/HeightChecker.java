package completed;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] t;
        t = Arrays.copyOf(heights, heights.length);
        Arrays.sort(t);
        int c = 0;
        for(int i=0;i<heights.length;i++)
            if(heights[i] != t[i])
                c++;
        return c;
    }
}
