package com.test.java11;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * JDK 11对于IO方法的改变。
 * @Author 56465
 * @Create 2024/3/28 15:37
 */
public class IOTest {
    String filePathName = "src/test/resources/itheima.txt";
    @Test
    public void test01() throws IOException {
        Path path = Path.of(filePathName);
        // Files类更方便的读写数据方法
        Files.writeString(path,"Java的学习，JDK11新特性！");
        // Files类更方便的读数据方法
        String rs = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println(rs);
    }

    /**
     * 关于路径
     * @throws IOException
     */
    @Test
    public void test011() throws IOException {
        System.out.println("filePathName = " + filePathName);
        Path path = Path.of(filePathName);
        System.out.println(path.endsWith("txt"));
        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getFileSystem() = " + path.getFileSystem());
        System.out.println("path.getFileSystem().getSeparator() = " + path.getFileSystem().getSeparator());
        System.out.println("path.getName(0) = " + path.getName(0));
        System.out.println("path.getName(path.getNameCount() - 1) = " + path.getName(path.getNameCount() - 1));
        System.out.println("path.getRoot() = " + path.getRoot());
        System.out.println("path.getParent() = " + path.getParent());
        System.out.println("path.getNameCount() = " + path.getNameCount());

        System.out.println("path.isAbsolute() = " + path.isAbsolute());
    }
    @Test
    public void test02() throws IOException {
        // Reader新增方法：得到一个不执行任何操作的Reader
        Reader fr = Reader.nullReader();
        System.out.println(fr.read());
    }
    @Test
    public void test03() throws IOException {
        // InputStream 还终于有了一个非常有用的方法：transferTo
        try(
                InputStream is = new FileInputStream(filePathName);
                OutputStream os = new FileOutputStream("newItheima.txt");
        ){
            // 开始把字节输入流中的全部字节数据转移到字节输出流中去。
            is.transferTo(os);
            System.out.println("复制完成！");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
