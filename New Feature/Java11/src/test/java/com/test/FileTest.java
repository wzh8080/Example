package com.test;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 新方法：transferTo
 * @Author 56465
 * @Create 2024/3/28 14:09
 */
public class FileTest {
    /**
     * JDK10 给 InputStream 和 Reader 类中新增了 transferTo 方法， transferTo 方法的作用是将输入流读取的数据
     * 使用字符输出流写出。可用于复制文件等操作。
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        FileReader fis = new FileReader("src/test/resources/a.txt");
        FileWriter fos = new FileWriter("src/test/resources/b.txt");
        fis.transferTo(fos);
        fis.close();
        fos.close();
    }
}
