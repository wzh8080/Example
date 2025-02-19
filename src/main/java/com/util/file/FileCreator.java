package com.util.file;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;


/**
 * @Author 56465
 * @Create 2024/7/10 17:05
 */


public class FileCreator {

    /**
     * 在指定路径下创建一个新文件，并写入内容。
     *
     * @param content   文件的内容
     * @param fileType  文件的类型，例如 ".java"
     * @param path      文件的路径，不包含文件名
     */
    public static void createFileWithContent(String content, String fileType, String path) {
        // 检查路径是否以文件分隔符结束，如果不是，则添加一个
        if (!(path.endsWith("/")||path.endsWith("\\"))) {
            path += File.separator;
        }

        // 清空 path 路径下中的所有文件
        // 方法1
        //File file = new File(path);
        //if (file.exists()) {
        //    File[] files = file.listFiles();
        //    if (files != null) {
        //        for (File f : files) {
        //            f.delete();
        //        }
        //    }
        //}else{
        //    file.mkdirs();
        //}

        // 方法2
        clearDirectory(path);

        // 获取当前日期作为文件名的一部分，以避免重复
        String fileName = "file_" + System.currentTimeMillis() + fileType;

        // 构建完整的文件路径
        String fullPath = path + fileName;

        // 方法1：使用BufferedWriter
        try {
            // 使用UTF-8编码
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("b.txt"), StandardCharsets.UTF_8));
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方法2：使用Files.newBufferedWriter
        Path path2 = Paths.get("b.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path2, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write("测试");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearDirectory(String path) {
        Path dirPath = Paths.get(path);

        try (Stream<Path> paths = Files.walk(dirPath)) {
            // Filter out the root directory itself so it's not deleted
            paths.filter(p -> !p.equals(dirPath))
                    // Sort in reverse order to delete subdirectories after their contents
                    .sorted((p1, p2) -> p2.compareTo(p1))
                    .forEach(p -> {
                        try {
                            Files.deleteIfExists(p);
                        } catch (IOException e) {
                            System.err.println("Could not delete " + p);
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            System.err.println("Could not walk directory " + dirPath);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String content = "public class MyClass {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World!\");\n" +
                "    }\n" +
                "}";
        String fileType = ".java";
        String path = "/path/to/your/directory";

        createFileWithContent(content, fileType, path);
    }
}