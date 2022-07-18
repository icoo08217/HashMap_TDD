package com.ll.exam;


import java.util.ArrayList;
import java.util.List;

class HashMap<K , V> {

    Object[] keys;
    Object[] values;
    int index;

    public HashMap() {
        keys = new Object[100];
        values = new Object[100];
        index = 0;
    }

    public int indexOfKey(K key){
        for (int i = 0; i < index; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }

        return -1;

    }

    public void put(K key, V value) {

        int keyIndex = indexOfKey(key);

        if (keyIndex != -1) {
            values[keyIndex] = value;
            return;
        }

        keys[index] = key;
        values[index] = value;
        index++;
    }

    public V get(K key) {
        int keyIndex = indexOfKey(key);

        if (keyIndex == -1) {
            return null;
        }
        return (V) values[keyIndex];
    }

    public int size() {
        return index;
    }

    public void remove(K key) {
        int keyIndex = indexOfKey(key);
        if (keyIndex == -1) {
            return;
        }

        moveLeft(keys, keyIndex + 1 , index - 1);
        moveLeft(values, keyIndex + 1 , index - 1);
        index--;
    }

    private void moveLeft(Object[] keys, int fromIndex, int toIndex) {
        for (int i = fromIndex; i <= toIndex; i++) {
            keys[i - 1] = keys[i];
        }
    }

    public List<K> keySet() {
        List<K> list = new ArrayList<>();

        for (int i = 0; i < index; i++) {
            list.add((K) keys[i]);
        }

        return list;
    }
}