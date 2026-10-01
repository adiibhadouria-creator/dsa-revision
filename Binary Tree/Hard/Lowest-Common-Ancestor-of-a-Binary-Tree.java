/*
 * Lowest Common Ancestor of a Binary Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Solved: 2026-10-01
 * URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/2159562569/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * brute force is find both the paths from root to p and q and store it in list then after getting both  paths iterate in them and find the lowest/deepest which will be later in the path that will be our answer.
TC-> 2 times recursion for getting paths 
1 time iterating over both the list ----O(2n)+O(n)
SC-> taking 2 lists ----O(2n)

-----Optimised----
what we can do is traverse in dfs using preorder  then whenever we get our required node we return it and whenever we get null we return null also then we call for left and right 
if any of them is null return other one , if both are null or both are some node then return that node
cases-> both are null we will return null so that further compariosn will be easy 
AND AND AND if we get both nodes that means this is the ancestor which have them both so return this ancestor
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}
