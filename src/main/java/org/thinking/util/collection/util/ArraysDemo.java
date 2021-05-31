package org.thinking.util.collection.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel:)
 */
public class ArraysDemo {
    public static void main(String[] args) {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        //上面两个语句等价于下面一条语句
//        List<String> myList = Arrays.asList("Apple", "Banana", "Orange");

        ArrayList<String> list = new ArrayList<>();
        boolean b = Collections.addAll(list, myArray);
        list.forEach(System.out::println);

    }
}
