class Result {
  static int lowestCommonAncestor(Node root, int k1, int k2) {
    // Write your code here
        if(root == null) return 0;
        int curr = root.data;
        if(curr < k1 && curr < k2) return lowestCommonAncestor(root.right, k1, k2);
        if(curr > k1 && curr > k2) return lowestCommonAncestor(root.left, k1, k2);
        return root.data;
  }
}
