class Solution {
    public ArrayList<Integer> boundaryTraversal(Node root) {
        /* also see the iterative version of it
        1. Add left boundary iteratively
        2. Traverse all leaves
        3. Store right boundary separately
        4. Add right boundary in reverse
        first go for left boundary without leaves
         then leaves
         then right boundary in reverse*/
        
        ArrayList<Integer> boundary = new ArrayList<>();
        if(root == null) return boundary;
        if(!isLeaf(root))
               boundary.add(root.data);
   
        leftBoundary(root.left,boundary);
        leaf(root,boundary);
        rightBoundary(root.right,boundary);
        return boundary;
    }
    
    public void leftBoundary(Node node,ArrayList<Integer> boundary){
        
        if(!isLeaf(node)) boundary.add(node.data);    
        while(node.left!=null){
            node = node.left;
        }
        else{
            leftBoundary(node.right,boundary);
        }
    }
    public void leaf(Node node,ArrayList<Integer> boundary){
        if(node == null) return;
        if(isLeaf(node)) {
            boundary.add(node.data);
            return;
        }
        leaf(node.left,boundary);
        leaf(node.right,boundary);
    }
    public void rightBoundary(Node node,ArrayList<Integer> boundary){
        List<Integer> temp = new ArrayList<>();
        if(!isLeaf(node)) temp.add(node.data);    
        if(node.right!=null){
            rightBoundary(node.right,boundary);
        }
        else{
            rightBoundary(node.left,boundary);
        }
        /*here we want value in reverse order so we first go till right most then 
        while coming back we add so automatically values are added in reverse manner*/
       boundary.add(node.data);
    }
    public boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
}
