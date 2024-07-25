package map;

import java.util.ArrayList;

class MapNode<K,V>{
    K key;
    V val;
    MapNode<K,V> next;

    public     MapNode(K key, V val) {
        this.key = key;
        this.val = val;
    }
}

public class MapU<K,V>{
    ArrayList<MapNode<K,V>> buckets;
    int size;
    int numBucket;

    public MapU(){
        numBucket=5;
        buckets=new ArrayList<>();
        for(int i=0;i<numBucket;i++){
            buckets.add(null);
        }
    }

    public int bucketIndex(K key){
        int hashcode = key.hashCode();
        return hashcode % numBucket;
    }

    public void insert(K key, V val){

        int index = bucketIndex(key);
        MapNode<K, V> head = buckets.get(index);
        while(head != null){
            if(head.key.equals(key)){
                head.val=val;
                return;
            }
            head=head.next;
        }
        head = buckets.get(index);
        MapNode<K, V> newNode = new MapNode<>(key, val);
        size++;
        newNode.next=head;
        buckets.set(index, newNode);
        //Rehashing
        double lf = size/(1.0 * numBucket);
        if(lf> 0.7){
            rehashing();
        }
    }

    public V getValue(K key){
        int index = bucketIndex(key);
        MapNode<K, V> head = buckets.get(index);
        while(head != null){
            if(head.key.equals(key)){
                return head.val;
            }
            head=head.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public V remove(K key){
        int index = bucketIndex(key);
        MapNode<K, V> head = buckets.get(index);
        MapNode<K, V> prev=null;
        while(head != null){
            if(head.key.equals(key)){
                if(prev==null){
                    buckets.set(index, head.next);
                }else{
                    prev.next=head.next;
                }
                size--;
                return head.val;
            }
            prev=head;
            head=head.next;
        }
        return null;
    }

    public void rehashing(){
        ArrayList<MapNode<K, V>> temp = buckets;
        numBucket = 2*numBucket;
        buckets = new ArrayList<>();
        for(int i=0;i< numBucket;i++){
            buckets.add(null);
        }

        size=0;
        for(int i=0;i<temp.size();i++){
            MapNode<K, V> head = temp.get(i);
            while(head != null){
                K key = head.key;
                V val = head.val;
                insert(key,val);
                head=head.next;
            }
        }
    }

    public double loadFactor(){
        return (1.0 * size) / numBucket;
    }

}
