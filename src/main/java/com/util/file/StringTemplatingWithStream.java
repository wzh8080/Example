package com.util.file;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 批量模板填充
 */
public class StringTemplatingWithStream {

    static String osfTemplate = "<field name=\"{#1}\" label=\"{#2}\"  type=\"STRING\" />";
    static String respTemplate = "params.put(\"{#1}\", \"{#2}\");\t// {#2}";
    static String nameCodeTemplate = "public static final String {#1}_{#2} = \"servplat.{#3}.{#4}\";";
    static String batchMetadataTemp = "<column index=\"{#1}\" name=\"{#2}\" label=\"{#3}\" type=\"CHAR\" displaySize=\"80\" precision=\"0\" scale=\"0\" format=\"\" />";
    static String controllerTemplate = "  /**\n" +
            "   *  {#1}\n" +
            "   * @param request\n" +
            "   * @param sm\n" +
            "   * @return\n" +
            "   * @throws Exception\n" +
            "   */\n" +
            "  @CrossOrigin\n" +
            "  @RequestMapping(path=\"{#2}\",method=RequestMethod.POST)\n" +
            "  @ResponseBody\n" +
            "  public ServiceMessage {#3}Handle(HttpServletRequest request,@RequestBody ServiceMessage sm) throws Exception {\n" +
            "      ServiceMessage smout = null;\n" +
            "      sm.getSysHead().setServiceName(NameCode.{#4}_{#5});\n" +
            "      smout = OSFClientManager.getManager()\n" +
            "              .getClient(NameCode.CLIENT)\n" +
            "              .callService(sm);\n" +
            "      return smout;\n" +
            "  }";

    public static void main(String[] args) {
        String str = "1\tinputdate       \t申请时间\n" +
                "2\tbusinesstypename\t产品名称\n" +
                "3\tbusinesssum     \t申请金额\n" +
                "4\tbankmanager     \t银行客户经理\n" +
                "5\tbankmanagerphone\t银行客户经理电话\n" +
                "6\tmanagername     \t业务经理\n" +
                "7\tmanagerphone    \t首创项目经理电话\n" +
                "8\tphaseperson     \t当前阶段联系人\n" +
                "9\tphasephone      \t当前阶段联系人电话\n" +
                "10\tflownode        \t业务流程节点\n" +
                "11\tflagonline      \t是否线上业务\n" +
                "12\tbusinesstype    \t产品编号\n" +
                "13\tflagcost        \t是否待缴费\n" +
                "14\tbusistyle       \t业务类型（融资/工程）（1-融资类，2-工程类）\n" +
                "15\tbusino          \t业务编号\n" +
                "16\tbusinesstype\t产品编号\n" +
                "17\tcustomerid\t客户编号\n" +
                "18\tcustomername\t客户名称\n" +
                "19\tpartner\t合作机构用户编号\n" +
                "20\tmanageuserid\t首创用户编号\n" +
                "21\ttaskdate\t批量日期\n";
        //run(str,osfTemplate);
        //System.out.println("---------");
        //run(str,respTemplate);
        run(str,batchMetadataTemp);
    }
    public static void run(String str,String template) {
        List<String[]> keyValuePairs = convertStringToKeyValuePairs(str);
        List<String> result = generateStringsFromTemplate(keyValuePairs, template);
        // 输出结果以验证
        result.forEach(System.out::println);
    }


    private static List<String[]> convertStringToKeyValuePairs(String input) {
        return Arrays.stream(input.split("\n"))
                .map(line -> line.trim().split("\t"))
                //.filter(pair -> pair.length == 2)
                .collect(Collectors.toList());
    }

    private static List<String> generateStringsFromTemplate(List<String[]> keyValuePairs, String template) {
        Pattern pattern = Pattern.compile("\\{#(\\d+)}");
        return keyValuePairs.stream()
                .map((pair) -> {
                    String r = template;
                    Matcher matcher = pattern.matcher(template);
                    while (matcher.find()) {
                        String match = matcher.group(); // 获取整个匹配的"{#数字}"字符串
                        String numberStr = matcher.group(1); // 提取括号中的数字
                        int number = Integer.parseInt(numberStr); // 将字符串转换为整数
                        r = r.replace(match, pair[number-1].trim());
                    }
                    return r;
                })
                .collect(Collectors.toList());
    }
}
