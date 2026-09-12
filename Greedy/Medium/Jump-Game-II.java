/*
 * Jump Game II
 * Difficulty: Not specified
 * Topic: Greedy > Medium
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-12
 * URL: https://leetcode.com/problems/jump-game-ii/submissions/2139999085/
 *
 * Problem statement:
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0. Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where: 0 <= j <= nums[i] and i + j < n Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1. Example 1: Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index. Example 2: Input: nums = [2,3,0,1,4] Output: 2 Constraints: 1 <= nums.length <= 104 0 <= nums[i] <= 1000 It's guaranteed that you can reach nums[n - 1].
 *
 * Notes:
 * similar as valid parentheses checking
 */

class Solution {
    /*
        We first look at everything available inside our current range
            and find the best next destination.

        "I process up to the second-last index because the last index is the destination, not a place from          which I need to jump."
    */
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;

        int jumps = 0;
        int currEnd = 0;
        int maxReach = 0;

        //Process indices till second last index
        for(int i=0;i<n-1;i++){
            maxReach = Math.max(nums[i]+i,maxReach);

            //End of current range -> that means increase jump
            if(i==currEnd){
                jumps++;
                currEnd = maxReach;
            }
        }
        return jumps;
    }
}
