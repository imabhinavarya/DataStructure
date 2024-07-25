package queue;

import java.util.ArrayList;
import java.util.List;

public class Pq {
    List<Integer> heap;

    public Pq() {
        heap = new ArrayList<>();
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void insert(int val){
        heap.add(val);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                swap(heap, childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else {
                return;
            }
        }
    }

    public int getMin(){
        if(heap.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return heap.get(0);
    }

    public int remove(){
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }
            if(minIndex == index){
                break;
            }
            swap(heap, index, minIndex);
            index = minIndex;
            leftChildIndex = 2*index + 1;
            rightChildIndex = 2*index + 2;
        }
        return temp;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }

    @Override
    public String toString() {
        return "Pq{" +
                "heap=" + heap +
                '}';
    }
}
