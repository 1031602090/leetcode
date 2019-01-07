/**
 * @see <a href="https://leetcode.com/problems/powx-n/"></a>
 */
public class Pow {
    public static double myPow(double x, int n) {
        long i = Math.abs(n);
        double r = 1;
        while (i>0){
            if( (i&1) == 1 ) r *= x;
            i>>=1;
            x *= x;
        }
        return n < 0 ? 1/r : r;
    }
/*
* 3^10
* 3^5 * 3^5 -> (3*3)^5-> 9^5
* 9^5
* 9^3 * 9^2 ->9*9^2*9^2-> 9*81^2
*
*
*
* */
    /*
    * 3 ^ 10
    * 9 ^ 5
    * 9 * 9^4
    * 9 * 81 * 2
    * 9 * 81 * 81 * 1
    *
    *
    *
    * */

    public static void main(String[] args) {
      /*  0.00001
        2147483647
        2.00000
-2147483648
        */
        System.out.println(myPow(2, 32));
    }
}
