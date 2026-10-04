/*
 * Lowest Common Ancestor of a Binary Search Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(h)
 * Space complexity: O(1)
 * Solved: 2026-10-04
 * URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/2162106311/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*conditions
        1. p>root && q>root go right
        2. p<root && q<root go left
        3. go left and right both not really , then it will be lca
        */
        if(root == null) return null;
        
        //do both of them lie on right(mean bigger than root val) then go right
        if(p.val>root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        } 
        //do both of them lie on left(mean smaller than root val) then go left
        else if(p.val<root.val && q.val < root.val){            
            return lowestCommonAncestor(root.left,p,q);
        }
        //if cant go left and right thus this is the point where i cant divide and it is my lca
        return root;
    }
}
