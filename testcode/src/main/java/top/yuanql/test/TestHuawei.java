package top.yuanql.test;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.test
 * @BelongsClassName: TestHuawei
 * @Author: yuanql
 * @CreateTime: 2023-09-19  19:52
 * @Description:
 * @Version: 1.0
 */


public class TestHuawei {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner s = new Scanner(System.in);
//        String input= s.nextLine();
//        String[] inputs = input.split(" ");
//        long sum = 0;
//        for (int i = 0; i < inputs.length; i++) {
//            sum += inputs[i].length();
//        }
//
//        System.out.printf("%.2f", 1.0 * sum / inputs.length);

        Scanner s = new Scanner(System.in);
        String input;
        long sum = 0;
        while (s.hasNext()) {
            input = s.next();
            sum += input.length();
        }
    }
}
