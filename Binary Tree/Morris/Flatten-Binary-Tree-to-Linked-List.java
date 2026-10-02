/*
 * Flatten Binary Tree to Linked List
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Morris 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/2160598892/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * jsut figure out what will happen after breaking the link convert left child to right side
 */

class Solution {
    public void flatten(TreeNode root) {
       TreeNode curr = root;
       while(curr!=null){
            if(curr.left==null){
                
                //i have visited all left nodes now lets go to right subtree of my current parent
                curr = curr.right;
            }
            else{
                TreeNode leftChild = curr.left;
                while(leftChild.right!=null){
                    leftChild = leftChild.right;
                }
                leftChild.right = curr.right;

                TreeNode temp = curr;
                curr.right = curr.left;
                temp.left = null;
            }
       } 
    }
}
