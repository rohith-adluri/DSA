package DynamicProgramming;
/**
    PROBLEM STATEMENT
    Given an integer n , print the number of distinct ways you can climb n stairs .Each time you can either climb 1 or 2 steps
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
 */
import java.util.*;
public class ClimbStairs {
    public static void main(String[] args) {
        int n=3;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbStairsTabulation(n));
    }
    private static int climbStairs(int n){
        if(n==0){
            return 1;
        }
        int oneStep = climbStairs(n-1);
        int twoSteps = (n-2>=0)?climbStairs(n-2):0;
        return oneStep+twoSteps;
    }

    private static int climbStairsMemoization(int n,int[]dp){
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1)return dp[n];
        int oneStep = climbStairs(n-1);
        int twoSteps = (n-2>=0)?climbStairsMemoization(n-2,dp):0;
        return dp[n]=oneStep+twoSteps;
    }

    private static int climbStairsTabulation(int n){
        if(n==0){
            return 1;
        }
        int[]dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int oneStep = dp[i-1];
            int twoSteps = (i-2>=0)?dp[i-2]:0;
            dp[i]=oneStep+twoSteps;
        }
        return dp[n];
    }
}
