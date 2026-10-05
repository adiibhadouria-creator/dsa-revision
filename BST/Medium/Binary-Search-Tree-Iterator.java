/*
 * Binary Search Tree Iterator
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(h)
 * Space complexity: O(1)
 * Solved: 2026-10-05
 * URL: https://leetcode.com/problems/binary-search-tree-iterator/submissions/2162949968/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * brute force will be do inorder traversal using recursion and store this inorder traversal in a list 
then iterate over a list , and have a counter variable 
whenever next is called first return the current element using list.get(counter) and also increase counter.
And for has next method , check if counter reached till list size if yes then return false else rerturn true

TC-> O(N) SC-> O(N)

---OPTIMAL APPROACH---
Instead of this recursive dfs , we can do iterative dfs according to indorder method like what is inorder first go to left and then come back and write root then go right
which data structures gives us this freedom that i m there but i will need to be evaluated later
Stack right, so first push all left nodes of root in the stack thus the smallest one will come at top , then whenver u reach end means u have gone to left bottom so just pop out and write root and then go right
How we will achieve this using stack
first push all left nodes in the stack , then whenever it ask for next node means it is asking for a higher element in sorted order means we need to go right
so go its right node and push all rights node left in stack
 */

class BSTIterator {

    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode curr = root;
        pushAll(root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        pushAll(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
       
    }
    public void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
    
}
