package com.test.java12;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/3/28 17:14
 */
public class SwitchTest {
    /**
     * 不写break语句，则执行完当前case语句后，会继续执行下一个case语句
     * 即会引起 switch 贯穿
     */
    @Test
    public void test01(){
        // 声明变量score，并为其赋值为'C'
        var score = 'C';
        // 执行switch分支语句
        switch (score) {
            case 'A':
                System.out.println("优秀");
            case 'B':
                System.out.println("良好");
            case 'C':
                System.out.println("中");
            case 'D':
                System.out.println("及格");
            case 'E':
                System.out.println("不及格");
                break;
            default:
                System.out.println("数据非法！");
        }
    }

    /**
     * switch 的新写法，可以不用break语句
     */
    @Test
    public void test02(){
        var score = 'B';
        switch (score){
            case 'A' -> System.out.println("优秀");
            case 'B' -> System.out.println("良好");
            case 'C' -> System.out.println("中");
            case 'D' -> System.out.println("及格");
            case 'E' -> System.out.println("较差");
            default -> System.out.println("成绩数据非法！");
        }
    }

    /**
     * switch可以作为一个表达式返回执行的结果了。
     */
    @Test
    public void test03(){
        var score = 'B';
        String rs = switch (score){
            case 'A' -> "优秀";
            case 'B' -> "良好";
            case 'C' -> "中";
            case 'D' -> "及格";
            case 'E' -> "较差";
            default -> "成绩数据非法！";
        };
        System.out.println("执行的结果："+rs);
    }

    /**
     * switch可以作为一个表达式返回执行的结果了。
     */
    @Test
    public void test04(){
        var score = 'C';
        String rs = switch (score){
            case 'A','B' -> "优秀";
            case 'C','D' -> "中等";
            case 'E' -> "一般";
            default -> "成绩数据非法！";
        };
        System.out.println("执行的结果："+rs);
    }

    /**
     * Yielding a value
     */
    @Test
    public void test05(){
        // 声明变量score，并为其赋值为'C'
        var score = 'E';
        String result = switch (score) {
            case 'A', 'B' -> "上等";
            case 'C' -> "中等";
            case 'D', 'E' ,'F'-> {
                if (score == 'D') {
                    yield "数据是 D";
                } else if(score == 'E'){
                    yield score + "数据是 E";
                } else {
                    yield score + "数据是 F";
                }
            }
            default -> "其他";
        };
        System.out.println(result);
    }
}
