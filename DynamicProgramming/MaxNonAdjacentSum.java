package DynamicProgramming;
import java.util.*;
/**
* Given an integer array arr[] return the maximum non adjacent sum
* */
public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        int[]arr={2};
        int n=arr.length;

        System.out.println(maxMonAdjacentSumTabulation(arr,n));
    }
    private static int maxMonAdjacentSum(int arr[],int n){
        if(n==0){
            return arr[n];
        }
        if(n<0)return 0;
        int take = arr[n]+maxMonAdjacentSum(arr,n-2);
        int nottake = maxMonAdjacentSum(arr,n-1);
        return Math.max(take,nottake);
    }
    private static int maxMonAdjacentSumMemoization(int arr[],int n,int[]dp){
        if(n==0) {
            return arr[n];
        }
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int take = arr[n]+maxMonAdjacentSumMemoization(arr,n-2,dp);
        int nottake = maxMonAdjacentSumMemoization(arr,n-1,dp);
        return dp[n]=Math.max(take,nottake);
    }

    private static int maxMonAdjacentSumTabulation(int[]arr,int n){
        int[]dp=new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int take = i-2>0?arr[i]+dp[i-2]:0;
            int nottake = dp[i-1];
            dp[i]=Math.max(take,nottake);
        }
        return dp[n-1];
    }
}
