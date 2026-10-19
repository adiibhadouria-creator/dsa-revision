class Solution {
    public int countWays(int n) {
        // code here
        
        if(n<2) return 1;
        int [] dp = new int[n+1];
        dp[1] = 1;//ways to climb 1 stair
        dp[2] = 2;//ways to climb 2 stairs
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
