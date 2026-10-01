/*
 * Root To Leaf Paths
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Solved: 2026-10-01
 * URL: https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * simple preorder traversal , just figure out when to remove lasst node
 */

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        getPath(node,ans,path);

        return ans;
    }
    static void getPath(Node node,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> path){
        path.add(node.data);
        if(node.left==null && node.right==null){
            ans.add(new ArrayList<>(path));
                    path.remove(path.size()-1);

            return;
        }
        
        if(node.left!=null)getPath(node.left,ans,path);
        
        if(node.right!=null)getPath(node.right,ans,path);
        
        path.remove(path.size()-1);
        
    }
}
