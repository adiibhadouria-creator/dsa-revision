/*
 * Diameter of Binary Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(H) ~ O(N)
 * Solved: 2026-09-22
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/submissions/2149311239/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * MAKE MAX VARIABLE GLOBAL

Brute Force -> for every node , find its left sub tree  height and find its right sub tree height , then add them because that is the definition of the diameter
and then store it in max variable . and call this same function for left node and right node .
TC -> O(N^2) SC->O(N)


Optimal -> Now what is the repetitive task we are doing for every node we are calling recursion two times once for finding height , and then for its sub nodes.
basically for finding diameter also we need height only so we can update it every time we find left and right height and also return max height in same function that's why we need to keep max variable as global. Using this approach we perform recursion only once


 */

class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;  
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        diameter = Math.max(diameter, left+right);
        return Math.max(left,right)+1;

    }
}
// class Solution {
//     private  int max = Integer.MIN_VALUE;
//     public int diameterOfBinaryTree(TreeNode root) {
        //basically for every node , find max length of left subtree and max length of right subtree
        // then add these it will give the maximum diameter

        // if(root == null) return 0;
        // int ld = depth(root.left);
        // int rd = depth(root.right);
        

        // int diameter = ld + rd;
        // max = Math.max(diameter,max);
        // diameterOfBinaryTree(root.left);
        // diameterOfBinaryTree(root.right);
        // return max;


//     }
//     public int depth(TreeNode node){
//         if(node == null) return 0;

//         int left = depth(node.left);
//         int right = depth(node.right);

//         return Math.max(left,right)+1;
//     }
    
// }
