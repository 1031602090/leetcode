public class Test {
    public static void main(String[] args) {
        System.out.println(a(23,-1));
    }

    static double a(double z,int t){
        if(z==0) return 0;
        double d = 1;
        int t1 = Math.abs(t);
        while (t1>0){
            d*=z;
            t1--;
        }
        return t>0?d:1.0/d;
    }
}