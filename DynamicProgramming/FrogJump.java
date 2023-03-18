package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer array energies , return the minimum energy with which the frog at 0 index will be able to reach the end of array
 * Assuming the frog can make at max 2 jumps and each jump costs abs diff of energies of the indices
 *  eg:- arr[]={10,20,30,10};
 *       10=>20=>10 = 20 =>ans
 */
public class FrogJump {
    public static void main(String[] args) {
        int[]arr={100,90,200,400,1000};
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(minJumpsTabulation(n,arr));
    }
    private static int minJumps(int n,int[]arr){
        if(n==0){
            return 0;
        }
        int oneStep = Math.abs(arr[n]-arr[n-1])+minJumps(n-1,arr);
        int twoSteps = Integer.MAX_VALUE;
        if(n-2>=0){
            twoSteps = Math.abs(arr[n]-arr[n-2])+minJumps(n-2,arr);
        }
        return Math.min(oneStep,twoSteps);
    }
    private static int minJumpsMemoization(int n,int[]arr,int[]dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1)return dp[n];
        int oneStep = Math.abs(arr[n]-arr[n-1])+minJumpsMemoization(n-1,arr,dp);
        int twoSteps = Integer.MAX_VALUE;
        if(n-2>=0){
            twoSteps = Math.abs(arr[n]-arr[n-2])+minJumpsMemoization(n-2,arr,dp);
        }
        return dp[n]=Math.min(oneStep,twoSteps);
    }

    private static int minJumpsTabulation(int n,int[]arr){
        int[]dp=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int oneStep = Math.abs(arr[i]-arr[i-1])+dp[i-1];
            int twoSteps = Integer.MAX_VALUE;
            if(i-2>=0){
                twoSteps = Math.abs(arr[i]-arr[i-2])+dp[i-2];
            }
            dp[i]=Math.min(oneStep,twoSteps);
        }

        return dp[n-1];
    }
    private static int minJumpsSpaceOptimization(int n,int[]arr){
        int prev1,prev2,curr;
        prev1=prev2=0;
        for(int i=1;i<n;i++){
            int oneStep = Math.abs(arr[i]-arr[i-1])+prev1;
            int twoSteps = Integer.MAX_VALUE;
            if(i-2>=0){
                twoSteps = Math.abs(arr[i]-arr[i-2])+prev2;
            }
            curr=Math.min(oneStep,twoSteps);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }

}
