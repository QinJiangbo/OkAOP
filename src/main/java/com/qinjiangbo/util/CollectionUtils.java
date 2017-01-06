package com.qinjiangbo.util;

import com.qinjiangbo.exception.KeysUnmatchedException;

import java.util.*;

/**
 * @date: 05/01/2017 11:30 AM
 * @author: qinjiangbo@github.io
 */
public class CollectionUtils {

    /**
     * create a linked list with parameters
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> newLinkedList(T... args) {
        List<T> list = new LinkedList<T>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }

    /**
     * create a array list with parameters
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList(T... args) {
        List<T> list = new ArrayList<T>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }

    /**
     * create a hash map with given keys and values
     * @param keys
     * @param values
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> newHashMap(List<K> keys, List<V> values) {
        Map<K, V> map = new HashMap<>();
        int size0 = keys.size();
        int size1 = values.size();
        if (size0 != size1) {
            throw new KeysUnmatchedException("keys and values are not matched : keys length("
                    + size0 +") and values length(" + size1 + ")");
        }
        for (int i = 0; i<size0; i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
