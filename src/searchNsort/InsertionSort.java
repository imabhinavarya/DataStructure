package searchNsort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr= {4,6,2,1,6,8,12,2};
        insertionSort(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            int j=i-1, temp=arr[i];
            while(j>=0 && temp<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}
