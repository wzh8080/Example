package com.test.java9;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 56465
 */
public class Java9Test {
    @Test
    public void test01() throws IOException {
        //需要释放资源的流，填写在try()中
        FileInputStream fileInputStream = new FileInputStream("D:/a.txt");
        try(fileInputStream){
            //1. 建立程序与文件的数据通道
            //2. 创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0 ;
            //3. 读取数据，并且输出
            while((length = fileInputStream.read(buf))!=-1){
                System.out.println(new String(buf,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // fileInputStream 已关闭 不可再用
    }

    /**
     * "_"不能作为单独的标识符(变量名)
     */
    public void test02(){
        //String _  = "hello";
        //System.out.println(_);
    }
    public void test03(){
        String a  = "hello";
        List<String> a1 = List.of("a", "b", "c");

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("a");
        }

        List<String> list1 = Collections.unmodifiableList(list);

    }
}
