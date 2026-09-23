/*
 * Bottom View Of Binary Tree
 * Platform: GeeksforGeeks
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N) 
 * Space complexity: O(N)
 * Solved: 2026-09-23
 * URL: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * Language: Java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * This can be slightly optimized to average case of O(N) by storing two variables minX and maxX these will store the min coordinate means left most and right most thus after level order traversal ends we can loop from minX to maxX and get values from hashmap , then there is no need of using tree map

same AS  top view problem just remove the check which is done to check if there is any node in same coordinate , we can just do traversal and add nodes in treemap and if a node with same value comes in below level during level order traversal
then that will be visible to viewer thats why. just simply put in map and it will over write it and at last we will get bottom values
 */

class Solution {
    static class Pair{
        int x;
        Node node;
        Pair(int x , Node node){
            this.x = x;
            this.node = node;
        }
    }
    /*
    You can use BFS without the inner for loop whenever 
    you don't need to perform some operation separately for each level.
    */
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> view = new ArrayList<>();
        if(root == null) return view;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,root));
        
        Map<Integer,Integer> map = new TreeMap<>();
        while(!queue.isEmpty()){
            Pair top = queue.poll();
            Node temp = top.node;
            int x = top.x;
            map.put(x,temp.data);
            if(temp.left!=null) queue.offer(new Pair(x-1,temp.left));
            if(temp.right!=null) queue.offer(new Pair(x+1,temp.right));
            
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            view.add(entry.getValue());
        }
        return view;
    }
}
