package stack;

import java.util.Stack;

public class StackArray {
    private int[] st;
    private int top;

    public StackArray(){
        st=new int[10];
        top=-1;
    }
    public StackArray(int cap) {
        st=new int[cap];
        top=-1;
    }

    public boolean isEmpty(){
        return top== -1;
    }

    public boolean isFull(){
        return top== st.length-1;
    }

    public int size(){
        return top+1;
    }

    public void push(int val){
        if(isFull()){
//            System.out.println("Full");
            doubleCapacity();
        }else{
            top++;
            st[top]=val;
        }
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }else{
            return st[top];
        }
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }else{
            int temp= st[top];
            top--;
            return temp;
        }
    }

    public void doubleCapacity(){
        int[] copy = st;
        st=new int[2*st.length];
        for(int i=0;i<=top;i++){
            st[i]=copy[i];
        }
    }


    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        stack.push(1);
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.isFull());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

    }
}
