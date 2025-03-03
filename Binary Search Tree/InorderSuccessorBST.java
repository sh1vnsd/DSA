class Solution {
    public int inorderSuccessor(Node root, Node x) {
        int successor = -1;
        while(root != null){
            if(x.data >= root.data){
                root = root.right;
            }
            else{
                successor = root.data;
                root = root.left;
            }
        }
        return successor;
    }
}
