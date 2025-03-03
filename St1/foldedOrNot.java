class Result {
  static int isFoldable(Node root) {
      if(root == null) return 1;
      return isMirror(root.left, root.right) ? 1 : 0;
  }
  static boolean isMirror(Node left, Node right){
      if(left == null && right == null) return true;
      if(left == null || right == null) return false;
      return isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }
}
