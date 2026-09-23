/*
 * Left View Of Binary Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(N)
 * Solved: 2026-09-23
 * URL: https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * same as right view
 */

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> view = new ArrayList<>();
        if(root==null) return view;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
                for(int i=0;i<n;i++){
                    Node top = queue.poll();
                    level.add(top.data);
                    if(top.left!=null) queue.offer(top.left);
                    if(top.right!=null) queue.offer(top.right);
                   }
                   view.add(level.get(0));
               }
               return view;
    }
}
