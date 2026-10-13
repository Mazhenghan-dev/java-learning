package demo;

public class InnerClassDemo {
    private String outerField = "外部类实例变量";
    private static String outerStatic = "外部类静态变量";

    class MemberInner{
        void show(){
            System.out.println("静态成员："+outerStatic);
            System.out.println("实例成员："+outerField);
        }
    }

    static class StaticInner{
        void show(){
            System.out.println("静态成员："+outerStatic);
            //System.out.println("实例成员："+outerField);
        }
    }

    void method(){
        final int localVar = 100;
        class LocalInner{
            void show(){
                System.out.println("方法局部变量："+localVar);
            }
        }
        new LocalInner().show();
    }

    public static void main(String[] args) {
        InnerClassDemo outer = new InnerClassDemo();

        System.out.println("①成员内部类");
        outer.new MemberInner().show();

        System.out.println("②静态内部类");
        new InnerClassDemo.StaticInner().show();

        System.out.println("③局部内部类");
        outer.method();

        System.out.println("④匿名内部类");
        new Runnable(){
            public void run(){
                System.out.println("匿名内部类跑起来了");
            }
        }.run();
    }
}
