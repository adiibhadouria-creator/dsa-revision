/*
 * Binary Tree Zigzag Level Order Traversal
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(N) auxiliary space
 * Solved: 2026-09-23
 * URL: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/2150618497/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * simple level order traversal , just check the level if it should be reversed add it in the reversed manner , for checking you can check size of the res or or you can use deque so you check and you can directly add at last or first using deque in that way you do not have to reverse it again and again
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //do bfs traversal then on adding levels to the result just check if it is odd level than reverse it
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curr =1;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode top = queue.poll();
                if(top.left!=null) queue.offer(top.left);
                if(top.right!=null) queue.offer(top.right);
                level.add(top.val);
            }
            if(curr%2==0){
                Collections.reverse(level);
                res.add(level);
                curr++;
            }
            else{
                res.add(level);
                curr++;
            }
        }
        return res;
    }
}
