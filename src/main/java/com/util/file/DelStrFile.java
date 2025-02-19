package com.util.file;

import java.io.*;

/**
 * 删除文件中的指定字符串，并将剩余保存到新文件中
 * @author 56465
 */
public class DelStrFile {

    public static void main(String[] args) {
        // 读取本地文件
        String filePath = "C:\\Users\\56465\\Desktop\\news.sql"; // 替换为你的文件路径
        String newFilePath = "C:\\Users\\56465\\Desktop\\news2.sql"; // 替换为你的文件路径
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFilePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                line = line.replaceAll("\\[.*?]", "");
                line = line.replaceAll("\\{.*?}", "");
                // 删除 <p> 到 </p> 之间的内容
                line = line.replaceAll("<p>.*?</p>", "");
                // 删除 <img 到 > 之间的内容
                line = line.replaceAll("<img.*?>", "");
                line = line.replaceAll("<.*?>", "");
                //line = line.replaceAll("\\(.*?\\)", "");

                if (!line.trim().isEmpty()){
                    writer.write(line+"\n");
                }

            }

            //writer.newLine(); // 如果需要在内容后添加新行
            //writer.flush(); // 确保缓冲区的数据被立即写入到文件
        } catch (FileNotFoundException e) {
            System.err.println("指定的文件未找到: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("读取文件时发生错误");
            e.printStackTrace();
        }



    }
}
