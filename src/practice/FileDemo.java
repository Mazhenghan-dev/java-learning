package practice;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDemo {
    static final String PATH = "demo-test.txt";

    public static void main(String[] args) throws IOException {
        // ===== 1. File 类：文件信息 =====
        System.out.println("===== 1. File 类 =====");
        File f = new File(PATH);
        System.out.println("路径："+f.getAbsolutePath());
        System.out.println("存在吗？"+f.exists());

        // ===== 2. 写文件（字符流 + try-with-resources）=====
        System.out.println("===== 2. 写文件 =====");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f, StandardCharsets.UTF_8))){
            bw.write("第一行：你好，Java IO");
            bw.newLine();
            bw.write("第二行：try-with-resources 自动关闭");
            bw.newLine();
            bw.write("第三行：中文不乱码");
        }
        System.out.println("  写入完成");
        System.out.println("  文件大小: " + f.length() + " 字节");

        // ===== 3. 读文件（字符流）=====
        System.out.println("===== 3. 读文件（BufferedReader）=====");
        try(BufferedReader br = new BufferedReader(new FileReader(f,StandardCharsets.UTF_8))){
            String line;
            int n = 1;
            while ((line = br.readLine()) != null){
                System.out.println(" "+ n++ +":"+line);
            }
        }
        // ===== 4. 更简单的写法：Files 工具类 =====
        System.out.println("===== 4. 更简单：Files.readAllLines =====");
        List<String> lines = Files.readAllLines(Paths.get(PATH));
        System.out.println("共"+lines.size()+"行");
        System.out.println("第一行："+lines.get(0));

        // ===== 5. 删除 =====
        System.out.println("===== 5. 删除文件 =====");
        System.out.println("删除成功？"+f.delete());
        System.out.println("还存在吗？"+f.exists());
    }
}
