package demo;

import java.io.IOException;

public class ExceptionDemo {

    //自定义异常（非受检：继承 RuntimeExcecption)
    static class MyException extends RuntimeException{
        MyException(String msg){super(msg);}
    }

    //受检异常：方法上必须声明 thorws
    static void checkedDemo() throws IOException{
        throw new IOException("文件不存在");
    }

    public static void main(String[] args) {
        System.out.println("==== 1.非受检：除零 ====");
        try{
            int x = 10 / 0;
        }catch (ArithmeticException e){
            System.out.println(" 捕获："+e.getClass().getSimpleName()+"-"+e.getMessage());
        }

        System.out.println("==== 2.非受检：数组越界 ====");
        try{
            int[] arr = {1,2,3};
            System.out.println(arr[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(" 捕获："+e.getClass().getSimpleName());
        }

        System.out.println("==== 3.非受检：空指针 ====");
        try{
            String s = null;
            System.out.println(s.length());
        }catch (NullPointerException e){
            System.out.println(" 捕获："+e.getClass().getSimpleName());
        }

        System.out.println("==== 4.受检：必须处理 ====");
        try{
            checkedDemo();
        }catch (IOException e){
            System.out.println(" 捕获："+e.getClass().getSimpleName()+"-"+e.getMessage());
        }


        System.out.println("==== 5.finally 一定执行 ====");
        try{
            System.out.println("try 里");
            throw new RuntimeException("故意抛一个");
        }catch (RuntimeException e){
            System.out.println("catch 里");
        }finally {
            System.out.println("finally 里（一定执行）");
        }

        System.out.println("==== 6.自定义异常 ====");
        try{
            throw new MyException("业务出错了");
        }catch (MyException e){
            System.out.println("捕获自定义异常："+e.getMessage());
        }
    }
}
