/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Construction
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * as it is post order and inorder from post order i can get roots and from inorder i can get left and right children
post order -> L R Root that means I am sure last value of post order array will be my root node
so from there see that node in inorder as inorder is L Root R so , if i know this is root so elements left to it in array will be left child and right elements will be right child

whole process->
pick last value of post order that will be node , find its index in inorder then divide that array conceptually using recursion
suppose that index is i so elements from start to i-1 will be left children and elements from i+1 to end will be right children just attach them and call for next root node which is in. post order traversing from back

 */

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        int[]idx={postorder.length-1};
        
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,n-1,idx,map);
    }
    public TreeNode build(int[]postorder,int start,int end,int []idx,Map<Integer,Integer> map){
        if(start>end) return null;

        int rootVal = postorder[idx[0]--];
        int i = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
     
        root.right = build(postorder,i+1,end,idx,map);
        root.left = build(postorder,start,i-1,idx,map);
        return root;
    }
}
