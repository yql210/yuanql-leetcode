package top.yuanql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: test
 * @Author: yuanql
 * @CreateTime: 2023-06-13  11:21
 * @Description: test
 * @Version: 1.0
 */


public class test {

    public static void main(String[] args) {

//        test test = new test();
//
//        String haystack = "mississippi";
//        String needle = "issip";
//        int i = test.strStr(haystack, needle);
//
//        System.out.println("i = " + i);

//        System.out.println(null == null);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("a");
        stringBuilder.append("b");
        stringBuilder.append("c");
        stringBuilder.append("d");
        stringBuilder.append("e");
        stringBuilder.append("f");
        stringBuilder.append("g");
//        stringBuilder.append("1", 0, 1);
        stringBuilder.insert(0, 1);

        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.deleteCharAt(0);
        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.deleteCharAt(0);
        System.out.println("stringBuilder = " + stringBuilder);

        System.out.println("stringBuilder.charAt(0) = " + stringBuilder.charAt(0));


    }
    public int strStr(String haystack, String needle) {
        int[] countNext = countNext(needle);
        int j = 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == (needle.length() - 1)) {
                    return i - j;
                }
                j++;
            } else {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = countNext[--j];
                }

                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
            }
        }


        return -1;
    }

    private int[] countNext(String needle) {
        int[] result = new int[needle.length()];

        int i = 1, j = 0;

        for (; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = result[--j];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                result[i] = ++j;
            }
        }

        return result;
    }


}
