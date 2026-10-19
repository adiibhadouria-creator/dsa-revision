class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int min = 10001;
            for(int j=1;j<=k;j++){
                int jump = i-j;
                if(jump>=0){
                    int jumpEnergy = dp[jump] + Math.abs(heights[i]-heights[jump]);
                    min = Math.min(min,jumpEnergy);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];

    }
}
