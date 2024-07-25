package queue;

import java.util.PriorityQueue;

public class QueueQues {
    public static void main(String[] args) {
        int[] arr = {2,4,1,9,6,8};
        kSorted(arr,3);

        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] arr1 = {2,4,1,9,6,8};
        kLargest(arr1,3);
    }

    public static void kSorted(int[] arr, int k){
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(;i<k;i++){
            pq.add(arr[i]);
        }
        for(;i<arr.length;i++){
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }
        for(int j=arr.length-k;j<arr.length;j++){
            arr[j] = pq.remove();
        }

    }

    public static void kLargest(int[] arr, int k){
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(;i<k;i++){
            pq.add(arr[i]);
        }
        for(;i<arr.length;i++){
            int min = pq.element();
            if(min<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }
}
