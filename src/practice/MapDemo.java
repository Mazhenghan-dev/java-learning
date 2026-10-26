package practice;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // ===== 1. 存（key → value）=====
        System.out.println("===== 1. 存 =====");
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 90);
        map.put("Python", 85);
        map.put("C++", 80);
        System.out.println("存入3个后：" + map);

        // ===== 2. 取 =====
        System.out.println("===== 2. 取 =====");
        System.out.println("Java的分数：" + map.get("Java"));
        System.out.println("Go的分数：" + map.get("Go"));// key 不存在 → null

        // ===== 3. key 重复会覆盖 =====
        System.out.println("===== 3. key 重复会覆盖 =====");
        Integer old = map.put("Java", 95);
        System.out.println("覆盖后Java的分数：" + map.get("Java"));
        System.out.println("put返回的旧值：" + old);

        // ===== 4. 查 =====
        System.out.println("===== 4. 查 =====");
        System.out.println("包含Java吗：" + map.containsKey("Java"));
        System.out.println("包含Go吗：" + map.containsKey("Go"));
        System.out.println("有几个键值对：" + map.size());


        // ===== 5. 三种遍历 =====
        System.out.println("===== 5. 三种遍历 =====");

        System.out.print("遍历   key: ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println(" ");

        System.out.print("遍历 value: ");
        for (Integer v : map.values()) {
            System.out.print(v + " ");
        }
        System.out.println(" ");

        System.out.print(" 遍历键值对: ");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.print(e.getKey() + "=" + e.getValue() + " ");
        }
        System.out.println(" ");

        // ===== 6. 删 =====
        System.out.println("===== 6. 删 =====");
        map.remove("Python");
        System.out.println(" 删除Python后："+map);
    }
}
