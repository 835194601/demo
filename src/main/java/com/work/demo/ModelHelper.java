package com.work.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author leiwang
 * @version 1.0
 * @since 2020-05-19
 */
public class ModelHelper {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/apple/Documents/focus_code/graphql/code/src/main/java/cn/focus/ecosystem/graphql" +
                "/model/news/NewsContent.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            if (s == null || s.equals("")) {
                continue;
            }

            if (s.contains("import ") || s.contains("@") || s.contains("public ") || s.contains("*")
                    || s.contains("/*") || s.contains("*/") || s.contains("package ")
                    || s.contains("class ") || s.contains("}") || s.trim().equals("") || s.trim().startsWith("//")) {
                continue;
            }

            s = s.replaceAll("//", "#").replaceAll(";", "").
                    replaceAll("public", "").replaceAll("protected", "")
                    .replaceAll("private", "");
            String[] split = s.trim().split(" ");
//            System.out.println(Arrays.toString(split));
            printArray(split);
        }
        bufferedReader.close();
    }

    public static void printArray(String[] inputStrings) {
        if (inputStrings == null || inputStrings.length == 0) {
            return;
        }

        String first = null;
        String sencond = null;
        for (int i = 0; i < inputStrings.length; i++) {
            if (first == null || first.equals("")) {
                first = inputStrings[i];
                continue;
            }
            if (first == null || first.equals("")) {
                continue;
            } else {
                if (sencond == null || sencond.equals(""))
                    sencond = inputStrings[i];
                if (sencond == null || sencond.equals("")) {
                    continue;
                }
            }
            break;
        }
        System.out.println("        " + sencond + ": " + first.replaceAll("Integer", "Int").replaceAll("int", "Int")
                .replaceAll("Double", "Float").replaceAll("double", "Float"));
    }
}
