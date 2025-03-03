import java.util.HashMap;

class Result {
    static Node buildTreeAgain(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd) return null;
        Node root = new Node(post[postEnd]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;

        root.leftChild = buildTreeAgain(in, inStart, inRoot - 1, post, postStart, postStart + numsLeft - 1, map);
        root.rightChild = buildTreeAgain(in, inRoot + 1, inEnd, post, postStart + numsLeft, postEnd - 1, map);
        return root;
    }
  static Node buildTree(int in[], int post[], int N) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int i=0; i<in.length; i++){
          map.put(in[i], i);
      }
      Node root = buildTreeAgain(in, 0, in.length - 1, post, 0, post.length - 1, map);
      return root;
  }
}
