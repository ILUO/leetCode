package iluo.LRUCache;


import java.util.HashMap;
import java.util.Stack;

public class LRUCache {
    private Stack<Integer> stack;
    private HashMap<Integer,Integer> hashMap;
    private int capacity;

    public LRUCache(int capacity) {
        this.stack = new Stack<>();
        this.hashMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            stack.remove((Integer) key);
            stack.add(key);
            return hashMap.get(key);
        }else return -1;
    }

    public void put(int key, int value) {
        if(!hashMap.containsKey(key)){
            if(stack.size() == capacity){
                hashMap.remove(stack.get(0));
                stack.remove((stack.get(0)));
            }
            stack.add(key);
            hashMap.put(key,value);
        }else{
            stack.remove((Integer) key);
            stack.add(key);
            hashMap.put(key,value);
        }
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
