package queue;

public class QueueArray {
    int[] data;
    int front;
    int rear;
    int size;

    public QueueArray(){
        front=-1;
        rear=-1;
        data=new int[10];
        size=0;
    }
    public QueueArray(int cap){
        front=-1;
        rear=-1;
        data=new int[cap];
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int front(){
        if(size==0){
            return -1;
        }
        return data[front];
    }

    public void enq(int val){
        if(size==data.length){
//            System.out.println("Full");
//            return;
            doubleCapacity();
        }
        if(size==0){
            front=0;
        }
        rear++;
        data[rear]=val;
        size++;
    }

    public int deq(){
        if(isEmpty()){
            return -1;
        }
        int t = data[front];
        front++;
        size--;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return t;
    }

    public void doubleCapacity(){
        int[] temp=data;
        data=new int[2*data.length];
        int index=0;

        for (int i = front; i < temp.length; i++) {
            data[index]=temp[i];
            index++;
        }
        for (int i = 0; i < front; i++) {
            data[index]=temp[i];
            index++;
        }

        front=0;
        rear=temp.length-1;
    }

    public static void main(String[] args) {
        QueueArray q=new QueueArray(1);
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
