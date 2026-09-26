/*
 * Generate Permutations Of An Array
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Recursion > Subsequences
 * Time complexity: O(2^n)*n
 * Space complexity: O(2^n)*n
 * Solved: 2026-09-26
 * URL: https://www.geeksforgeeks.org/problems/generate-permutations-of-an-array/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * brute force will be to carry a map to check for each value whether it has been used or not .
optimal will be check directly in the list , if it is already used then skip this element
 */

class Solution {
    static void helper(int[]arr,ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++){
            //if(!used[i]){
              //  used[i]=true;
              if(ds.contains(arr[i])) continue;
                ds.add(arr[i]);
               // helper(arr,ds,used,ans);
                helper(arr,ds,ans);
                ds.remove(ds.size()-1);
               // used[i]=false;
            
        }
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        //boolean [] used = new boolean[arr.length];
        //helper(arr,ds,used,ans);
        helper(arr,ds,ans);
        return ans;
    }
}
