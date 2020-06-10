package com;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    //    @JSONField(name = "sum")
    public Integer sum;
    public String sum_public;
    public static boolean f;
    public boolean f1;

    public void convert() {
        this.sum_public = "[" + sum + ",9]";
    }



    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap();
        map.put("123", "String");



//        Class clazz = ArrayList.class;
//        Object o = clazz.newInstance();
//        HashMap o = (HashMap) clazz.newInstance();
//        o.put("aa", "aa");
//        System.out.println(o.getClass());
//        System.out.println(o.get("aa"));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
////        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss z", Locale.CHINESE);
////        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.US);
////        System.out.println(format.format(date));// M  , 26 F   2018 14:03:29 +0800
////        System.out.println(simpleDateFormat.format(date));
//
//        System.out.println(simpleDateFormat.parse("20190828"));
//        try {
//            try {
//                int a = 1 / 0;
//            }catch (Exception e) {
//                System.out.println("111");
//            }
//        }catch (Exception e) {
//            System.out.println("222");
//        }
//        List<Integer> list = new LinkedList<>();
//        list.get(0);
//        HashMap hashMap = new HashMap();
//        hashMap.put("key", "key");
//        System.out.println(Test.f);
//        Test t = new Test();
//        System.out.println(t.f1);
//        System.out.println("2020/01".compareTo("2019/10") > 0);
//        String str = "】";
//        System.out.println(str.replaceAll("\\{", "").replaceAll("\\|", ""));
//        int i = str.lastIndexOf("】");
//        String substring = str.substring(i + 1, str.length());
//        System.out.println(substring);
    }
}
