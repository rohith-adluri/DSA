package Recursion;
public class Subsets
{
	public static void main(String[] args) {
		subsets("abc","");
	}
	private static void subsets(String input,String output){
	    if(input.equals("")){
	        System.out.print("'"+output+"' ");
	        return;
	    }
		subsets(input.substring(1),output+input.charAt(0));
	    subsets(input.substring(1),output);
	    
	}
}