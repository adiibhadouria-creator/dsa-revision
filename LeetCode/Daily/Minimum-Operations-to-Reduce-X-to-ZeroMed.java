/*
 * Minimum Operations to Reduce X to ZeroMed.
 * Platform: LeetCode
 * Difficulty: Hard
 * Topic: LeetCode > Daily
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-23
 * URL: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/submissions/2150301767/?envType=daily-question&envId=2026-09-23
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * same as maximum points you can obtain from cards it is like instead of finding prefix and suffix sum at any point find maxLen of sum(nums)-k this will give you minLen of subarray from start and end which equals to x
 */

class Solution {
    public int minOperations(int[] nums, int x) {
        //first find whether that sum exists or not
      //if exists return the min size of number of values
      //do not sort it , will corrupt the input
      //this is not two sum -> here it can be multiple values equal to sum
        int totalSum = 0;
        int n = nums.length;
        for(int k=0;k<n;k++){
            totalSum += nums[k];
        }

        int reqSum = totalSum - x;
        if(reqSum==0) return n;
        if(reqSum<0) return -1;
        int i=0 , j=0;
        int maxLen = -1;
        int sum = 0;
        while(j<nums.length){
            sum += nums[j];
            while(sum > reqSum){
                sum -= nums[i];
                i++;
            }
            if(sum == reqSum){
                maxLen = Math.max(maxLen,(j-i)+1);
            }
            j++;
        }
        return maxLen == -1? -1:n-maxLen;
    }
}
