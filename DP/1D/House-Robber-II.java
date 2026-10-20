/*
 * House Robber II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > 1D
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-20
 * URL: https://leetcode.com/problems/house-robber-ii/submissions/2176656992/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The edge case is if there is only one element in the array, meaning there is only one house. Then I cannot run a loop for excluding a start. That will be my edge case. If there is only one element, I will return that element. 
// The main logic for this question is that we know the first and last are adjacent and connected, and it is circular. In my answer, either there will be the 1st node or there will be the nth node. This means either the start will be in the answer, or the end will be in the answer. I can check for both: one time including the start and excluding the end, and another time including the end and excluding the start. Whichever of them is maximum will be my answer.
 */

class Solution {
    public int maxRob(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] robberyExcludingEnd = new int[n-1];
        int[] robberyExcludingStart = new int[n-1];
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if(i!=0) robberyExcludingStart[x++] = nums[i];
            if(i!=n-1) robberyExcludingEnd[y++] = nums[i];
        }
        return Math.max(maxRob(robberyExcludingStart),maxRob(robberyExcludingEnd));
    }
}
// The main logic for this question is that we know the first and last are adjacent and connected, and it is circular. In my answer, either there will be the 1st node or there will be the nth node. This means either the start will be in the answer, or the end will be in the answer. I can check for both: one time including the start and excluding the end, and another time including the end and excluding the start. Whichever of them is maximum will be my answer.
