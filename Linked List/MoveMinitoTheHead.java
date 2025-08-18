class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MoveMinitoTheHead {
    Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void swapMinWithHead() {
        if (head == null || head.next == null) return;

        Node minNode = head;
        Node temp = head.next;

        while (temp != null) {
            if (temp.data < minNode.data) {
                minNode = temp;
            }
            temp = temp.next;
        }

        int t = head.data;
        head.data = minNode.data;
        minNode.data = t;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MoveMinitoTheHead list = new MoveMinitoTheHead();

        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);

        System.out.print("Before: ");
        list.printList();

        list.swapMinWithHead();

        System.out.print("After:  ");
        list.printList();
    }
}

