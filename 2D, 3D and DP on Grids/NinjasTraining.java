class Solution {
    public int f(int day, int last, int[][] arr, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int task = 0; task < 3; task++){
                if(task != last){
                    maxi = Math.max(maxi, arr[0][task]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        if(dp[day][last] != -1) return dp[day][last];
        for(int task = 0; task < 3; task++){
            if(task != last){
                int point = arr[day][task] + f(day - 1, task, arr, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][4];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, 3, arr, dp);
    }
}

//Tabulation (bottom-up);
class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][4];
        //base cases
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        
        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;
                
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int points = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}

