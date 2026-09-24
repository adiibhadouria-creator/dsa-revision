/*
 * Subsets
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^N)
 * Space complexity: O(N)
 * Solved: 2026-09-24
 * URL: https://leetcode.com/problems/subsets/submissions/2152439091/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * pick then call function then remove or backtrack then again call function
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        printSubs(0,nums,subsets,new ArrayList<>());
        return subsets;
    }
    void printSubs(int idx, int[]arr,   List<List<Integer>> subsets,List<Integer> subset){
        //base case if idx reaches beyond the array
        if(idx==arr.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        //pick
        subset.add(arr[idx]);
        printSubs(idx+1,arr,subsets,subset);
        //remove and not pick
        subset.remove(subset.size()-1);
        printSubs(idx+1,arr,subsets,subset);
    }
}
