package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer array energies , return the minimum energy with which the frog at 0 index will be able to reach the end of array
 * Assuming the frog can make at max k jumps and each jump costs abs diff of energies of the indices
 *  eg:- arr[]={10,20,30,10};k=2;
 *       10=>20=>10 = 20 =>ans
 */
public class FrogJumpKDistance {
    public static void main(String[] args) {
        int[]arr={10,20,30,10};
        int n=arr.length;
        int k=2;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(minKJumpsTabulation(arr,k,n-1));
    }
    private static int minKJumps(int[]arr,int k,int n){
        if(n==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                min=Math.min(min,Math.abs(arr[n]-arr[n-i])+minKJumps(arr,k,n-i));
            }
        }
        return min;
    }
    private static int minKJumpsMemoization(int[]arr,int k,int n,int[]dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1)return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                min=Math.min(min,Math.abs(arr[n]-arr[n-i])+minKJumpsMemoization(arr,k,n-i,dp));
            }
        }
        return dp[n]=min;
    }
    private static int minKJumpsTabulation(int[]arr,int k,int n){

        int dp[]=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    min=Math.min(min,Math.abs(arr[i]-arr[i-j])+dp[i-j]);
                }
            }
            dp[i]=min;
        }
        return dp[n-1];

    }
}
