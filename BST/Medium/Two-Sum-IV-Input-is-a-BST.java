/*
 * Two Sum IV - Input is a BST
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(n)
 * Space complexity: O(2h)
 * Solved: 2026-10-06
 * URL: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/2163679631/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * The basic brute-force approach was that I already did that: I will use a hash set, and whenever I go to a node, I will check if it's complementary. Complementary means k - that element value. If it is present in the hash set, then I will return true. Else, I will add this value and check further using any traversal, which can be in-order, pre-order, or post-order.

The optimal approach is that I will use the stack iterator technique. What the stack iterator gives us is in-order traversal, not total in-order traversal in one go, but kind of in-order traversal without using O(n) space. It gives us in-order traversal in O(h) space.

What I have done here is that I have to use two iterators, one from the start and one from the end. If I use this technique, then I can say it is a kind of sorted array, yes, because if I'm starting from the start and if I'm starting from the end, then the first element will be the smallest and the last element will be the largest. I can simply say that it is kind of sorted already. I will increase two pointers on the basis of the condition and decrease two pointers.

Now, how will the stack data class look? First, it will have the reverse. What will the reverse signify? I do not want to make two classes and do all this because it will be a repetition of code, which the interviewer will not like.

What I will do is that I will have one flag, a type of thing. If the flag is true, then I am going forward, and if the flag is false, I am going backward. According to that, I will push my nodes, and according to that only will I tell the next element. If he is saying "next element" and `reverse` is true, it means I want the literal next element after the element, so I will use `push all` and `temp.right`. If it is false, I will use `push all` and `temp.left`, and `push all` will also depend on `reverse`.

If it is asking for the element before the element, then the technique is different. If it is asking for the next element, then the technique is different. For the next element, the technique is to go to the left while it is not null. Whenever the stack pops it out, I will go to its right child and then again push it all to the left, to the left child. This will give me the elements in sorted order, and the opposite will be the same for reverse in order. Yes, that is the approach. This gives us O(n) time complexity and O(2h) time complexity.  
 */

class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    //reverse -> true -> means i want before element
    //reverse -> false -> means i want next element
    boolean reverse = false;
    BSTIterator(TreeNode node,boolean isReverse){
        reverse = isReverse;
        pushAll(node);
    }
    public int next(){
        TreeNode temp = st.pop();
        if(reverse == true) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }
    public void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse == true) node = node.right;
            else node = node.left;
        }
    }  
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root,false);        
        BSTIterator r = new BSTIterator(root,true);

        int i = l.next();
        int j = r.next();

        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
