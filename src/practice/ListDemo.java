package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        // ===== 1. 增 =====
        System.out.println("===== 1. 增 =====");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("加入3个后："+list);

        // ===== 2. 查 =====
        System.out.println("===== 2. 查 =====");
        System.out.println("第二个是："+list.get(1));
        System.out.println("Python的下标是："+list.indexOf("Python"));
        System.out.println("包含Go吗?"+list.contains("Go"));

        // ===== 3. 改 =====
        System.out.println("===== 3. 改 =====");
        list.set(1,"Kotlin");
        System.out.println(" "+list);

        // ===== 4. 删 =====
        System.out.println("===== 4. 删 =====");
        list.remove("Kotlin");
        System.out.println(" "+list);
        System.out.println("现在有"+list.size()+"个");

        // ===== 5. 三种遍历 =====
        System.out.println("===== 5. 三种遍历 =====");
        System.out.println("普通for：");
        for(int i = 0;i < list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(" ");
        System.out.print("增强 for: ");
        for (String s : list){
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("迭代器: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
