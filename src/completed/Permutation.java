package completed;

import java.util.Arrays;
import java.util.Collections;

public class Permutation {
//    全排列算法
    private static void getPermutation(int[] a, int i){
        if(i==a.length-1){
            for (int aR : a) {
                System.out.print(aR+" ");
            }
            return;
        }
        for (int j=i;j<a.length;j++ ){
            swap(a,i,j);
            getPermutation(a,i+1);
            swap(a,j,i);
        }
    }
    /*
    *算法步骤
    * a）从后向前查找第一个相邻元素对(i,j)，并且满足A[i] < A[j]。易知，此时从j到end必然是降序。可以用反证法证明，请自行证明。
    * b）在[j,end)中寻找一个最小的k使其满足A[i]<A[k]。由于[j,end)是降序的，所以必然存在一个k满足上面条件；
    * 并且可以从后向前查找第一个满足A[i]<A[k]关系的k，此时的k必是待找的k。
    * c）将i与k交换。此时，i处变成比i大的最小元素，因为下一个全排列必须是与当前排列按照升序排序相邻的排列，故选择最小的元素替代i。
    * 易知，交换后的[j,end)仍然满足降序排序。因为在(k,end)中必然小于i，在[j,k)中必然大于k，并且大于i。
    * d）逆置[j,end) 由于此时[j,end)是降序的，故将其逆置。最终获得下一全排序。
    * 注意：如果在步骤a)找不到符合的相邻元素对，即此时i=begin，则说明当前[begin,end)为一个降序顺序，即无下一个全排列，STL的方法是将其逆置成升序。
    * */
    private static int[] nextPermutation(int[] a){
        int i,j,k = 0,min=Integer.MAX_VALUE;
        for(j=a.length-1;j>0;j--){
            if(a[j]>a[j-1]) break;
        }
        if(j==0){
            reverse(a,0,a.length-1);
            return a;
        }
        i=j-1;
        for (int t = j;t<a.length;t++){
            if(a[t]>a[i] && a[t]<min){
                min = a[t];
                k=t;
            }
        }
        swap(a,i,k);
        reverse(a,j,a.length-1);
        return a;
    }
    private static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void reverse(int[] a,int start,int end){
        for(int i=start;i<=(start+end)/2;i++){
            swap(a,i,start+end-i);
        }
    }
    public static void main(String[] args) {
        int[] t = new int[]{1,2};
        reverse(t,0,1);
        System.out.println(t[0]+"  "+t[1]);
        int[] a = nextPermutation(new int[]{1,3,2});
        for(int i:a) System.out.print(i);
    }
}
