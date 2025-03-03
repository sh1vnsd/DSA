import java.util.*;
class Result {
  static void printCousins(Node root, int k) {
      if(root == null || root.data == k){
          System.out.println("-1");
          return;
      }
      Queue<Node> q = new ArrayDeque<>();
      ArrayList<Integer> cousin = new ArrayList<>();
      q.add(root);
      boolean found = false;
      while(!q.isEmpty() && found == false){
          int size = q.size();
          cousin.clear();
          for(int i=0; i<size; i++){
              Node node = q.poll();

              if((node.leftChild != null && node.leftChild.data == k) || (node.rightChild != null && node.rightChild.data == k)){
                  found = true;
              }
              else{
                  if(node.leftChild != null){
                      q.add(node.leftChild);
                      cousin.add(node.leftChild.data);
                  }
                  if(node.rightChild != null){
                      q.add(node.rightChild);
                      cousin.add(node.rightChild.data);
                  }
              }
          }
      }
      if(cousin.isEmpty()){
        System.out.println("-1");
      }
      else{
          for(var it : cousin){
              System.out.print(it + " ");
          }
          System.out.println();
      }
  }
}

