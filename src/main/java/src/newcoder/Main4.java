package newcoder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 陈铭
 */
public class Main4 {
    public static void main(String[] args) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Scanner sc = new Scanner(System.in);
        int flaw = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int l = 0, r = str.length() - 1;
        char[] chars = str.toCharArray();
        int max = 0;
        while (l < r) {
            while (l < r && !list.contains(chars[l])) l++;
            while (l < r && !list.contains(chars[r])) r--;
            int c = 0;
            for (int i = l + 1; i < r; i++) {
                if (!list.contains(chars[i]))
                    c++;
            }
            max = c != flaw ? max : Math.max(max, r - l + 1);
            l++;
            r--;
        }
        System.out.println(max);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char preChar = ' ';
        int c = 0;
        if (str.length() >= 100) {
            System.out.println("!error");
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int j = i + 1;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    j++;
                }
                int rep = Integer.parseInt(str.substring(i, j));
                if (j == chars.length || rep <= 2 || !Character.isLowerCase(chars[j]) || preChar == chars[j] || (j < chars.length - 1 && chars[j] == chars[j + 1])) {
                    sb = new StringBuilder("!error");
                    break;
                }
                sb.append(String.valueOf(chars[j]).repeat(rep));
                preChar = chars[j];
                i = j;
                c = 0;
            } else if (!Character.isLowerCase(chars[i])) {
                System.out.println("!error");
                return;
            } else {
                if (preChar != chars[i])
                    c = 0;
                if (c == 2) {
                    sb = new StringBuilder("!error");
                    break;
                }
                sb.append(chars[i]);
                c++;
                preChar = chars[i];
            }
        }
        System.out.println(sb.length() <= 100 ? sb : "!error");
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 2;
        while (f <= Math.sqrt(n)) {
            if (n % f == 0) {
                if (isPrime(f) && isPrime(n / f)) {
                    System.out.println(f + " " + (n / f));
                } else {
                    System.out.println("-1 -1");
                }
                return;
            }
            f++;
        }
        System.out.println("-1 -1");
    }

    private static boolean isPrime(int f) {
        for (int i = 2; i < Math.sqrt(f); i++) {
            if (f % i == 0)
                return false;
        }
        return true;
    }
}
