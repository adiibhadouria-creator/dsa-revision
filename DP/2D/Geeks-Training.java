/*
 * Geeks Training
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > 2D
 * Time complexity: O(12N)
 * Space complexity: O(N) +O( Nx 4). ---O(Nx4)
 * Solved: 2026-10-25
 * URL: https://www.geeksforgeeks.org/problems/geeks-training/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just dp magic
 */

class Solution {
    int func(int day,int last,int[][]matrix,int[][] dp){
        if(day==0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(maxi,matrix[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = matrix[day][i] +  func(day-1,i,matrix,dp);
                maxi = Math.max(points,maxi);
            }
        }
        return dp[day][last]=maxi;
    }
    public int maximumPoints(int mat[][]) {
        // code here
         int n = mat.length;
        int[][] dp = new int[n][4];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return func(n-1,3,mat,dp);
    }
}
