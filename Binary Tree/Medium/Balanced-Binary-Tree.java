/*
 * Balanced Binary Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-09-21
 * URL: https://leetcode.com/problems/balanced-binary-tree/submissions/2148405164/
 * Language: java
 *
 * Problem statement:
 * Given a binary tree, determine if it is height-balanced. Example 1: Input: root = [3,9,20,null,null,15,7] Output: true Example 2: Input: root = [1,2,2,3,3,null,null,4,4] Output: false Example 3: Input: root = [] Output: true Constraints: The number of nodes in the tree is in the range [0, 5000]. -104 <= Node.val <= 104
 *
 * Notes:
 * brute force approach will be for every node find its left height then find its right height and check if difference is greater than 1 than it is not balanced thus return false but if it is balanced check again for left and right basically same recursion on left and right nodes

Optimal Approach -> what we are doing again and again  for every left and right node finding height one time and then calling again same function . what we can avoid is i just want true or false whether left or right subtree is balanced or not so if it is balanced we will return its height else we will return -1 as we cannot return false , thus some modificatiions in height code and good to go
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int lh = dfs(root.left);
        if(lh == -1)  return -1;
        int rh = dfs(root.right);
        if(rh == -1) return -1;

        //if it is balanced i will return height
        // else i will return -1
        if(Math.abs(lh-rh)>1) return -1;
    
            return Math.max(lh,rh)+1;
        
        
    }
 }
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         //height(left)-height(right)<=1
//         if(root==null) return true;
//         int l = depth(root.left);
//         int r = depth(root.right);
//         if(Math.abs(l-r)>1) return false;
//         boolean left = isBalanced(root.left);
//         boolean right = isBalanced(root.right);

//         return left && right;

        
//     }
    // public int depth(TreeNode node){
    //     if(node==null) return 0;

    //     int left = depth(node.left);
    //     int right = depth(node.right);

    //     return Math.max(left,right) + 1;
    // }
//}
