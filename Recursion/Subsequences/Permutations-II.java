/*
 * Permutations II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^n) *n
 * Space complexity: O(n)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/permutations-ii/submissions/2153671549/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * After sorting, we use:
if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
    continue;

Key idea:
We want to avoid choosing the same value twice at the same recursion level, but we must allow duplicate values when they are chosen in sequence across different levels.
 */

class Solution {
    public void helper(int[]nums,boolean[]used, List<Integer> list,List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //Main line-> this ensures we ignore duplicates and also check we did not used it last time so we will not also use it this time and if we used it last time we should also use it this time
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]|| used[i]) {
                continue;
            }
            list.add(nums[i]);
            used[i]=true;
            helper(nums,used,list,res);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[]used = new boolean[nums.length];
        helper(nums,used,list,res);
        return res;
    }
}
