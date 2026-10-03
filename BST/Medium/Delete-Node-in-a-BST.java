/*
 * Delete Node in a BST
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(h)
 * Space complexity: O(1)
 * Solved: 2026-10-03
 * URL: https://leetcode.com/problems/delete-node-in-a-bst/submissions/2160657493/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * main problem -> got the way to do it , code implementation was difficult


findLeftMost ---->finding extreme child(leftMost or Rightmost)

sambhog----> for deletion either you go to the right child find its left most , that number will be the smallest so its left willl be curr left or vice versa

EDGE CASE-> if any of right or left is  null , that means no need of finding any exteme child cause there is no tree so return the other side child

MAIN METHOD-> i have to be on parent node to delete either of its child if i will stand on child i do not know its sibling so i cannot reconnect
run till curr not null means traverse through the tree
if curr val is greater so go left otherwise go right
now how to find key , check curr.left or curr.right either of it is key then send that child to helper/sambhog  and whatever it returns it will be that side child of curr, 
and
MOST IMPORTANT ,DURING CHECKING IF IT EQUALS TO KEY OR NOT BEFORE THAT IN SAME CONDITION CHECK WHETHER IT IS NULL , CAUSE IF U WRITE NULL CHECK AFTER , THEN NULL EXCERPTION WILL COME BECAUSE IT ALREADY ASKS FOR CURR.LEFT.VAL SO THIS WILL GIVE NULL
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode curr = root;
        if(curr.val==key) return sambhog(curr);
        while(curr!=null){
            if(curr.val>key){
                if(curr.left!=null && curr.left.val==key){
                    curr.left = sambhog(curr.left);
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right!=null && curr.right.val==key  ){
                    curr.right = sambhog(curr.right);
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }
    public TreeNode sambhog(TreeNode node){
        if(node.left==null){
            return node.right;
        }
        else if(node.right==null){
            return node.left;
        }
        else{
            //Attaching leftmost node of right child to left child of current
            TreeNode leftMost = findLeftMost(node.right);
            TreeNode leftChild = node.left;
            leftMost.left = leftChild;
            return node.right;
        }
    }
    public TreeNode findLeftMost(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
}
