package queue;

public class Main {
    public static void main(String[] args) {
        Pq pq = new Pq();
        int[] arr = {10, 5, 2, 4, 8, 3};
        for(int i : arr){
            pq.insert(i);
        }

        System.out.println(pq);
        System.out.println("===========================");
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
        System.out.println();

        System.out.println("====== Inplace Insert & Remove =======");
        arr = new int[] {5,1,9,2,0,6};
        for(int i=0;i<arr.length;i++){
            insertInplace(arr,i);
        }
        for(int i : arr){
            System.out.print (i+" ");
        }
        System.out.println();

        System.out.println("=======================================");
        for(int i=0;i<arr.length;i++){
           arr[arr.length-1-i] = removeInplace(arr,arr.length-i);
        }
        for(int i : arr){
            System.out.print (i+" ");
        }
        System.out.println();

    }

    public static void insertInplace(int[] arr, int i){
        int childIndex = i;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(arr[childIndex] < arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            } else {
                return;
            }
        }
    }

    public static int removeInplace(int[] arr, int heapSize){
        int temp = arr[0];
        arr[0] = arr[heapSize-1];
        heapSize--;
        int index = 0;
        int leftChildIndex = 2*index +1;
        int rightChildIndex = 2*index +2;
        int minIndex = index;
        while(leftChildIndex < heapSize){
            if(arr[minIndex] > arr[leftChildIndex]){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }
            if(index == minIndex){
                break;
            }
            int t = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = t;

            index = minIndex;
            leftChildIndex = 2*index +1;
            rightChildIndex = 2*index +2;
        }
        return temp;
    }
}
