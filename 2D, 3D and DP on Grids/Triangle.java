//Code 360
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int min(int i, int j, int[][] triangle, int[][] dp, int n){
        if(i == n - 1) return triangle[n - 1][j];
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + min(i + 1, j, triangle, dp, n);
        int diag = triangle[i][j] + min(i + 1, j + 1, triangle, dp, n);

        return dp[i][j] = Math.min(down, diag);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return min(0, 0, triangle, dp, n);
    }
}

//Tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) dp[n-1][j] = triangle[n-1][j];

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + dp[i + 1][j];
                int diag = triangle[i][j] + dp[i + 1][j + 1];
                
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}

//Space Optimization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        int[] prev = new int[n];
        for(int j = 0; j < n; j++) prev[j] = triangle[n-1][j];

        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[n];
            for(int j = i; j >= 0; j--){
                int down = triangle[i][j] + prev[j];
                int diag = triangle[i][j] + prev[j + 1];
                
                curr[j] = Math.min(down, diag);
            }
            prev = curr;
        }
        return prev[0];
    }
}

