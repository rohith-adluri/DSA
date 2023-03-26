package Recursion;
import java.util.*;
public class SortStack
{
	public static void main(String[] args) {
	    Stack<Integer>stack=new Stack<>();
	    Integer arr[]={9,3,4,7,2,1};
	    stack.addAll(Arrays.asList(arr));
		sort(stack);
		System.out.println(stack);
	}
	private static void sort(Stack<Integer>stack){
	    if(stack.size()<=1){
	        return;
	    }
	    int temp = stack.pop();
	    sort(stack);
	    insert(stack,temp);
	}
	private static void insert(Stack<Integer>stack,int temp){
	    if(stack.size()==0||stack.peek()<=temp){
	        stack.push(temp);
	        return;
	    }
	    int ele = stack.pop();
	    insert(stack,temp);
	    stack.push(ele);
	}
}
