public class LocalInnerDemo {
    private String outerField="外部类实例变量";
    void method(){
        int localVar = 100;//方法里的局部变量
        //localVar=200;
        // 👇 局部内部类：定义在方法【里面】
        class LocalInner{
            void show(){
                System.out.println("外部类成员："+outerField);
                System.out.println("方法局部变量："+localVar);
            }
        }
        new LocalInner().show(); // 只能在这个方法里 new
    }

    public static void main(String[] args) {
        new LocalInnerDemo().method();
    }
}
