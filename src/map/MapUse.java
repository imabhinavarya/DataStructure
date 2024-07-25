package map;

import java.util.ArrayList;
import java.util.Arrays;

public class MapUse {

    public static void main(String[] args) {
        MapU<String, Integer> map = new MapU<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc"+i, i);
            System.out.println( "i= "+ i + " loadFactor: " + map.loadFactor() + " size: " +map.size());
        }
        map.remove("abc3");
        map.remove("abc0");

        for (int i = 0; i < 20; i++) {
            System.out.println( "abc"+ i + " : " +map.getValue("abc"+i) + " Size: "+ map.size() );
        }
    }
}
