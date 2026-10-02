/*
 * Serialize and Deserialize Binary Tree
 * Platform: LeetCode
 * Difficulty: Not specified
 * Topic: Binary Tree > Construction
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Solved: 2026-10-02
 * URL: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/2160548532/
 * Language: java
 *
 * Problem statement:
 * Not captured.
 *
 * Notes:
 * you can not generate a binary tree from a single array means with only one traversal  so first in serializing we use a queue for doing level order traversal and generate string which also contains null
then for deserializing again we have to use queue we cannot generate a binary tree using that string  only we need to add one by one in queue and then check if it is not null it will be elft child same for right child
 */

public class Codec {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if(root==null) return "";
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode top = queue.poll();
                if(top==null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(top.val+" ");
                queue.add(top.left);
               queue.add(top.right);
               
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String separated = data.replace(" ",",");
        StringBuilder a = new StringBuilder(separated);
        if(a.length()>0){
            a.deleteCharAt(a.length()-1);
        }
         System.out.println(a);
        //now convert this string to tree
        //first convert it into array then follow the left and right child property
        String[] tokens = a.toString().split(",");
        int[] arr = new int[tokens.length];
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("null")||tokens[i].isEmpty()){
                arr[i]=-1001;
            }
            else {
                arr[i] = Integer.parseInt(tokens[i]);
            }
        }
        if(arr[0]==-1001) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()&&i<arr.length){
            TreeNode current = queue.poll();
            
                if(arr[i]==-1001) current.left =null;
                else {
                    current.left = new TreeNode(arr[i]);
                    queue.add(current.left);
                }
            
            i++;
                if(i<arr.length && arr[i]!=-1001) {
                     current.right = new TreeNode(arr[i]);
                    queue.add(current.right);
                    
                }
                else{
                   current.right = null;
            }
            i++;
        }
        return root;
    }
}
