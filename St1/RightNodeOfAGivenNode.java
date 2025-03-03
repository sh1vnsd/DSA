import java.util.ArrayDeque;
import java.util.ArrayList;

class Result {
  static int findRightSibling(Node root, int key) {
      if(root == null) return 0;
      Queue<Node> q = new ArrayDeque<>();
      q.add(root);

      while(!q.isEmpty()){
          int size = q.size();
          for(int i=0; i<size; i++){
                Node node = q.poll();
                if(node.data == key){
                    return (i < size - 1) ? p.peek().data : -1;
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
          }
      }
      return -1;
  }
}
