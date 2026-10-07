/*
 * Recover Binary Search Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(n)
 * Space complexity: O(h) ~ O(1)
 * Solved: 2026-10-07
 * URL: https://leetcode.com/problems/recover-binary-search-tree/submissions/2165069154/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Basically, what we can do is:
1. We can store all nodes and orders.
2. We can sort the values of nodes.
3. We can again traverse a node and check if the values are not equal. We can make it a value in the values list.
This means we will take two lists: one for nodes and one for the values. Every time we iterate, we will check if the node and its value are equal or not. If not, then we will change it.

---OPTIMAL APPROACH----
The optimal approach is that we can think of it as a sorted array. It is a sorted array, and two values are changed. How can we make them sorted again? There are two cases:
1. They can be adjacent.
2. They can be non-adjacent.
We will store three variables:
- `first`
- `middle`
- `last`
Every time a violation occurs, what is a violation? When a current value is less than the previous value, we have to compare. That means we also have to keep track of the previous value, so there will also be a variable called `previous`.
Whenever the previous value is less than the current value, we will mark it as `violation 1`, and we will check in a loop:
- If `first` is not marked, this is the first run. We will mark `first` and `middle`.
- If `first` is already marked, that means our values are not adjacent. We will mark the last one.
At the end, in our main method, we will check:
- If `first` and `last` are not `null`, they are non-adjacent, so we will swap them.
- If `last` is `null`, that means those two values were adjacent, so we will swap them.
 */

class Solution {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        //what if you have a sorted array but two of its values are swapped , how you can make it sorted again without using sorting 
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!=null && middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(root.val<prev.val){
            if(first==null){
                first = prev;
                middle = root;
            }
            else if(last==null){
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
