package searchNsort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr= {1,3,5,7,8,9};
        int i= binSearch(arr,3);
        System.out.println(i);

    }

    private static int binSearch(int[] arr, int val) {
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==val){
                return mid;
            } else if (arr[mid]<val) {
                s=mid+1;
            } else {
                e=mid-1;
            }
        }
        //if element is missing what would be its position
//        return s;
        return -1;
    }
}
