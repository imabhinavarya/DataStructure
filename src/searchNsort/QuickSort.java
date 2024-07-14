package searchNsort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr= {4,6,2,1,6,8,12,2};
        quickSort(arr, 0, arr.length - 1);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr, int s, int e) {
        if(s>=e){
            return;
        }
        int pivpos=partition(arr,s,e);
        quickSort(arr,s,pivpos-1);
        quickSort(arr,pivpos+1,e);
    }

    private static int partition(int[] arr, int s, int e) {
        int piv=arr[s];
        int count=0;
        for(int i=s+1;i<=e;i++){
//            count = (arr[i]<=piv) ? count+1 : count;
            if(arr[i]<=piv) count++;
        }
        int temp=arr[s];
        arr[s]=arr[s+count];
        arr[s+count]=temp;

        int pp=s+count;
        int x=s, y=e;

        while(x<=pp && y>pp){
            if(arr[x]<=arr[pp]){
                x++;
            } else if(arr[y]>arr[pp]){
                y--;
            } else {
                arr[x]+=arr[y];
                arr[y]=arr[x]-arr[y];
                arr[x]=arr[x]-arr[y];
            }
        }
        return pp;
    }
}
