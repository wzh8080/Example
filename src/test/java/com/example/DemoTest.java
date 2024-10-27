package test.java.com.example;

import org.junit.Test;

/**
 * @Author 56465
 * @Create 2024/7/26 10:49
 */
public class DemoTest {
    @Test
    public void name() {
        System.out.println("hello world 2");
    }

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("\n\n");
        sb.append("World");

        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append("Hello");
        sb.append(System.getProperty("line.separator"));
        sb.append("World");

        System.out.println(sb.toString());

        sb = new StringBuilder();
        sb.append("Hello\n");
        sb.append("World\n");

        System.out.println(sb.toString());
    }
}
