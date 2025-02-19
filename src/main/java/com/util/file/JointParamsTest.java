package com.util.file;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 弃用
 * @author 56465
 */
public class JointParamsTest {
    static String[] tempOSFXml = {"<field name=\"", "\" label=\"", "\"  type=\"STRING\" />"};
    static String[] tempJavaRsp = {"params.put(\"", "\", \"", "\");\t// ","1"};

    public static void main(String[] args) {
        String str = "businesstype\t业务品种\n" +
                "customername\t客户名称\n" +
                "businesssum\t申请金额（元）\n" +
                "bankmanager\t银行客户经理\n" +
                "managername\t业务经理\n" +
                "currency\t币种\n" +
                "busino\t业务号\n" +
                "flownode\t业务流程节点\n";
        List<String> result = convertStringWithTemplate(str, tempOSFXml);
        // 输出结果以验证
        result.forEach(System.out::println);
    }

    public static List<String> convertStringWithTemplate(String input, String[] template) {
        // 按行分割字符串
        String[] lines = input.split("\n");
        // 转换成List<String[]>
        List<String[]> keyValuePairs = new ArrayList<>();
        for (String line : lines) {
            String[] pair = line.trim().split("\t");
            if (pair.length == 2) {
                keyValuePairs.add(pair);
            }
        }

        // 使用模板和键值对生成新的字符串
        return keyValuePairs.stream()
                .map(pair -> template[0] + pair[0] + template[1] + pair[1] + template[2])
                .collect(Collectors.toList());
    }
}