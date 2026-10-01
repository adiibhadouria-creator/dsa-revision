/*
 * Maximum Width of Binary Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-01
 * URL: https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/2159646115/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * None
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Long>> queue = new LinkedList<>();
        long width =1L;
        queue.add(new Pair<>(root,0L));

        while(!queue.isEmpty()){
            int n = queue.size();
            long firstIdx =0L;
            long lastIdx =0L;

            for(int i=0;i<n;i++){
                Pair<TreeNode,Long> top = queue.poll();
                if(i==0)  firstIdx = top.getValue();
                if(i==n-1) lastIdx = top.getValue();
                TreeNode t = top.getKey();
                long idx = top.getValue();

                if(t.left!=null) queue.add(new Pair<>(t.left,(2L*idx)+1L));
                if(t.right!=null) queue.add(new Pair<>(t.right,(2L*idx)+2L));
            }
            width = Math.max(width,lastIdx-firstIdx+1L);
        }
        return (int)width;
    }
}
//learning -> for finding max width what I was doing was I thought of storing all level in vector using bfs traversal and then I will traverse in that vector and for every level I will calculate its max distance --how? i will store -1 as fake nodes so i will find starting node and end node difference of that will be my ans


//but i can do the same thing while traversing bfs like whenever we do traverse a queue stores whole level of that tree so if we can somehow find difference between first and last node we will get ans of that level , queue allows to get first and last element efficiently , that s why this is the better approach ,we will store node with its index

//left child = (2*idx)+1
//right child = (2*idx)+2

//few more java syntax learning
// queue does not have front or back method in java
