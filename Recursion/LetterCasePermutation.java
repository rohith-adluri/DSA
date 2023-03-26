package Recursion;
import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {
    public static void main(String[] args) {
        List<String>res=letterCasePermutation("a1B2");
        res.stream().forEach(System.out::println);
    }
    public static List<String> letterCasePermutation(String s) {
        List<String>res=new ArrayList<>();
        solve(s,"",res);
        return res;
    }
    private static void solve(String input,String output,List<String>res){
	    if(input.length()==0){
	        res.add(output);
	        return;
	    }
	    if(!Character.isDigit(input.charAt(0))){
            if(Character.isUpperCase(input.charAt(0))){
                solve(input.substring(1),output+Character.toLowerCase(input.charAt(0)),res);
            }
            else{
                solve(input.substring(1),output+Character.toUpperCase(input.charAt(0)),res);
            }
        }
	    solve(input.substring(1),output+input.charAt(0),res);
	}
}