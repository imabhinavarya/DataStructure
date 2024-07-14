
import java.util.*;

class Container{
    int id;
    String color;
    float val;

    public Container() {
    }

    public Container(int id, String color, float val) {
        this.id = id;
        this.color = color;
        this.val = val;
    }
}

public class Assessment {

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 7, 2, 2, 1, 6};
        String[] arr2 = {"red", "yellow", "green", "blue", "orange", "Indigo", "Violet", "Maroon"};
        float[] arr3 = {3.2f, 5.5f, 6.7f, 3.8f, 2.7f, 1.9f, 4.9f};

        printValues(arr1, arr2, arr3);
        System.out.println("==============================");
        printValuesSorted(arr1, arr2, arr3);
    }

    private static void printValuesSorted(int[] arr1, String[] arr2, float[] arr3) {
        int min = Math.min(arr1.length, Math.min(arr2.length, arr3.length));
        List<Container> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0, j=0;i<arr1.length && j<min;){

            if(set.contains(arr1[i])){
                i++;
                continue;
            }
//            System.out.println(arr1[i]+":"+arr2[i]+":"+arr3[j]);
            list.add(new Container(arr1[i],arr2[i],arr3[j]));
            set.add(arr1[i]);
            i++;j++;
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.id,o2.id));
        for(Container c : list){
            System.out.println(c.id+":"+c.color+":"+c.val);
        }
    }

    private static void printValues(int[] arr1, String[] arr2, float[] arr3) {
        int min = Math.min(arr1.length, Math.min(arr2.length, arr3.length));
        Set<Integer> set = new HashSet<>();
        for(int i=0, j=0;i<arr1.length && j<min;){

            if(set.contains(arr1[i])){
                i++;
                continue;
            }
            System.out.println(arr1[i]+":"+arr2[i]+":"+arr3[j]);
            set.add(arr1[i]);
            i++;j++;
        }
    }
}
