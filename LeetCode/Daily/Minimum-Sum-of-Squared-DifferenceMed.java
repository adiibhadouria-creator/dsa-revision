/*
 * Minimum Sum of Squared DifferenceMed.
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: LeetCode > Daily
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-10
 * URL: https://leetcode.com/problems/minimum-sum-of-squared-difference/submissions/2168657823/?envType=daily-question&envId=2026-10-10
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * I learnt how to avoid pq in some cases and use counting array 
 */

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int operations = k1+k2;
        int[] countOfDiff = new int[100001];
        long total = 0;
        for(int i=0;i<nums1.length;i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            countOfDiff[diff]++;
            total += diff;
        }
        if(total==0 || total<=operations) return 0;

        
        for(int i=100000;i>0 && operations>0;i--){
            int ops = Math.min(countOfDiff[i],operations);
            countOfDiff[i] -= ops;
            countOfDiff[i-1]+= ops;
            operations -=ops;
        }

        long ans = 0;
        for(int i=0;i<=100000;i++){
            ans += (long) countOfDiff[i]*i*i;
        }
        return ans;
    }
}
