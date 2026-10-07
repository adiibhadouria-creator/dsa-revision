/*
 * Largest Bst
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: BST > Medium
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Solved: 2026-10-07
 * URL: https://www.geeksforgeeks.org/problems/largest-bst/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * Approach
Brute force repeatedly checks whether the same subtree is a BST. Instead, solve each subtree once using postorder traversal.
For every subtree, return:
- min value
- max value
- largest BST size
Algorithm
1. For null: return size = 0, min = +∞, max = -∞.
2. Get information from left and right subtrees.
3. If:
left.max < root.data < right.min

then the current subtree is a BST:
size = left.size + right.size + 1
min = min(root, left.min)
max = max(root, right.max)

4. Otherwise, the current subtree isn't a BST, so keep:
size = max(left.size, right.size)

and return an invalid range so the parent can't use it.

 */

class Solution {
    class NodeValue{
        int size , max , min;
        NodeValue(int size , int max ,int min){
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    public int largestBst(Node root) {
        // code here
        return helper(root).size;
    }
    public NodeValue helper(Node root){
        if(root==null){
            //return 0 size and such values as max and min so that any number I
            //compare with above one it will be safely poss
            return new NodeValue(
                0,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
                );
        }
        //preorder traversal
        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);
        
        //business logic
        if(left.max<root.data && root.data<right.min){//means it is a vallid bst
            return new NodeValue(
                //if it is a valid bst
                //size = 1 + x + y
                // max = root or right max
                // min = root or left min
                //why if this is valid so i need to update ranges so that upcoming node
                //should also be between these numbers
                1+left.size+right.size,
                Math.max(root.data, right.max),
                Math.min(root.data,left.min)
                );
        }
        //means it is not valid bst , so pass max parameters and min sucha s whenever
        //you compare it next time , it can never pass this , thus helping reaching till top
        return new NodeValue(
            Math.max(left.size,right.size),
            Integer.MAX_VALUE , Integer.MIN_VALUE
            );
    }
}
