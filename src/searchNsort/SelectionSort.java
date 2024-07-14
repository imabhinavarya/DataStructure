package searchNsort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr= {4,6,2,1,6,8,12,2};
        selectionSort(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i], minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
}
