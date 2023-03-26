package Recursion;
public class GenerateBalanceBrackets
{
	public static void main(String[] args) {
		generateBalanceBrackets("",0,0,3);
	}
	private static void generateBalanceBrackets(String output,int open,int close,int n){
	    if(open==n && close ==n){
	        System.out.println(output);
	        return;
	    }
	    if(open<n){
	        generateBalanceBrackets(output+"(",open+1,close,n);
	    }
	    if(close<open){
	        generateBalanceBrackets(output+")",open,close+1,n);
	    }
	}
}
