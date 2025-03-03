import java.util.ArrayList;
import java.util.Stack;

static void printInorder(Node root){
    if(root == null) return;
    Stack<Node> st = new Stack<>();
    List<Integer> ans = new ArrayList<>();
    Node node = root;
    while(true){

        if(node != null){
            st.push(node);
            node = node.leftChild;
        }
        else{
            if(st.isEmpty()){
                break;
            }
            node = st.pop();
            System.out.print(node.data + " ");
            node = node.rightChild;
        }
    }
}
