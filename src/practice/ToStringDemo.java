package practice;

public class ToStringDemo {

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        // ===== 第 1 步：先【空着】，直接跑 main =====
        // 观察 println(s) 会输出什么

        // ===== 第 2 步：把下面这个方法【取消注释】，再跑一次 =====
        @Override
        public String toString() {
            return name + " " + score + "分";
         }
    }

    public static void main(String[] args) {
        Student s = new Student("张三", 88);
        System.out.println(s);      // ← 两次跑，观察这一行的变化
    }
}