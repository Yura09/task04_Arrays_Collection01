package com.epam.collections.logicalTasksArrays;

import java.util.stream.IntStream;

public class Array {
    private static int[] taskA_1(int[] array1, int[] array2) {
        int[] temp = array1.length < array2.length ? array1 : array2;
        int size = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    temp[size] = array2[j];
                    ++size;
                    break;
                }
            }
        }
        int[] result = new int[size];
        System.arraycopy(temp, 0, result, 0, size);
        result = IntStream.of(result).distinct().toArray();
        return result;
    }

    private static int[] taskA_2(int[] array1, int[] array2) {
        int count = 0;
        int[] res = new int[array1.length + array2.length];
        int size = getCount(array1, array2, res, count);
        size = getCount(array2, array1, res, size);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = res[i];
        }
        result = IntStream.of(result).distinct().toArray();
        return result;
    }

    private static int[] taskB(int[] array) {
        int[] res = new int[array.length];
        int count = 0;
        int flag;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            flag = 0;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    flag++;
                }
            }
            if (flag <= 2) {
                res[count] = array[i];
                count++;
                continue;
            }
            index++;
        }
        System.arraycopy(res, 0, res, index, count);
        return res;
    }

    public static int[] taskC(int[] arr) {
        int[] newArray = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && i + 1 != arr.length - 1) {
                continue;
            } else {

                newArray[count] = arr[i];
                count++;
            }
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            newArray[count] = arr[arr.length - 1];
            count++;
        }
        int[] prevArray = newArray;
        newArray = new int[count];
        for (int i = 0; i < count; i++) {
            newArray[i] = prevArray[i];
        }
        return newArray;


    }

    private static int getCount(int[] array1, int[] array2, int[] res, int count) {
        boolean t;
        for (int i = 0; i < array1.length; i++) {
            t = true;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    t = false;
                    break;
                }
            }
            if (t) {
                res[count] = array1[i];
                ++count;
            }
        }
        return count;
    }

}
