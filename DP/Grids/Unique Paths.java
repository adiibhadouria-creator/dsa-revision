ALL approaches from recursion -> memoization -> tabulation -> space optimisation
--------------------------------------------------------------RECURSION-------------------------------------------------------------------------
class Solution {
    int f(int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        //up or left
        int up = f(i-1,j);
        int left = f(i,j-1);

        return up+left;
    }
    public int uniquePaths(int m, int n) {
        //recursion
        return f(m-1,n-1);
    }
}
TC-> O(2^m*n) SC-> pathlength = O(m-1+n-1)
--------------------------------------------------------------MEMOIZATION-------------------------------------------------------------------------
class Solution {
    int f(int i,int j,int[][]dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        //up or left
        int up = f(i-1,j,dp);
        int left = f(i,j-1,dp);

        return dp[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {
        //recursion -> memoization
        int[][] dp = new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp);
    }
}
TC-> O(m*n) SC->O(m*n) + O(pathlength) 
--------------------------------------------------------------TABULATION-------------------------------------------------------------------------
class Solution {
    public int uniquePaths(int m, int n) {
        //recursion -> memoization -> tabularization
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            int up=0;
            int left = 0;
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
TC-> O(m*n) SC->O(m*n) 
--------------------------------------------------------------SPACE OPTIMIZAITON-----------------------------------------------------------------
  class Solution {
    public int uniquePaths(int m, int n) {
        //recursion -> memoization -> tabularization -> space optimisation
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] curr = new int[n];
            int up =0 , left = 0;
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[j]=1;
                else{
                    if(i>0) up = prev[j]; //prev  or upper row
                    if(j>0) left = curr[j-1];//prev or left col
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}
TC-> O(m*n) SC->O(n) 

