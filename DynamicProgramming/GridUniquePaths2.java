package DynamicProgramming;
import java.util.*;
/**
 * We are given an “N*M” Maze. The maze contains some obstacles. A cell is ‘blockage’ in the maze if its value is -1.
 * 0 represents non-blockage. There is no path possible through a blocked cell.
 * We need to count the total number of unique paths from the top-left corner of the maze to the bottom-right corner.
 * At every cell, we can move either down or towards the right.
 * */
public class GridUniquePaths2 {
    public static void main(String[] args) {
        int[][]grid={{0,0,0},{0,-1,0},{0,0,0}};
        int m=grid.length;
        int n=grid.length;
        int[][]dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],0);
        System.out.println(gridUniquePaths2Tabulation(m,n,grid,dp));
    }
    private static int gridUniquePaths2(int m,int n,int[][]grid){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0 || grid[m][n]==-1){
            return 0;
        }
        int up = gridUniquePaths2(m-1,n,grid);
        int left = gridUniquePaths2(m,n-1,grid);
        return up+left;
    }
    private static int gridUniquePaths2Memoization(int m,int n,int[][]grid,int[][]dp){
        if(m>=0 && n>=0 && grid[m][n]==-1)return 0;
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0 ){
            return 0;
        }
        if(dp[m][n]!=-1)return dp[m][n];
        int up = gridUniquePaths2Memoization(m-1,n,grid,dp);
        int left = gridUniquePaths2Memoization(m,n-1,grid,dp);
        return dp[m][n]=up+left;
    }

    private static int gridUniquePaths2Tabulation(int m,int n,int[][]grid,int[][]dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 || j==0){
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
