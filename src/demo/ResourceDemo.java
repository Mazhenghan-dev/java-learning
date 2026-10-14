package demo;


public class ResourceDemo {
    static class MyResource implements AutoCloseable{
        String name;
        MyResource(String name){
            this.name=name;
            System.out.println("打开"+name);
        }
        void use(){
            System.out.println("使用"+name);
        }
        public void close(){
            System.out.println("关闭"+name);
        }
    }
    // 1. try-with-resources：自动关闭
    static void demo1(){
        System.out.println("===== 1. try-with-resources =====");
        try(MyResource r = new MyResource("资源A")) {
            r.use();
        }
        System.out.println();
    }
    // 2. 多个资源：倒序关闭
    static void demo2(){
        System.out.println("===== 2. 多个资源（倒序关闭）=====");
        try(MyResource a=new MyResource("A");MyResource b=new MyResource("B")){
            a.use();
            b.use();
        }
        System.out.println();
    }
    // 3. finally 里 return 会覆盖
    static int badFinally(){
        try {
            return 1;
        }finally {
            return 2;
        }
    }
    // 4. finally 里改局部变量没用
    static int modifyInFinally(){
        int x = 1;
        try {
           return x;
        }finally {
            x=999;
        }
    }
    // 5. 正常的 finally（不 return）
    static int goodFinally(){
        try {
            return 1;
        }finally {
            System.out.println("  finally 执行了，但没有 return");
        }
    }

    public static void main(String[] args) {
        demo1();
        demo2();

        System.out.println("===== 3. finally 里 return 会覆盖 =====");
        System.out.println("  badFinally() = " + badFinally());
        System.out.println();

        System.out.println("===== 4. finally 里改局部变量没用 =====");
        System.out.println("  modifyInFinally() = " + modifyInFinally());
        System.out.println();

        System.out.println("===== 5. 正常 finally =====");
        System.out.println("  goodFinally() = " + goodFinally());
    }
}
