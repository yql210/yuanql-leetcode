package top.yuanql.java;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.java
 * @BelongsClassName: TestFinallyReturn
 * @Author: yuanql
 * @CreateTime: 2023-08-04  16:18
 * @Description:
 * @Version: 1.0
 */


public class TestFinallyReturn {
    public static RetDto show() {
        RetDto obj = new RetDto();
        try {
            obj.name = "张三";
            obj.age = 88;
            return obj;
        }finally{
            System.out.println("finally模块被执行");
            obj.name = "李四";
            obj.age = 44;
            obj = null;
            //            return obj;
        }
    }
    public static void main(String args[]) {
        System.out.println(show());
    }
}

class RetDto {
    String name;
    int age;
    public String toString() {
        return "RetDto{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}