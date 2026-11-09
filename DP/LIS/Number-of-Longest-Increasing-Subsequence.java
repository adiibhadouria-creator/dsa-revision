/*
 * Number of Longest Increasing Subsequence
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-11-09
 * URL: https://leetcode.com/problems/number-of-longest-increasing-subsequence/submissions/2192786622/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This approach is related to LIS, obviously. What I can say here is how I am counting the number of longest increasing subsequences. If I have the normal DP array in which I can know the length of the longest subsequences, I have to use this idea to get the count also.

The thing that can come to my mind is: if I have also seen this length before, then maybe I can increase my count of subsequences. If I have not seen this type of length before, then I can be an element for the subsequence which is coming, and I am the last element of it. Whatever count of subsequences the previous guy has at that index, I can also have that.

If there is a subsequence coming, like 1, 3, 5, and I am 7 and I ask for 5, "How many subsequences add up to you?" you say only 2, so I will also update my value to 2. I'm just adding it to it.

What if I have already seen this length? There are subsequences like 1, 3, 5, 7 and 1, 3, 4, 7. The array is 1, 3, 5, 4, 7. When I come to 7, I come from 1, I come from 3, then I come from 5. I update my length to 4. My max length at 7 can be 4. Then I come to 4, and 4 also says, "I can also give you a subsequence of length 3." Two people can give me subsequences of length 4. I should take whatever you have and whatever I have. Yes, if the count is already equal, then whatever my value is, it is, and I will also add whatever you can produce. 
 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = -1;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
               if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    } 
                    else if(dp[i]==dp[j]+1) count[i]+=count[j];
               }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen) cnt+= count[i];
        }
        return cnt;
    }
}
