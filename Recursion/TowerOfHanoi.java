package Recursion;
public class TowerOfHanoi
{
	public static void main(String[] args) {
	    int n=5;
		solve('s','d','h',n);
	}
	private static void solve(char s,char d,char h,int n) {
	    if(n==1){
	        System.out.println("move plate "+n+" from "+s+" to "+d);
	        return;
	    }
	    solve(s,h,d,n-1);
	    System.out.println("move plate "+n+" from "+s+" to "+d);
	    solve(h,d,s,n-1);
	}
}
