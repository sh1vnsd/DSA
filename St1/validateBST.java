class Result {
  static int isBinarySearchTree(Node root) {
    // Write your code here
        return isValidTree(root, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0;    
  }
  static boolean isValidTree(Node root, long minVal, long maxVal){
      if(root == null) return true;
      if(root.data >= maxVal || root.data <= minVal) return false;
      return isValidTree(root.left, minVal, root.data) && isValidTree(root.right, root.data, maxVal);
  }
}
