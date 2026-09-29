import java.util.Arrays;
import java.util.Comparator;

public class AnonymousInnerDemo {
    static class Student{
        String name;
        int score;
        Student(String name,int score){
            this.name=name;
            this.score=score;
        }
        public String toString(){
            return name+" "+score+"分";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("1.匿名内部类实现Runnable");
        Runnable task=new Runnable() {
            @Override
            public void run() {
                System.out.println("我是匿名内部类里的run(),跑在线程："+Thread.currentThread().getName());
            }
        };

        Thread t=new Thread(task,"我的线程");
        t.start();
        t.join();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("直接塞进去的匿名内部类也在跑");
            }
        }).start();
        Thread.sleep(100);

        System.out.println();
        System.out.println("2.字符串按长度排序");

        String[] names={"Bob","AI","Christopher","Dave"};
        System.out.println("排序前："+ Arrays.toString(names));

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        System.out.println("按长度排序后："+Arrays.toString(names));

        System.out.println();
        System.out.println("3.学生按分数从高到低");

        Student[] students={
                new Student("张三",88),
                new Student("李四",95),
                new Student("王五",72)
        };
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.score- s1.score;
            }
        });
        for (Student s :students){
            System.out.println(" "+s);
        }

        System.out.println();
        System.out.println("4.匿名内部类 vs Lambda");

        Runnable oldWay =new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类写法（6行）");
            }
        };
        oldWay.run();

        Runnable newWay=() -> System.out.println("lambda写法（1行）");
        newWay.run();
    }
}
