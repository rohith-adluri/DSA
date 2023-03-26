package Recursion;
import java.util.*;
class combinationSumUniqueLists {
    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(candidates);
        solve(res,list,candidates,target,0,candidates.length);
        return res;
    }
    private static void solve(List<List<Integer>>res,List<Integer>list,int[] candidates, int target,int index,int n){
        if(target==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<n;i++){
            if(index!=i && candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            solve(res,list,candidates,target-candidates[i],i+1,n);
            list.remove(list.size()-1);
        }
    }
}