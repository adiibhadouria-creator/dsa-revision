/*
 * Subsets II
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^n)*n
 * Space complexity: O(2^n)*k
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/subsets-ii/submissions/2153593471/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    static void helper(int i,int[]arr, List<Integer> subset,List<List<Integer>> subsets){
        if(i==arr.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(arr[i]);
        helper(i+1,arr,subset,subsets);
        
        subset.remove(subset.size()-1);
        while(i<arr.length-1 && arr[i]==arr[i+1]){
            i++;
        }
        helper(i+1,arr,subset,subsets);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,subset,subsets);
        return subsets;
    }
}
