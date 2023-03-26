package Recursion;
import java.util.ArrayList;
public class NBitsBinary {
    public static void main(String[] args) {
        ArrayList<String> res = solve(4);
        System.out.println(res);
    }
    private static ArrayList<String> solve(int N) {
        ArrayList<String>res=new ArrayList<String>();
        printNums("",0,0,N,res);
        return res;
    }
    private static void printNums(String s,int ones,int zeros,int n,ArrayList<String> res){
	    if(s.length()==n){
	        res.add(s);
	        return;
	    }
	    printNums(s+"1",ones+1,zeros,n,res);
	    if(ones>zeros){
	        printNums(s+"0",ones,zeros+1,n,res);
	    }
	}
    
}