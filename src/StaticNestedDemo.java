public class StaticNestedDemo {
    private static String outerStaticField = "外部类的【静态】变量";
    private static String outerInstanceField = "外部类的【实例】变量";

    static class StartInner{
        void show(){
            System.out.println("StaticInner读到了："+outerStaticField);
            //System.out.println(outerInstanceField);
        }
    }

    class MemberInner{
        void show(){
            System.out.println("MemberInner读到了："+outerStaticField);
            System.out.println("MemberInner读到了："+outerInstanceField);
        }
    }

    public static void main(String[] args) {
        System.out.println("静态内部类");
        StaticNestedDemo.StartInner si=new StaticNestedDemo.StartInner();
        si.show();;

        System.out.println();
        System.out.println("成员内部类");
        StaticNestedDemo outer=new StaticNestedDemo();
        StaticNestedDemo.MemberInner mi=outer.new MemberInner();
        mi.show();
    }

}
