package com.epam.collections.stringContainer;


public class StringContainer {
    private String[] str;
    private int capacity;

    public StringContainer(int size) {
        str = new String[size];
        capacity = 0;
    }

    public StringContainer() {
        str = new String[10];
        capacity = 0;
    }

    public int length() {
        return capacity;
    }

    public String get(int index) {
        return str[index];
    }

    public void add(String string) {
        if (capacity == str.length - 1) {
            String[] array = str;
            str = new String[str.length * 2];
            for (int i = 0; i < capacity; i++) {
                str[i] = array[i];
            }
        }
        str[capacity++] = string;


    }
}
