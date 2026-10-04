
 * Notes:
 * BRUTE FORCE-> We know inorder traversal of bst in sorted so just copy the preorder and sort it now you have both preorder and inorder you can generate a BST using recursion.
TC-> nlog n SC-> n+h

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if(n==1) return root;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode curr = root;
        int i=1;
        while(i<n){
            TreeNode child = new TreeNode(preorder[i]);
            if(child.val<curr.val){
                curr.left = child
            }
            else{
                while(!st.isEmpty() && st.peek().val<child.val){
                    curr = st.pop();
                }
                curr.right = child;
                
            }
            st.push(child);
            curr = child;
            i++;
         }
      
     return root;
    }
}
BETTER-> what inorder was giving me is who is left to current root and who is right to current root
as i know in preorder my first element is definitely the root , so every element smaller than that in array will be part of its left subtree and bigger are part of its right subtree thus , we need to know for every element if it is smaller attach to my left but if it is bigger i need to find someone whose right i can be , so we will use a stack monotonic prooperty here push element into stack if its value is smaller and make the top one current but if the value comes to be greater than the top then pop out from stack till the value in stack is either greater ti this or we geet the root node and then assign this as right child  , and continue

TC->O(n) Sc->O(h)

OPTIMAL
The stack space we are using externally can be done using recursion also by always carrying upper bound , like we used to validate bst if it is in range it is left or right child like that so , we do not need to carry min or max cause root val willitself act as upper bound for left subtreea and for rigth subtree intmax will be upper bound  


BASE CASE->
if(idx reaches end or value is greater than root so go back and assign it to right)
 */

class Solution {
 
    public TreeNode generate(int[] preorder , int max,int[]idx){
        if(idx[0]==preorder.length || preorder[idx[0]]>max){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left = generate(preorder,root.val,idx);
        root.right = generate(preorder,max,idx);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx ={0};
        return generate(preorder,Integer.MAX_VALUE,idx);
    }
}
