package com.test.java8;

/**
 * @Author 56465
 * @Create 2024/3/28 17:04
 */
public class InnerClassTest {
    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.new Inner().inPrint();
    }
    private String name ;

    private void print(){
        System.out.println("外部类的私有方法");
    }

    class Inner{
        public void inPrint(){
            name = "in";
            System.out.println("name = " + name);
            print();
        }
    }
}
