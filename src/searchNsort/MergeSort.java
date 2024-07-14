package searchNsort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {4,6,2,1,6,8,12,2};
        mergeSort(arr, 0, arr.length - 1);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if(s>=e) return;

        int mid=(s+e)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);

        merge(arr,s,e);
    }

    private static void merge(int[] arr, int s, int e) {
        int mid=(s+e)/2;
        int[] ans=new int[e-s+1];
        int i=s, j=mid+1, k=0;

        while(i<=mid && j<=e){
            if(arr[i]<=arr[j]){
                ans[k]=arr[i];
                i++;k++;
            } else {
              ans[k]=arr[j];
              j++;k++;
            }
        }
        while(i<=mid){
            ans[k]=arr[i];
            i++;k++;
        }
        while(j<=e){
            ans[k]=arr[j];
            j++;k++;
        }

        for(int index=0;index<ans.length;index++){
            arr[s+index]=ans[index];
        }
    }
}
