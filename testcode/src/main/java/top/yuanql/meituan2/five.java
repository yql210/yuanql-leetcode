package top.yuanql.meituan2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan2
 * @BelongsClassName: five
 * @Author: yuanql
 * @CreateTime: 2023-09-09  10:02
 * @Description:
 * @Version: 1.0
 */


public class five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        int k = in.nextInt();

        StringBuilder stringBuilder1 = new StringBuilder(str);
        StringBuilder stringBuilder2 = new StringBuilder();
        String[] list = new String[]{"bc", "ca", "ab"};

//        for (int i = 0; i < 3; i++) {
//            stringBuilder[i]
//        }


        for (int i = 0; i < k; i++) {
            for (int j = 0; j < stringBuilder1.length(); j++) {
                stringBuilder2.append(list[stringBuilder1.charAt(j) - 'a']);
            }
            stringBuilder1 = stringBuilder2;
            stringBuilder2 = new StringBuilder();
        }

        System.out.println(stringBuilder1.toString());
    }
}
