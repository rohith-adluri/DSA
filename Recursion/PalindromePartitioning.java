package Recursion;
import java.util.*;
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>list=new ArrayList<>();
        solve(res,list,s,0,s.length());
        return res;
    }
    private static void solve(List<List<String>>res,List<String>list,String s,int start,int end){
        //base condition
        if(start==end){
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i=start+1;i<=end;i++){
            if(isPalindrome(s.substring(start,i))){
                list.add(new String(s.substring(start,i)));
                solve(res,list,s,i,end);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
