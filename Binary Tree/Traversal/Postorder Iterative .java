/*
 * Binary Tree Postorder Traversal
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Binary Tree > Traversal
 * Time complexity: O(2N)
 * Space complexity: O(2N)
 * Solved: 2026-09-20
 * URL: /problems/binary-tree-postorder-traversal/submit/
 * Language: java
 *
 * Problem statement:
 * Given the root of a binary tree, return the postorder traversal of its nodes' values. Example 1: Input: root = [1,null,2,3] Output: [3,2,1] Explanation: Example 2: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9] Output: [4,6,7,5,2,9,8,3,1] Explanation: Example 3: Input: root = [] Output: [] Example 4: Input: root = [1] Output: [1] Constraints: The number of the nodes in the tree is in the range [0, 100]. -100 <= Node.val <= 100 Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * Notes:
 * None
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        /*
        1.put root in stack  1
        2.pop it out , add its children if exists in stack 1 and push this node in stack 2
        3.do this process until stack 2 is not empty
        */
        Stack<TreeNode> st1 = new Stack<>();
        // you can also remove space of second stack by adding nodes value direct to the result list and then reverse it.
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            if(node.left!=null) st1.add(node.left);
            if(node.right!=null) st1.add(node.right);
            st2.add(node); // here instead of this do res.add(node.val);
            
        }
        while(!st2.isEmpty()){// dont use this loop instead reverse list using Collections.reverse(res);
            res.add(st2.pop().val);
        }
        
        return res;
    }
}
