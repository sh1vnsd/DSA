class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteKthNode {
    Node deleteKth(Node head, int k) {
        if (head == null) return head;

        if (k == 1) {
            Node temp = head;
            head = head.next;
            return head;
        }

        int cnt = 0;
        Node temp = head, prev = null;

        while (temp != null) {
            cnt++;
            if (cnt > k) {
                return head;
            }
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    // helper method to print the list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // helper method to create a sample list
    Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteKthNode sol = new DeleteKthNode();
        int[] data = {10, 20, 30, 40, 50};
        Node head = sol.createList(data);

        System.out.println("Original list:");
        sol.printList(head);

        int k = 3;
        head = sol.deleteKth(head, k);

        System.out.println("After deleting " + k + "-th node:");
        sol.printList(head);
    }
}

