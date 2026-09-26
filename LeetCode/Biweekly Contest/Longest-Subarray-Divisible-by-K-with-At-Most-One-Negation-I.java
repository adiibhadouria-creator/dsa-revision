/*
 * Longest Subarray Divisible by K with At Most One Negation I
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode > Biweekly Contest
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-i/submissions/2154316217/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * brute force -> use prefix sum and use map for checking whether it has been occured earlier or not---how is this derived
sum from l to r %k==0 or not
what is sum of l to r = prefix sum of r - prefix sum of l
so (ps(r)-ps(l))%k = 0.  =>  ps(r)%k - ps(l)%k ==0
ps(r)%k = ps(l)%k
just check this in map 
 */

class Solution {
    public int helper(int[]nums,int k){
        //using map for storing prefix sum 
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int key =(sum  % k + k) % k;
            if(map.containsKey(key)){
                ans = Math.max(ans,i-map.get(key));
            }
            else{
                map.put(key,i);
            }
        }
        return ans;
    }
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = helper(nums,k);
        for(int i=0;i<n;i++){
            // try by negating this element
            nums[i] = -nums[i];
            ans = Math.max(helper(nums,k),ans);
            //revert it back
            nums[i] = -nums[i];
        }
        return ans;
    }
}
