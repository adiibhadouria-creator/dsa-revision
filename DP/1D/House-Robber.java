/*
 * House Robber
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > 1D
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-19
 * URL: https://leetcode.com/problems/house-robber/submissions/2176643791/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * / approach same as pick or not Pick
    // but since adj houses cant be robbed we play with indices
    // if we are not looting the house, then we can to next adj index
    // if we are looting then we need to skip the next index
    // TC: O(n) SC: O(n)

if(index==0) return nums[0]; // if we arrived here we have to take it
        if(index<0) return 0; // can happend in index-2 case

My first approach was recursion, like pick and not pick, but there was one mistake I was making. I was taking a current sum variable, adding the current index, then moving two indices ahead and calling recursion again. While backtracking, I was removing the first, backing the index by two as I moved it by two, and then subtracting it from the current sum. I would not add anything to it, and I would call for index + 1.
The thing is, in Java, the values are passed by reference, meaning if I am passing a value, its parent will still have the same value, so we do not need to change it. That was the mistake I was making.
My approach changed a little bit. I was thinking in terms of bottom to top, but I should think of top to bottom while doing the question. How will my decision look? I will pick this element, so I will add this index and call the question for index - 2. If I do not pick, then I will directly call for index - 1. At the end, I can return the max of pick and not pick.
Now, how can I convert this into a DP solution? I can memoize it using DP, and the base cases will be:
- If index is 0, that means I have not touched index 1, so I can take index 0 to maximize my sum. If index is 0, I can add this to my sum, so I will return this.
- If index is less than 0, I will return 0.
- If dp[index] is not equal to -1, I can return dp[index].
At the end, I can return dp[index] = max of pick and not pick to update the dp array.
Now, further, we can tabularize it easily by using the base case as a bottom-to-top approach: base case as dp[0] = 0, like this. We can also space optimize it, as we are using the previous two variables only, the previous two states only.
 */

class Solution {
    // public int helper(int[]nums,int idx,int[]dp){
    //     if(idx < 0) return 0;
    //     if(idx==0) return nums[idx];
    //     if(dp[idx]!=-1) return dp[idx];

    //     int pick = nums[idx] + helper(nums,idx-2,dp);
    //     int notpick = helper(nums,idx-1,dp);
    //     return dp[idx] = Math.max(pick,notpick);    
    // }
    public int rob(int[] nums) {
        int n = nums.length; 
        //int[] dp = new int[n+1];
        //Arrays.fill(dp,-1);
        // return helper(nums,n-1,dp);
        //dp[0] = nums[0];
        int prev2 = 0;
        int prev1 = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        //return dp[n-1];
        return prev1;
    }
}
