static Node findMirror(Node root) {
    if(root == null) return null;

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;

    findMirror(root.left);
    findMirror(root.right);
    return root;
}
