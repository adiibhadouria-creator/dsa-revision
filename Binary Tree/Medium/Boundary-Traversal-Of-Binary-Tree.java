/*
 * Boundary Traversal Of Binary Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(H)
 * Solved: 2026-09-23
 * URL: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * just broke it down into smaller parts and else is written there , also try its iterative approach
 */

class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        /* also see the iterative version of it
        1. Add left boundary iteratively
        2. Traverse all leaves
        3. Store right boundary separately
        4. Add right boundary in reverse
        first go for left boundary without leaves
         then leaves
         then right boundary in reverse*/
        
        ArrayList<Integer> boundary = new ArrayList<>();
        if(root == null) return boundary;
        if(!isLeaf(root))
               boundary.add(root.data);
   
        leftBoundary(root.left,boundary);
        leaf(root,boundary);
        rightBoundary(root.right,boundary);
        return boundary;
    }
    
    public void leftBoundary(Node node,ArrayList<Integer> boundary){
        if(node == null || isLeaf(node)) return;
        /*here we want answer in left boundary so just adding values 
        as soon as we are getting it now refer right boundary*/
        boundary.add(node.data);
        if(node.left!=null){
            leftBoundary(node.left,boundary);
        }
        else{
            leftBoundary(node.right,boundary);
        }
    }
    public void leaf(Node node,ArrayList<Integer> boundary){
        if(node == null) return;
        if(isLeaf(node)) {
            boundary.add(node.data);
            return;
        }
        leaf(node.left,boundary);
        leaf(node.right,boundary);
    }
    public void rightBoundary(Node node,ArrayList<Integer> boundary){
        if(node == null || isLeaf(node)) return;
        
        if(node.right!=null){
            rightBoundary(node.right,boundary);
        }
        else{
            rightBoundary(node.left,boundary);
        }
        /*here we want value in reverse order so we first go till right most then 
        while coming back we add so automatically values are added in reverse manner*/
       boundary.add(node.data);
    }
    public boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
}
        boundary.add(node.data);
        if(node.left!=null){
