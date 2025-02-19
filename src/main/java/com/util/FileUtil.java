package com.util;

import java.io.UnsupportedEncodingException;

/**
 * @Author zhwang
 * @Create 2024/11/5 15:24
 */
public class FileUtil {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            //System.out.println(getIntervalNumber("(2, 6)"));
            System.out.print(getRandomChar(10));
            System.out.println();
        }

    }

    /**
     * 随机生成指定长度的字符串
     * @param length
     * @return
     */
    public static String getRandomChar(int length){
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            //sb.append((char) (0x4e00 + (Math.random() * (0x9fa5 - 0x4e00 + 1))));
            byte[] bytes = new byte[]{
                    (byte)(0xa0 + (16+ (int)(Math.random()*40))),
                    (byte)(0xa0 + (1+ (int)(Math.random()*94))),
            };
            try {
                sb.append(new String(bytes,"gb2312"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return sb.toString();
    }

    public static int getIntervalNumber(String intervalStr) {
        intervalStr = intervalStr.replaceAll(" ", "");
        String numStr = intervalStr.substring(1, intervalStr.length() - 1);
        String[] numArr = numStr.split(",");
        int min = 0;
        int max = 0;
        if (intervalStr.startsWith("[")) {
            min = Integer.parseInt(numArr[0]);
        } else if (intervalStr.startsWith("(")) {
            min = Integer.parseInt(numArr[0]) + 1;
        }
        if (intervalStr.endsWith("]")) {
            max = Integer.parseInt(numArr[1]);
        } else if (intervalStr.endsWith(")")) {
            max = Integer.parseInt(numArr[1]) - 1;
        }
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
