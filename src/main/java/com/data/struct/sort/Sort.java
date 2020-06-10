package com.data.struct.sort;

/**
 * @author leiwang
 * @version 1.0
 * @since 2020-04-04
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = {2, 1, 9, 3, 6, 7, 2, 8, 0};
        quickSort(a, 0, a.length - 1);
//        mergeSort(a);
        printArray(a);
//        char[] a = {'a', 'b', 'c', 'd'};
//        arrange(a, 0, a.length - 1);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 插入排序
     */
    public static int[] insertSort(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        for (int i = 1; i < a.length; i++) {
            printArray(a);
            int p = i;
            int tmp = a[i];
            for (; p > 0 && tmp < a[p - 1]; p--) {
                a[p] = a[p - 1];
            }
            a[p] = tmp;
        }
        return a;
    }

    /**
     * 希尔排序
     */
    public static int[] shellSort(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                int j = i;
                int tmp = a[i];
                printArray(a);
                for (; j >= gap && tmp > a[j - gap]; j = j - gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
        return a;
    }

    /**
     * 归并排序
     */
    public static int[] mergeSort(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
        return a;
    }

    public static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < a[rightPos]) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    /**
     * 输出全排列
     */
    private static void arrange(char[] a, int start, int end) {
        if (a == null || a.length == 0) {
            return;
        }

        if (start == end) {
            printArray(a);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(a, i, start);
            arrange(a, start + 1, end);
            swap(a, i, start);
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        if (a == null || a.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }

        int base = findBase(a, left, right);
        int i = left, j = right - 1;
        while (true) {
            while (a[++i] < base) { }
            while (a[--j] > base) { }
            if (i < j) {
                swap(a, i, j);
            } else {
                break;
            }
        }
        swap(a, i, right - 1);
        quickSort(a, left,  i - 1);
        quickSort(a, i + 1, right);
    }

    public static int findBase(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[left] > a[center]) {
            swap(a, left, center);
        }
        if (a[left] > a[right]) {
            swap(a, left, right);
        }
        if (a[center] > a[right]) {
            swap(a, center, right);
        }
        swap(a, center, right - 1);
        return a[right - 1];
    }

    private static void swap(int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    private static void swap(char[] a, int left, int right) {
        char tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    private static void printArray(char[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
