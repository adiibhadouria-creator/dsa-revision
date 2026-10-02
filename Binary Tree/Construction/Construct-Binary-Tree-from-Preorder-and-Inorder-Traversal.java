/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Construction
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/2159938709/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    int idx =0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length-1);
    }
    public TreeNode build(int[]preorder,int[]inorder,int start,int end){
        if(start>end) return null;

        int val = preorder[idx];
        int i=map.get(val);

        idx++;
        TreeNode root = new TreeNode(val);
        root.left = build(preorder,inorder,start,i-1);
        root.right = build(preorder,inorder,i+1,end);
        return root;
    }
}
