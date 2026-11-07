/*
 * Largest Divisible Subset
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: DP > LIS
 * Time complexity: O(n^2) + O(n log n)
 * Space complexity: O(n)
 * Solved: 2026-11-07
 * URL: https://leetcode.com/problems/largest-divisible-subset/submissions/2190998376/
 * Language: java
 *
 * Problem statement:
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies: answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0 If there are multiple solutions, return any of them. Example 1: Input: nums = [1,2,3] Output: [1,2] Explanation: [1,3] is also accepted. Example 2: Input: nums = [1,2,4,8] Output: [1,2,4,8] Constraints: 1 <= nums.length <= 1000 1 <= nums[i] <= 2 * 109 All the integers in nums are unique.
 *
 * Notes:
 * If i do not sort it and. check just the prev element which ever is divisible then I am just checking a single pair but the question says i have to check every pair in that subset so to maintain this monotonic property of being divisible , I will sort the array one thing that sorting makes sure that if my elements are sorted and they are suppose a,b,c,d,e,f
if(b%a==0 && c%b==0) then c will also be divided by a but if it is not sorted then I cant take guarantee for this cause if not sorted take example of 130 10 140 , 130 divides 10 lenght will be 2 then 140 divides 10 lengthh will be 3 but if this is the subset 130 10 140 this is not largest increasing subset according to question as all shoudl be divisble, so if wer sort it it will be 10 130 140 now there can be 2 subsets 1- 10 130
2 - 10 140 , so sorting helps me keeping this dividing intact
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        int [] parent = new int[n];
        int maxSubsetLength = -1;
        int curr = -1;
        Arrays.fill(parent,-1);
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int a = nums[i]%nums[j];
                int b = nums[j]%nums[i];
                if((a==0 || b==0)&& dp[j]+1>dp[i]){
                    parent[i]=j;
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i]>maxSubsetLength){
                maxSubsetLength = dp[i];
                curr= i;
            }
        }
        List<Integer> lds = new ArrayList<>();
        while(curr!=-1){
            lds.add(nums[curr]);
            curr = parent[curr];
        }
        Collections.reverse(lds);
        return lds;
    }
}
