package com.sohu.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern PATTERN = Pattern.compile("([a-z]{1,2})([0-9\\-]+)");
    private static final Pattern PATTERNS = Pattern.compile("([0-9-]+)");

    public static void main(String[] args) throws Exception {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
//
//        DemoAnnotationService bean = context.getBean(DemoAnnotationService.class);
//        bean.add();
//        context.close();
//        boolean flag = true;
//        Object o = flag;
//        System.out.println(o);
//        Matcher matchers = PATTERNS.matcher("9");
//        System.out.println(matchers.matches());
//        String s = "q3_s6551_h3";
//        for (String str : s.split("_")) {
//            Matcher matcher = PATTERN.matcher(str);
//            System.out.println(str + "---" + matcher.matches() + "---" + matcher.group(1) + "--" + matcher.groupCount());
//            if (!matcher.matches() || matcher.groupCount() != 2) {
//                System.out.println("-----");
//                continue;
//            }
//        }

//        Integer i = 1;
//        String s = "1";
//        System.out.println(s.equals(i));

//        Random random = new Random();
//        System.out.println(random.nextInt(1000000));
//        List list = new LinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        method(list);
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            final int k = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " user" + (k + 1));
//                }
//            });
//        }
//        Thread.sleep(3000);
//        for (int i = 0; i < 5; i++) {
//            final int k = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + " user" + (k + 1));
//                }
//            });
//        }
//        int pow = Double.valueOf(Math.pow(2, 4)).intValue();
        System.out.println(3 | 1);
//        System.out.println(pow >> 1);

//        for (int i = 0; i < 1; i++) {
//            System.out.println("----");
//        }
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        System.out.println((l - 1000 * 86400 * 180L));
        Long time = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(time) + "----");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        Date date = calendar.getTime();
        System.out.println(date.getTime());
        System.out.println(simpleDateFormat.format(date));

        Calendar calendar1 = Calendar.getInstance();
//        calendar1.add(Calendar.DATE, 0);
        calendar.setTime(new Date());
        String s = simpleDateFormat.format(calendar1.getTime()) + " 00:00:00";
        Date parse = simpleDateFormat.parse(s);
        System.out.println("--------" + parse.getTime());
        System.out.println(simpleDateFormat.format(calendar1.getTime()) + " 00:00:00");
//        System.out.println(Pattern.matches(".*/\\d+/","https://m.focus.cn/jfkldsajfklas/loupan/1234/huxingh"));
//        Date epoch = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/1970 01:00:00");
//        System.out.println(epoch);
//        Pattern pattern = Pattern.compile(".*/\\d+/");
//        String str = "http://m.focus.cn/tj/loupan/31523/";
//        if (pattern.matcher(str).matches()) {
//            System.out.print("tmpMethod url:{}");
//        }
//        int pNum = (int) Math.floor(15 / 10.0);
//        System.out.println(pNum);
//        System.out.println(15 / 10.0);
    }

//    public static void method(List list) {
//        List list1 = list;
////        list1.addAll(list);
//        list1.remove(2);
//        System.out.println(list1);
//        System.out.println(list);
//    }
}
