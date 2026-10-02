/*
 * Amount of Time for Binary Tree to Be Infected
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/submissions/2159722414/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * this is bfs for infection problem instead of dfs
 */

class Solution {
    int result = Integer.MIN_VALUE;
    int solve (TreeNode root , int start){
        if(root ==null) return 0;
        int lH = solve(root.left,start);
        int rH = solve(root.right,start);
        if(root.val==start){
            result = Math.max(lH,rH);
            return -1;
        }
        else if(lH>=0 && rH>=0){
            return Math.max(lH,rH)+1;
        }
        else{
            int d= Math.abs(lH)+Math.abs(rH);
            result = Math.max(result,d);
            return Math.min(lH,rH)-1;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        solve(root,start);
        return result;
    }
}
