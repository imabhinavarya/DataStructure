package linkedList;

public class LinkedListUse {
    public static void main(String[] args) {
        Node head = LinkedListClass.insert();
        LinkedListClass.print(head);

//        int pos=4;
//        Node node1= LinkedListClass.deleteByPos(head, pos);
//        LinkedListClass.print(node1);

//        int val=3;
//        Node node2= LinkedListClass.deleteByPos(head, val);
//        LinkedListClass.print(node2);

//        System.out.println(LinkedListClass.midPoint(head));

//        Node head1 = LinkedListClass.insert();
//        Node head2 = LinkedListClass.insert();
//        Node sortedNode=LinkedListClass.mergeTwoSortedLL(head1, head2);
//        LinkedListClass.print(sortedNode);

//        Node head1=LinkedListClass.revLL(head);
//        LinkedListClass.print(head1);

        Node sort= LinkedListClass.mergeSortLL(head);
        LinkedListClass.print(sort);

    }
}
