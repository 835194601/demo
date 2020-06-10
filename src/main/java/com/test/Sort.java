package com.test;

public class Sort {
    public static void main(String[] args) {
        String[] strArray = {"123", "52", "9"};// expect outcome 952123
        String[] strArrayNew = sort(strArray);
        for (int i = 0; i < strArrayNew.length; i++) {
            System.out.print(strArrayNew[i] + " ");
        }
    }

    public static String[] sort(String[] strArray) {
        if (strArray == null || strArray.length == 0) {
            return null;
        }

        for (int i = 1; i < strArray.length; i++) {
            String tmp = strArray[i];
            int j = i;
            for (; j > 0; j--) {
                String tmpCompare = strArray[j - 1];
                String f1 = tmp + tmpCompare;
                String f2 = tmpCompare + tmp;
                // 假设这里不会有溢出
                if (Integer.parseInt(f1) > Integer.parseInt(f2)) {
                    strArray[j] = strArray[j - 1];
                } else {
                    break;
                }
            }
            strArray[j] = tmp;
        }
        return strArray;
    }
}