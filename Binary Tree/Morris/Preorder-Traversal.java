/*
 * Preorder Traversal
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Solved: 2026-10-02
 * URL: https://www.geeksforgeeks.org/problems/preorder-traversal/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
                Node curr = root;
                while(curr!=null){
                    if(curr.left==null){// root left right
                        //means there is no left so now i will move to right
                        //before moving write add this leaf node also
                        ans.add(curr.data);
                        curr = curr.right;
                    }
                    else{
                        //means left node is null means this is my curr root
                        //visit root before going to left
                        ans.add(curr.data);


                        //now just create the thread
                        //find rightmost child of left subtree
                        Node leftChild = curr.left;
                        while(leftChild.right!=null){
                            leftChild = leftChild.right;
                        }
                        //now connect that right most to root right so you dont come back to root and go direct to right part
                        leftChild.right = curr.right;
                        Node temp = curr;
                        curr = curr.left;
                        temp.right = null;

                    }
                }
                return ans;
        
    }
}
