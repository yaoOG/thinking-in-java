package org.thinking.util.collection.util;

import java.util.HashMap;

/**
 * @author Daniel:)
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> hashmap = new HashMap<>();
        hashmap.put(1, "1-value");
        hashmap.put(2, "2-value");
        System.out.println(hashmap.toString());
    }
}
