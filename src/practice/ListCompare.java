package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCompare {
    public static void main(String[] args) {
        // ===== 1. 头部插入 5 万次：谁快？ =====
        System.out.println("===== 1. 头部插入 5 万次 =====");

        List<Integer> arrayList = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        for(int i = 0;i < 50000;i++){
            arrayList.add(0,i);// 每次都插到【最前面】
        }
        long t2 = System.currentTimeMillis();
        System.out.println("ArrayList："+(t2-t1)+"ms");

        List<Integer> linkedList = new LinkedList<>();
        long t3 = System.currentTimeMillis();
        for(int i = 0;i < 50000;i++){
            linkedList.add(0,i);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("LinkedList："+(t4-t3)+"ms");

        // ===== 2. 按下标取 1000 次：谁快？ =====
        System.out.println("===== 2. 按下标 get() 1000 次 =====");

        long t5 = System.currentTimeMillis();
        for(int i = 0;i<1000;i++){
            arrayList.get(arrayList.size()/2);
        }
        long t6 = System.currentTimeMillis();
        System.out.println("ArrayList："+(t6-t5)+"ms");
        long t7 = System.currentTimeMillis();
        for(int i = 0;i<1000;i++){
            linkedList.get(linkedList.size()/2);
        }
        long t8 = System.currentTimeMillis();
        System.out.println("ArrayList："+(t8-t7)+"ms");
    }
}
