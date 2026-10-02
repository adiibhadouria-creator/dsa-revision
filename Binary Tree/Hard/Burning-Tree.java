/*
 * Burning Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(2n)
 * Space complexity: O(2n)
 * Solved: 2026-10-02
 * URL: https://www.geeksforgeeks.org/problems/burning-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * checck infected tree code it is same
 */

class Solution {
   Map<Node,Node> parent = new HashMap<>();
      Node target;
      void inorder(Node root,int start){
          if(root==null) return;
          if(root.data==start) target = root;
          if(root.left!=null){
              parent.put(root.left,root);
              inorder(root.left,start);
          }
          if(root.right!=null){
              parent.put(root.right,root);
              inorder(root.right,start);
          }
      }


      public int minTime(Node root, int start) {
          //we have to find the start node first

          Queue<Node> queue = new LinkedList<>();
          Set<Node> visited = new HashSet<>();
          inorder(root,start);

          queue.add(target);
          visited.add(target);

          int level =0;
          while(!queue.isEmpty()){

              int n = queue.size();
              for(int i=0;i<n;i++){
                  Node top = queue.poll();

                  if(top.left!=null && !visited.contains(top.left)){
                      queue.add(top.left);
                      visited.add(top.left);
                  }

                  if(top.right!=null && !visited.contains(top.right)){
                      queue.add(top.right);
                      visited.add(top.right);
                  }

                  Node p = parent.getOrDefault(top,null);
                  if(p!=null && !visited.contains(p)){
                      queue.add(p);
                      visited.add(p);
                  }
              }
              level++;
          }
          return level-1;
}
}
