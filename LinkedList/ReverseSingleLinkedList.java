package LinkedList;

public class ReverseSingleLinkedList {
    public static void main(String[] args) {
        Node head = initializeLinkedList();
        head = reverseSingleList(head);
        printSingleList(head);
    }

    private static void printSingleList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node reverseSingleList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static Node initializeLinkedList() {
        Node a1 = new Node(10);
        Node a2 = new Node(20);
        Node a3 = new Node(30);
        Node a4 = new Node(40);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        return a1;
    }
}
