/*
 * Binary Tree Maximum Path Sum
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(H)
 * Solved: 2026-09-22
 * URL: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * same approach as diameter and check balanced just store sum as a global variaable if using brute force and also handle negatives properly
 */

class Solution {
    public int maxSum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        depthSum(root);
        return maxSum;
    }
    public int depthSum(TreeNode root){
        if(root == null) return 0;

        int leftSum = Math.max(0,depthSum(root.left));
        int rightSum =  Math.max(0,depthSum(root.right));
        
        int currentPath =leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum,currentPath);
        return root.val + Math.max(leftSum,rightSum);
    }
}

/*
--------------------BRUTE------------------------
O(N^2) AND O(2H)
class Solution {
    public int maxSum = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
       if(root == null) return 0;

       int leftSum = depthSum(root.left);
       int rightSum = depthSum(root.right);

       int sum = root.val+leftSum + rightSum;
       maxSum = Math.max(sum,maxSum);
       
       maxPathSum(root.left);
       maxPathSum(root.right);

       return maxSum;
    }
    public int depthSum(TreeNode root){
        if(root == null) return 0;

        int lSum =root.val+ depthSum(root.left);
        int rSum = root.val+ depthSum(root.right);
        int m = Math.max(lSum,rSum);
        return m > 0 ? m : 0;
    }
}
*/
