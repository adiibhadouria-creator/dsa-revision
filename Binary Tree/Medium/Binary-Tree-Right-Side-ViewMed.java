/*
 * Binary Tree Right Side ViewMed.
 * Platform: LeetCode
 * Difficulty: Easy
 * Topic: Binary Tree > Medium
 * Time complexity: O(N)
 * Space complexity: O(H)
 * Solved: 2026-09-23
 * URL: https://leetcode.com/problems/binary-tree-right-side-view/submissions/2151377978/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * basically this comes under line or coordinate problem of tree traaversal like top bottom left right
My first approach was to do level order traversal and after all values of particular level is added to data structure then as we only want the right view so we will get the last value of level using list.get(list.size()-1) and add only this value in the answer , this way we only get the right most node of every level , but but 






but this way we are getting space and time complexity of O(N) but if we use recursion we can reduce space toO(H) we want to traverse as root right left thus whenver we are at new level we will add this node , how we will check this whenever we go to new level then as elements at before levels must have been added there so if we compare size of list to level variable we can easily check if this is first or not.
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // do level order traversal
        List<Integer> view = new ArrayList<>();
        rightView(root,0,view);
        return view;
    }
    private void rightView(TreeNode node,int level,List<Integer>view){
        if(node == null) return;
        if(level==view.size()) view.add(node.val);
        rightView(node.right,level+1,view);
        rightView(node.left,level+1,view);
        
    }


        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);

        // while(!queue.isEmpty()){
        //     int n = queue.size();
        //     List<Integer> level = new ArrayList<>();
        //     for(int i=0;i<n;i++){
        //         TreeNode top = queue.poll();
        //         level.add(top.val);
        //         if(top.left!=null) queue.offer(top.left);
        //         if(top.right!=null) queue.offer(top.right);
        //     }
        //     view.add(level.get(level.size()-1));
        // }
        // return view;
    // }
}
