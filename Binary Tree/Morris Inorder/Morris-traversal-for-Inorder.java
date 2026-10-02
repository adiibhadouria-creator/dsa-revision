/*
 * Morris traversal for Inorder
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Morris Inorder
 * Time complexity: O(N)
 * Space complexity: O(1)
 * Solved: 2026-10-02
 * URL: https://www.geeksforgeeks.org/problems/inorder-traversal/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
       ArrayList<Integer> inorder = new ArrayList<>();
               if(root==null) return inorder;
               Node curr = root;
               while(curr!=null){
                   if(curr.left==null){ //Left Root Right
                       //means i reached the leftmost node of the left thus now add it and go back to root using threads we created
                       inorder.add(curr.data);
                       curr = curr.right;
                   }
                   else{
                       //find rightmost child of left subtree
                       Node leftChild = curr.left;
                       while(leftChild.right!=null){
                           leftChild = leftChild.right;
                       }
                       leftChild.right = curr;
                       //Delete this link so it does not traverse again to left and will have info that left part is covered

                       Node temp = curr;
                       curr = curr.left;
                       temp.left = null;
                   }
               }
               return inorder;
        
    }
}
