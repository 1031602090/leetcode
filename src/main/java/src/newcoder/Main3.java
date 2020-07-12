package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> numsList = new ArrayList<>();
        while (sc.hasNext()) {
            numsList.add(sc.nextLine());
        }
        System.out.println(numsList.stream().map(s -> {
            String[] split = s.split("\\s");
            int[] t = new int[split.length];
            for (int i = 0; i < t.length; i++) {
                t[i] = split[i].length();
            }
            return t;
        }).map(t -> {
            if (t[0] == 1 && t[t.length - 1] == 1) {
                for (int i = 1; i < t.length - 1; i++) {
                    if (t[i] != 2)
                        return check(2, t, t.length);
                }
                return true;
            }
            if (t[0] == 2 && t[t.length - 1] == 2) {
                for (int i = 1; i < t.length - 1; i++) {
                    if (t[i] != 1)
                        return check(1, t, t.length);
                }

                return true;
            }
            if (t[0] == 1) {
                return check(2, t, t.length);
            }
            if (t[0] == 2) {
                return check(1, t, t.length);
            }
            return false;
        }).map(b -> b ? "true" : "false").collect(Collectors.joining(" ")).trim());


//        for (int i = 0; i < collect.size() - 1; i++) {
//            System.out.print(collect.get(i) + " ");
//        }
//        System.out.print(collect.get(collect.size() - 1));
    }

    /**
     * 重复检测
     *
     * @param t
     * @param end
     * @param f
     * @return
     */
    private static boolean check(int[] t, int end, int f) {

        for (int i = 1; i < end; i++) {
            if (t[i] != f)
                return false;
        }
        return true;
    }

    /**
     * 交替检测
     *
     * @param l
     * @param t
     * @param end
     * @return
     */
    private static boolean check(int l, int[] t, int end) {
        for (int i = 1; i < end; i++) {
            if (t[i] != l) {
                return false;
            } else {
                if (l == 2)
                    l = 1;
                else
                    l = 2;
            }
        }
        return true;
    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= nums[j]) {
                    if (dp[i] == 0)
                        dp[i] = dp[j] + 1;
                    else
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
