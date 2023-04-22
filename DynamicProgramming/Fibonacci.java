package DynamicProgramming;
import java.util.Arrays;
public class Fibonacci {
    public static void main(String[] args) {
        int n=6;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibSpaceOptimized(n));
    }
    private static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    private static int fibMemoization(int n,int[]dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1)return dp[n];
        return dp[n]=fibMemoization(n-1,dp)+fibMemoization(n-2,dp);
    }
    private static int fibTabulation(int n){
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int fibSpaceOptimized(int n){
        int prev1=1;
        int prev2=0;
        int curr=prev1+prev2;
        for(int i=2;i<=n;i++){
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}