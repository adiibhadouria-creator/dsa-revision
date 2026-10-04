/*
 * Validate Binary Search Tree
 * Platform: LeetCode
 * Difficulty: Medium
 * Topic: BST > Medium
 * Time complexity: O(h)
 * Space complexity: O(1)
 * Solved: 2026-10-04
 * URL: https://leetcode.com/problems/validate-binary-search-tree/submissions/2162034313/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * brute force-> inorder traversal of bst is sorted order always , so do a inorder traversal on this tree and add all values in list and then check in list , if it is sorted or not. If sorted return true else false
TC-> O(2n) (For traversal in tree then in list)
SC-> O(n+h) (List+Stack Space)


Optimal--
whenever we go left all nodes on left should be smaller than current and vice versa for right but the thing is we can check for current root but not for its parent or other ancestors maybe this right node is greather than current parent but maybe it is smaller than some ancestor . 
So how could we know about all of them , there comes range , have two variable max and min and every root value should lie betwee n min and max if this is true then recursively call for left and right else return false
 */

class Solution {
    public boolean check(TreeNode root,long min , long max){
        if(root == null) return true;
        if(root.val>= max || root.val<=min) return false;
        boolean left = check(root.left,min,root.val);
        boolean right = check(root.right,root.val,max);
        return left&& right;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
