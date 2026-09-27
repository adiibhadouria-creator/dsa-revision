/*
 * Maximum Equal Adjacent Pairs After at Most One Replacement
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: LeetCode > Weekly Contest
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-09-27
 * URL: https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/submissions/2154718111/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int count = 0;
        int best = 0;
        Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) count++;
            else{
                int x = Math.min(nums[i],nums[i+1]);
                int y = Math.max(nums[i],nums[i+1]);
                Pair<Integer,Integer> p = new Pair<>(x,y);
                map.put(p,map.getOrDefault(p,0)+1);
                best = Math.max(best,map.get(p));
            }
        } 
        return count+best;
    }
}
