package com.example.javafx.bar;

import java.util.function.BiConsumer;

/**
 * @Author zhwang
 * @Create 2024/11/7 13:59
 */
public class Execute {
    public void updateFiles(int totalFiles, BiConsumer<Integer, Integer> progressCallback) {
        for (int i = 1; i <= totalFiles; i++) {
            // 模拟文件更新操作
            updateFile(i);
            // 模拟耗时操作
            try {
                Thread.sleep(100); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 通知外部进度
            progressCallback.accept(i, totalFiles);
        }
    }

    private void updateFile(int fileNumber) {
        // 模拟文件更新逻辑
        System.out.println("正在更新文件 " + fileNumber);
    }
}