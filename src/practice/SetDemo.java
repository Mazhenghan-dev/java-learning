package practice;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {

        // ===== 1. 存重复元素 =====
        System.out.println("===== 1. 存重复元素 =====");
        Set<String> set = new HashSet<>();                  // Set 是接口，HashSet 是实现

        System.out.println(set.add("Java"));// true
        System.out.println(set.add("Python")); // true
        System.out.println(set.add("Java")); // false  ← 重复！
        System.out.println(set.add("C++"));// true
        System.out.println(set.add("Python")); // false  ← 重复！

        System.out.println("加入 Java, Python, Java, C++, Python 之后:");
        System.out.println(" "+set);
        System.out.println("  长度: " + set.size());// 3

        // ===== 2. 查 =====
        System.out.println("===== 2. 查 =====");
        System.out.println("  包含 Java 吗? "+set.contains("Java"));
        System.out.println("  包含 Go 吗? "+set.contains("GO"));

        // ===== 3. 删 =====
        System.out.println("===== 3. 删 =====");
        set.remove("Python");
        System.out.println("删除 Python 后:"+set);

        // ===== 4. 没有下标，不能 get() =====
        System.out.println("===== 4. 没有下标，不能 get() =====");
        System.out.println("  （想取出元素只能用遍历）");
        System.out.print("  遍历得到: ");
        for (String i : set){
            System.out.print(i);
        }
        System.out.println();

        // ===== 5. 无序性 =====
        System.out.println("===== 5. 无序性 =====");
        System.out.println("  HashSet 的遍历顺序【不保证】和加入顺序一致");
    }
}