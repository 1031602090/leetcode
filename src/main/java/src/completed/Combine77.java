package completed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @link <a href="https://leetcode.com/problems/combinations/"></a>
 */
public class Combine77 {
    public static void main(String[] args) {
        Combine77 combine = new Combine77();
        combine.combine(4,2);
        System.out.println(combine.res);
    }
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n,1,k,new LinkedList<>());
        return res;
    }
    public void combineHelper(int n,int c, int k,List<Integer> t){
        if(t.size() == k) {
            res.add(new ArrayList<>(t));
            return;
        }
        for(int i=c;i<=n;i++){
            t.add(i);
            combineHelper(n,i+1,k,t);
            t.remove(t.size()-1);
        }
    }
}