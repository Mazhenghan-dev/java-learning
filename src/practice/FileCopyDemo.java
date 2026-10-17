package practice;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileCopyDemo {
    static final String SRC = "copy_src.txt";
    static final String DST = "copy_dst.txt";

    public static void main(String[] args) throws IOException {
        // ===== 1. 先造一个源文件 =====
        Files.writeString(Paths.get(SRC),"HELLO 字节流! \n第二行:我要被复制过去。 \n", StandardCharsets.UTF_8);
        System.out.println("==== 1.源文件 ====");
        System.out.println(" "+SRC+"大小:"+ new File(SRC).length()+"字节");

        // ===== 2. 逐字节复制 =====
        System.out.println("===== 2. 逐字节复制 =====");
        try (FileInputStream in = new FileInputStream(SRC); FileOutputStream out = new FileOutputStream(DST)){
            int b;
            int count = 0;
            while((b = in.read()) != -1){
                out.write(b);
                count++;
            }
            System.out.println("复制了"+count+"个字节");
        }
        System.out.println(" "+DST+"大小:"+new File(DST).length()+"字节");

        // ===== 3. 验证内容完全一致 =====
        System.out.println("===== 3. 验证内容 =====");
        byte[] srcBytes = Files.readAllBytes(Paths.get(SRC));
        byte[] dstBytes = Files.readAllBytes(Paths.get(DST));
        System.out.println("两个文件内容相同？"+ Arrays.equals(srcBytes,dstBytes));

        // ===== 4. 用缓冲区复制（快得多）=====
        System.out.println("===== 4. 缓冲区复制（一次读 1KB）=====");
        String dst2 = "copy_dst2.txt";
        try (FileInputStream in = new FileInputStream(SRC); FileOutputStream out = new FileOutputStream(dst2)){
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1){
                out.write(buf,0,len);
            }
        }
        System.out.println(" "+dst2+" 大小:"+ new File(dst2).length() +"字节");

        // ===== 6. 用 BufferedInputStream（自带缓冲）=====
        System.out.println("===== 6. BufferedInputStream 复制 =====");
        String dst3 = "copy_dst3.txt";
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(SRC));BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(dst3))){
            int b;
            while((b = bin.read()) != -1){
                bout.write(b);
            }
        }
        System.out.println(" "+dst3+"大小:"+new File(dst3).length()+"字节");

        // ===== 5. 清理临时文件 =====
        System.out.println("===== 5. 清理 =====");
        Files.deleteIfExists(Paths.get(SRC));
        Files.deleteIfExists(Paths.get(DST));
        Files.deleteIfExists(Paths.get(dst2));
        System.out.println("已删除3个临时文件");
        Files.deleteIfExists(Paths.get(dst3));
        System.out.println("已删除4个临时文件");
    }
}
