
 * Time complexity: O(2n)
 * Space complexity: O(2n)

 * Notes:
 * think about k as levels and target as root then all k levels noddr from target is the answer which is bfs

problems-
1.bfs through root is easy you push left and right children but how you will do it with some random node
ans -> only problem is i cannot access node which is above me means parent so we can use parent pointer technique

2.how to do parent pointer?
ans-> use a map , then do dfs inorder and while going left put left and curr in map 

3.what if you put one node in queue and then go to its left right children then when left right will be popped out then you will again put parent which will be an error.
ans-> keep a visited set to avoid this


whole algo-
do inorder and make parent. pointer
then do bfs and check if it is not visited and and it is not null then add this in queue and set , and keep a level counter whenever level reaches k break ,and pop out elements of queue that will be elements of k distance from targets
 */

class Solution {
    //parent pointer thing
    Map<TreeNode,TreeNode> map = new HashMap<>();
    void inorder(TreeNode root){
        if(root == null) return;

        if(root.left!=null){
            map.put(root.left,root);
            inorder(root.left);
        }
        if(root.right!=null){
            map.put(root.right,root);
            inorder(root.right);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        inorder(root);
        visited.add(target);
        queue.add(target);
        int level =0;
        
        while(!queue.isEmpty()){
            int n = queue.size();
            if(level==k) break;
            for(int i=0;i<n;i++){
                TreeNode top = queue.poll();

                if(!visited.contains(top.left)&&top.left!=null){
                    queue.add(top.left);
                    visited.add(top.left);
                } 
                //Right
                if(!visited.contains(top.right)&&top.right!=null){
                    queue.add(top.right);
                    visited.add(top.right);
                } 

                //parent
                TreeNode parent = map.getOrDefault(top,null);
                if(!visited.contains(parent) && parent!=null){
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}
