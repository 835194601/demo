package com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
//    public static void main(String[] args) {
//        String regEx1 = "[\\u4e00-\\u9fa5]";
//        String regEx2 = "[a-z||A-Z]";
//        String regEx3 = "[0-9]";
//        String str = "1 2fdAsz我是hhhZ大傻逼";
//        String s1 = matchResult(Pattern.compile(regEx1), str);
//        String s2 = matchResult(Pattern.compile(regEx2), str);
//        String s3 = matchResult(Pattern.compile(regEx3), str);
//        String s4 = matchResult(Pattern.compile("[\\u4e00-\\u9fa5]-[a-z||A-Z]-[0-9]"), str);
//        System.out.println(s1 + "\n" + s2 + "\n" + s3);
//        System.out.println(s4);
//    }
//
//    public static String matchResult(Pattern p, String str) {
//        StringBuilder sb = new StringBuilder();
//        Matcher m = p.matcher(str);
//        while (m.find())
//            for (int i = 0; i <= m.groupCount(); i++) {
//                sb.append(m.group());
//            }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100000; j++) {
                int k = i + j;
                if (k  == 0) {
                    System.out.println(k);
                }
            }
        }
        System.out.println("---------1---" + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                int k = i + j;
                if (k  == 0) {
                    System.out.println(k);
                }
            }
        }
        System.out.println("---------2---" + (System.currentTimeMillis() - now));
    }

//    public static void main(String[] args) {
//        char[] tmp = {'A','B','C'};
//        chs = tmp;
//        hasVisit = new boolean[chs.length];
//        dfs("");
//        for(String resTmp : res){
//            System.out.println(resTmp);
//        }
//    }
//    static List<String> res = new ArrayList<>();
//    static boolean[] hasVisit;
//    static char[] chs;
//    public static void dfs(String pre){
//        if(pre.length()==chs.length){
//            res.add(pre);
//        }
//        for(int i=0;i<chs.length;i++){
//            if(!hasVisit[i]){
//                hasVisit[i] = true;
//                dfs(pre+chs[i]);
//                hasVisit[i] = false;
//            }
//        }
//    }
}
