import java.lang.classfile.components.ClassPrinter.Node;
import java.util.LinkedList;
import java.util.Queue;

class Result {
  static int countLeafs(Node root) {
      if(root == null) return 0;
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      int countL = 0;
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=0; i<size; i++){
              Node node = q.poll();
              if(node.left == null && node.right == null){
                  countL++;
              }
              if(node.left != null) q.add(node.left);
              if(node.right != null) q.add(node.right);
          }
      }
      return countL;
  }

  static int countNonLeafs(Node root) {
      if(root == null) return 0;
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      int countN = 0;
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=0; i<size; i++){
              Node node = q.poll();
              if(node.left != null || node.right != null){
                  countN++;
              }
              if(node.left != null) q.add(node.left);
              if(node.right != null) q.add(node.right);
          }
      }
      return countN;
  }
}
