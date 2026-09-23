/*
 * Top View Of Binary Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N log N)
 * Space complexity: O(N)
 * Solved: 2026-09-23
 * URL: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * using level order traversal , and coordinate , for every level put first node in treemap and check later if it exists then do not add and move 
 */

class Solution {
    static class Pair{
        int x;
        Node node;
        Pair(int x,Node node){
            this.x=x;
            this.node = node;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> view = new ArrayList<>();
        if(root==null) return view;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            Node n = top.node;
            int val = top.x;
            if(!map.containsKey(val)) map.put(val,n.data);
            
            if(n.left!=null) queue.offer(new Pair(val-1,n.left));
            if(n.right!=null) queue.offer(new Pair(val+1,n.right));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            view.add(entry.getValue());
        }
        return view;
        
    }
}
