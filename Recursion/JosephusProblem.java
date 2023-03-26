package Recursion;
import java.util.*;

public class JosephusProblem {
    public static void main(String args[]){
        int n=6;
        int k=2;
        helper(n,k);
    }
    private static void helper(int n,int k){
        List<Integer>list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        solve(list,k,0);
    }
    private static void solve(List<Integer> list,int k,int index){
        if(list.size()==1){
            System.out.println(list.get(0));
            return;
        }
        // System.out.println("caming from index "+index+" and removing "+list.get((index+k-1)%list.size())+" at index "+(index+k-1)%list.size()+" and current size of list before removing is "+list.size());
        int removeIndex = (index+k-1)%list.size();
        list.remove(removeIndex);
        solve(list,k,removeIndex);
    }
}
