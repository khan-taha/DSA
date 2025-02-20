package com.tahakhan.datastructures.dsa;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DSA<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int len = 0;
    private int capacity;

    public DSA() {
        this(DEFAULT_CAPACITY);
    }

    public DSA(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T elem) {
        array[index] = elem;
    }

    public void clear() {
        array = (T[]) new Object[capacity];
        len = 0;
    }

    public void add(T elem) {
        if (len + 1 >= capacity) {
            capacity = capacity == 0 ? 1 : capacity*2;
            array = Arrays.copyOf(array, capacity);
        }
        array[len++] = elem;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        T data = array[index];
        System.arraycopy(array, index + 1, array, index, len - index - 1);
        capacity = --len;
        return data;
    }

    public boolean remove(T elem) {
        for (int i = 0;i < len; i++) {
            if (elem == array[i]) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T elem) {
        for (int i = 0; i < len;i++) {
            if (elem == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    public T[] reverse() {
        T[] reverseArray = (T[]) new Object[len];
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            reverseArray[j] = array[i];
        }
        return reverseArray;
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder().append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            return sb.append(array[len - 1]).append("]").toString();
        }
    }

    public T[] sort() {
        T[] temp = array.clone();
        Arrays.sort(temp, 0, len - 1);
        return temp;
    }

    public static void main(String[] args) {
        DSA<Integer> dsa1 = new DSA<>();

        System.out.println("----- dsa1 ----");

        System.out.println("isEmpty: " + dsa1.isEmpty());

        dsa1.add(1);
        dsa1.add(10);
        dsa1.add(78);
        dsa1.add(13);
        dsa1.add(35);

        System.out.println(dsa1);
        System.out.println("[1]: " + dsa1.get(1));

        dsa1.set(1, 12);
        System.out.println("updated [1]: " + dsa1.get(1));

        System.out.println("remove 13: " + dsa1.remove(13));
        System.out.println("after removing 13: " + dsa1);

        System.out.println("remove [2]: " + dsa1.removeAt(2));
        System.out.println("after removing [2]: " + dsa1);

        System.out.println("91 exists: " + dsa1.contains(99));

        System.out.println("reverse: " + Arrays.toString(dsa1.reverse()));

        System.out.println("after sort: " + Arrays.toString(dsa1.sort()));

        dsa1.clear();
        System.out.println("dsa1 cleared: " + dsa1);

        System.out.println("----- dsa1 ----");
    }
}
