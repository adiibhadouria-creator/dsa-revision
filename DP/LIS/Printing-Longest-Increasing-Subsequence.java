/*
 * Printing Longest Increasing Subsequence
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-11-06
 * URL: https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1#-1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
        // Code here
        int n = nums.length;
        int [] dp = new int[n];
        int [] hash = new int[n];
        int max = 1;
        int lastIdx = 0;
        Arrays.fill(dp,1);
        for(int ind = 0;ind<n;ind++){
            hash[ind]=ind;
            for(int prev= 0;prev<ind;prev++){
                if(nums[prev]<nums[ind] && dp[ind]<dp[prev]+1){
                    dp[ind] = dp[prev]+1;
                    hash[ind] = prev;
                    }
                }   
                if(dp[ind]>max){
                    max = dp[ind];
                    lastIdx= ind;
                }
            }
        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(nums[lastIdx]);
        while(hash[lastIdx]!=lastIdx){
            lastIdx = hash[lastIdx];
            LIS.add(nums[lastIdx]);
        }
        Collections.reverse(LIS);
        return LIS;
    }
}
