package linkedList;

import java.util.Scanner;

public class LinkedListClass {
    public static Node insert(){
        System.out.println("Please add your Nodes");
        Scanner sc = new Scanner(System.in);
        int data=sc.nextInt();
        Node head=null;
        while(data != -1){
            if(head==null){
                head=new Node(data);
            }else{
                Node newNode = new Node(data);
                Node temp=head;
                while(temp.next != null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
            data=sc.nextInt();
        }
        return head;
    }

    public static Node deleteByPos(Node head, int pos){
        if(head==null) return head;
        if(pos==1){
            return head.next;
        }
        Node temp =head;
        for(int i=1; i<pos-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }

    public static Node deleteByVal(Node head, int val){
        if(head==null) return head;
        if(val==head.data){
            return head.next;
        }
        Node temp =head;
        while(temp.next != null){
            if(val==temp.next.data){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return head;
    }

    public static Node midPoint(Node head){
        Node slow=head, fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node mergeTwoSortedLL(Node l1, Node l2){
        if(l1 ==null) return l2;
        if(l2 ==null) return l1;

        Node head=null, tail=null;

        if(l1.data<=l2.data){
            head=l1;
            tail=l1;
            l1=l1.next;
        } else {
            head=l2;
            tail=l2;
            l2=l2.next;
        }

        while (l1!=null && l2!=null){
            if(l1.data<=l2.data){
                tail.next=l1;
                l1=l1.next;
                tail=tail.next;
            } else {
                tail.next=l2;
                l2=l2.next;
                tail=tail.next;
            }
        }
        if(l2!=null){
            tail.next=l2;
        }
        if(l1!=null){
            tail.next=l1;
        }

        return head;
    }

    public static Node revLLRec(Node head){
        if(head==null || head.next==null){
            return  head;
        }
        Node smallAns= revLLRec(head.next);
        Node tail=head.next;
        tail.next=head;
        head.next=null;

        return smallAns;
    }


    public static Node revLL(Node head){
        Node prev=null, temp=null, cur=head;
        while(cur != null){
            temp=cur.next;
            cur.next= prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }

    public static Node mergeSortLL(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=LinkedListClass.midPoint(head);
        Node sec=mid.next;
        mid.next=null;

        Node l=mergeSortLL(head);
        Node r=mergeSortLL(sec);

        Node sortHead = mergeTwoSortedLL(l,r);
        return sortHead;
    }

    public static void print(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
