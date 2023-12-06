package LinkedList;

public class IntersectionPointOfTwoLists {
    public static void main(String[] args) {
        Node a1 = new Node(10);
        Node a2 = new Node(20);
        Node a3 = new Node(30);
        Node a4 = new Node(40);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        Node b1 = new Node(15);
        b1.next = a3;

        Node head1 = a1;
        Node head2 = b1;
        System.out.println(intersectionPoint(head1, head2).data);
    }

    private static Node intersectionPoint(Node head1, Node head2) {
        int n1 = 0;
        Node curr = head1;
        while (curr != null) {
            curr = curr.next;
            n1++;
        }
        curr = head2;
        int n2 = 0;
        while (curr != null) {
            curr = curr.next;
            n2++;
        }
        int diff = Math.abs(n1 - n2);
        Node longerHead = (n1 > n2) ? head1 : head2;
        Node smallerHead = (n1 > n2) ? head2: head1;
        while (diff-- > 0) {
            longerHead = longerHead.next;
        }
        while (longerHead != smallerHead) {
            longerHead = longerHead.next;
            smallerHead = smallerHead.next;
        }
        return longerHead;
    }
}
