package top.yuanql.yuewen;

import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yuewen
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-11-03  19:43
 * @Description:
 * @Version: 1.0
 */


public class one {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        one main = new one();
        int number = console.nextInt();
        System.out.println(main.palindromeNumber(number));
    }

    public Boolean palindromeNumber(int number) {

        //write your code here......

        String s = String.valueOf(number);


        if (s.length() != 5 || s.charAt(0) != s.charAt(4) || s.charAt(1) != s.charAt(3)) return false;

        return true;
    }
}
