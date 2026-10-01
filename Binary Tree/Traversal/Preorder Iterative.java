class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null)  st.push(node.left);
        }
        return res;
    }
}
