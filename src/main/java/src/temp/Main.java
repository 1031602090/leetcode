package temp;

public class Main {
    public static void main(String[] args) {
        System.out.println(func(Integer.MAX_VALUE));
    }

    static String func(int nums) {
        int base = 'a' - 1;
        StringBuilder sb = new StringBuilder();
        while (nums > 0) {
            int r = nums % 26;
            nums /= 26;
            if (r == 0) {
                nums--;
                r = 26;
            }
            sb.append((char) (r + base));
        }
        return sb.reverse().toString();
    }
}