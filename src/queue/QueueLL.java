package queue;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class QueueLL {
    Node front;
    Node rear;
    int size;

    public QueueLL(){
        front=null;
        rear=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int front(){
        if(front==null){
            return -1;
        }
        return front.data;
    }

    public void enq(int val){
        Node newnode=new Node(val);
        if(front==null){
            front=newnode;
            rear=newnode;
        } else{
            rear.next=newnode;
            rear=rear.next;
            size++;
        }
    }

    public int deq(){
        if(front==null && rear== null){
            return -1;
        }
        int t=front.data;
        front=front.next;
        size--;
        return t;
    }

    public static void main(String[] args) {
        QueueLL q=new QueueLL();
        q.enq(1);
        q.enq(2);
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.front());
        q.enq(3);
        q.enq(4);
        q.enq(5);
        System.out.println(q.deq());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.front());
    }
}
