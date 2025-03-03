class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class kthLargestBst {
    
    static int kthLargest(Node root, int k){
        if(root == null) return 0;
        Node curr = root;
        int count = 0;
        while(curr != null){
            if(curr.right == null){
                count++;
                if(count == k) return curr.data;
                curr = curr.left;
            }
            else{
                Node prev = curr.right;
                while(prev.left != null && prev.left != curr){
                    prev = prev.left;
                }
                if(prev.left == null){
                    prev.left = curr;
                    curr = curr.right;
                }
                else{
                    prev.left = null;
                    count++;
                    if(count == k) return curr.data;
                    curr = curr.left;
                }
            }
        }
        return -1;
    }

    // Creating a sample BST
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int k = 3;
        System.out.println("The " + k + "th largest element is: " + kthLargest(root, k));
    }
}

