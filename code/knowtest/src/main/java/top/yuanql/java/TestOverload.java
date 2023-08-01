package top.yuanql.java;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.java
 * @BelongsClassName: TestOverload
 * @Author: yuanql
 * @CreateTime: 2023-08-01  19:18
 * @Description:
 * @Version: 1.0
 */


public class TestOverload {

    public static void main(String[] args) {
        A b = new A();
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
    }

}

class A {
    public void run() {
        System.out.println("a");
    }

    public void test() {
        System.out.println("aaaa");
        run();
    }
}
class B extends A {
    public void run() {
        System.out.println("b");
    }
    public void test() {
        System.out.println("bbbb");
        run();
    }

    

}