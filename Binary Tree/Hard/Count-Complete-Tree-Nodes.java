/*
 * Count Complete Tree Nodes
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(log^2 n)
 * Space complexity: O(1)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/count-complete-tree-nodes/submissions/2159770695/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * perfect binary tree has nodes = (2^height)-1 but this is complete so we check for ecery node left and right if they are equal means it is perfect then we will return direct formula else i will divide this problem into sub parts passing left and right heads to method itself
 */

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lh = goLeft(root);
        int rh = goRight(root);

        if(lh==rh) return (1<<lh)-1;
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
    int goLeft(TreeNode root){
        TreeNode temp = root;
        int lc=0;
        while(temp!=null){
            lc++;
            temp = temp.left;
        }
        return lc;
    }
    int goRight(TreeNode root){
        TreeNode temp = root;
        int rc=0;
        while(temp!=null){
            rc++;
            temp = temp.right;
        }
        return rc;
    }
}
