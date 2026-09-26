/*
 * Combination Sum II
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^n)*O(n)
 * Space complexity: O(N)
 * Solved: 2026-09-26
 * URL: https://leetcode.com/problems/combination-sum-ii/submissions/2153558502/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * When you consider just consider and move forward, but when you do not consider than do not consider any of it's duplicate, how you make sure it -> just Sort the array and skip all adjacent duplicate elements when you do not consider.
 */

class Solution {
    static void helper(int sum,int target,int i,int n,int[]arr,List<Integer> list,List<List<Integer>> res){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i==n || sum>target) return;
        
        sum+=arr[i];
        list.add(arr[i]);
        helper(sum,target,i+1,n,arr,list,res);

        sum-=arr[i];
        list.remove(list.size()-1);
        while(i<n-1&& arr[i]==arr[i+1]){
            i++;
        }
        helper(sum,target,i+1,n,arr,list,res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //same index cannot be used twice
        //there are also duplicates in array
        //but you should not have duplicate combinations in result
        Arrays.sort(candidates);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer> list =new ArrayList<>();
        helper(0,target,0,candidates.length,candidates, list,res);
        return res;
    }
}
