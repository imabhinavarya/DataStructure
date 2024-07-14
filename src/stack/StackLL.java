package stack;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class StackLL {
    Node head;
    int size;

    public StackLL(){
        head=null;
        size=0;
    }
    public boolean isEmpty(){
        return head==null;
    }

    public int size(){
        return size;
    }

    public int peek(){
        if(!isEmpty()){
            return head.data;
        }
        return -1;
    }

    public void push(int val){
        Node newNode = new Node(val);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public int pop(){
        if(isEmpty()) {
            return -1;
        } else {
            int temp=head.data;
            head=head.next;
            size--;
            return temp;
        }

    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(1);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

    }

}
