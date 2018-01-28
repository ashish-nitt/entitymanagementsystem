package com.ems.model;

import java.util.Hashtable;

/**
 * Created by Ashish on 29-01-2018.
 */
public class MyHashTable<K,V> {
    private Hashtable<K,V> map;
    public MyHashTable() {
        map = new Hashtable<>();
    }
    public Boolean has(K k) {
        return map.containsKey(k);
    }
    public V get(K k) {
        return (V) map.get(k);
    }
    public V addNew(K k, V v) {
        if (! has(k)) {
            V v1 = map.putIfAbsent(k,v);
            V v2 = map.get(k);
            if (v.equals(v2)) return v;
        }
        return null;
    }
    public V add(K k, V v) {
        map.put(k,v);
        return v;
    }
    public Boolean remove(K k) {
        if (map.containsKey(k)) {
            map.remove(k);
            return true;
        }
        return false;
    }
}
