package todo;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{10, 0, 7,0,1}));
    }

    public int trap(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] == 0)
                continue;
            int max = -1;
            int j = i + 1;
            for (; j < height.length; j++) {
                if (height[j] >= height[i])
                    break;
                max = Math.max(max, height[j]);
            }
            if (j == height.length) {
                j--;
            }
            if (max != -1 && max < height[i])
                ans += (Math.min(height[j], height[i]) - max) * (j - i - 1);
        }
        return ans;
    }
}
