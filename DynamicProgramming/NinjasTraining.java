package DynamicProgramming;
import java.util.*;
public class NinjasTraining {
    public static void main(String[] args) {
        int[][]points={{10, 40, 70},
                       {20, 50, 80},
                       {30, 60, 90}};
        int n= points.length;
        int last=3;
        int[][]dp=new int[n][4];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],0);
        System.out.println(ninjaTrainingTabulation(last,points));
    }
    private static int ninjaTraining(int day,int last,int[][]points) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(points[0][i], max);
                }
            }
            return max;
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                max = Math.max(points[day][i] + ninjaTraining(day - 1, i, points), max);
            }
        }
        return max;
    }
    private static int ninjaTrainingMemoization(int day,int last,int[][]points,int[][]dp) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(points[0][i], max);
                }
            }
            return max;
        }
        if(dp[day][last]!=-1)return dp[day][last];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                max = Math.max(points[day][i] + ninjaTrainingMemoization(day - 1, i, points,dp), max);
            }
        }
        return dp[day][last]=max;
    }
    private static int ninjaTrainingTabulation(int last,int[][]points) {
        int[][]dp=new int[points.length][4];
        for(int prev=0;prev<4;prev++){
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != prev) {
                    max = Math.max(points[0][i], max);
                }
            }
            dp[0][prev]=max;
        }
        for(int day=1;day<points.length;day++){
            for(int prev=0;prev<=3;prev++){
                int max = 0;
                for (int i = 0; i <3; i++) {
                    if (i != prev) {
                        max = Math.max(points[day][i] + dp[day - 1][i], max);
                    }
                }
                dp[day][prev]=max;
            }
        }

        return dp[points.length-1][last];
    }
}
