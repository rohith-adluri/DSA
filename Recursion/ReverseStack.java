package Recursion;
import java.util.*;
public class ReverseStack
{
	public static void main(String[] args) {
	    Stack<Integer>stack=new Stack<>();
	    Integer arr[]={1,2,3,4,5};
	    stack.addAll(Arrays.asList(arr));
		reverse(stack);
		System.out.println(stack);
	}
	private static void reverse(Stack<Integer>stack){
	    if(stack.size()<=1){
	        return;
	    }
	    int ele = stack.pop();
	    reverse(stack);
	    insert(stack,ele);
	}
	private static void insert(Stack<Integer>stack,int ele){
	    if(stack.size()==0){
	        stack.push(ele);
	        return;
	    }
	    int temp = stack.pop();
	    insert(stack,ele);
	    stack.push(temp);
	}
}
