class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        /*
        1.put root in stack  1
        2.pop it out , add its children if exists in stack 1 and push this node in stack 2
        3.do this process until stack 2 is not empty
        */
        Stack<TreeNode> st1 = new Stack<>();
        // you can also remove space of second stack by adding nodes value direct to the result list and then reverse it.
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            if(node.left!=null) st1.add(node.left);
            if(node.right!=null) st1.add(node.right);
            st2.add(node); // here instead of this do res.add(node.val);
            
        }
        while(!st2.isEmpty()){// dont use this loop instead reverse list using Collections.reverse(res);
            res.add(st2.pop().val);
        }
        
        return res;
    }
}
