package DynamicProgramming;
import java.util.*;
/**
 * Given two values M and N, which represent a matrix[M][N]. We need to find the total unique paths from the top-left
 * cell (matrix[0][0]) to the rightmost cell (matrix[M-1][N-1]).
 * */
public class GridUniquePaths {
    public static void main(String[] args) {
        int m=3;
        int n=2;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],0);
        System.out.println(gridUniquePathsTabulation(m,n,dp));
    }
    private static int gridUniquePaths(int m,int n){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        int up = gridUniquePaths(m-1,n);
        int left = gridUniquePaths(m,n-1);
        return up+left;
    }
    private static int gridUniquePathsMemoization(int m,int n,int[][]dp){
        if(m==0 && n==0) {
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1)return dp[m][n];
        int up = gridUniquePathsMemoization(m-1,n,dp);
        int left = gridUniquePathsMemoization(m,n-1,dp);
        return dp[m][n]=up+left;
    }

    private static int gridUniquePathsTabulation(int m,int n,int[][]dp){

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
