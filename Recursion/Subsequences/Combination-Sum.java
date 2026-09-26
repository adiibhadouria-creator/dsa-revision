/*
 * Combination Sum
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^t *k)
 * Space complexity: O(2^t *k)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/combination-sum/submissions/2153523685/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just see if you can choose same index again and again what will be the method
 */

class Solution {
    static void helper(int sum,int target,int i,int n,int[]arr,List<Integer> combination,List<List<Integer>> combinations){
        //i can use same index again and again
        // that means i have two choices either to take this index and not take this index in sum
        if(i==n){
            if(sum==target){
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
        if(sum>target) return;

        sum+=arr[i];
        combination.add(arr[i]);
        helper(sum,target,i,n,arr,combination,combinations);

        sum-=arr[i];
        combination.remove(combination.get(combination.size()-1));
        helper(sum,target,i+1,n,arr,combination,combinations);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(0,target,0,n,candidates,combination,combinations);
        return combinations; 
    }
}
