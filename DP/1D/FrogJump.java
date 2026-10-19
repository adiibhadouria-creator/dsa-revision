class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;
        if(n==1) return 0;
        //int[] dp = new int[n];
        //if there is only one stair case then enery requird = 0;
        //for second building energy will be h[1]-h[0]
        //dp[0] = 0; 
        int prev1 = 0; 
        int prev2 = 0;
       
        //if there are less than 2 building return dp[1]
        for(int i=1;i<n;i++){
            int oneStep = Math.abs(heights[i]-heights[i-1]) + prev1;
            int twoStep = Integer.MAX_VALUE;
            if(i>1){
                twoStep = Math.abs(heights[i]-heights[i-2]) + prev2;
            }
            int curr = Math.min(oneStep,twoStep);
            prev2 = prev1;
            prev1 = curr;
        } 
        return prev1;
    }
}
