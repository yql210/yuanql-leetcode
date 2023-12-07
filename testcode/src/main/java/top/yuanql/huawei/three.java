package top.yuanql.huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.huawei
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-20  19:02
 * @Description:
 * @Version: 1.0
 */


public class three {

    private static HashMap<String, Long> num = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {
            StringBuilder input = new StringBuilder(in.nextLine());

            if (input.substring(0, 3).equals("let")) {
                int i = input.lastIndexOf("=");
                String name = input.substring(3, i).trim();
                if (isLaw(name)) {
                    String value = input.substring(i + 1, input.length()).trim();

                    Long l = sumValue(value);

                    if (l != null) {
                        num.put(name, l);
                    }

                } else {
                    System.out.println("<syntax-error>");
                }

            } else {
                String value = input.substring(4, input.length() - 1).trim();
                Long l = sumValue(value);

                if (l != null) {
                    if (l > Integer.MAX_VALUE) System.out.println("<overflow>");
                    else if (l < Integer.MIN_VALUE) System.out.println("<underflow>");
                    else System.out.println(l);

                } else {
                    System.out.println("<undefined>");
                }
            }


        }
    }

    private static Long sumValue(String string) {
        long result = 0;
        long temp = 0;

        String[] s = string.split(" ");

        for (int i = 0; i < s.length; i++) {
            int kinds = findKinds(s[i]);
            if (kinds == 0) {
                result = Long.valueOf(s[i]);


            } else if (kinds == 1) {
                i++;
                int kinds1 = findKinds(s[i]);
                if (kinds1 == 0) {
                    temp = Long.valueOf(s[i]);
                } else if (kinds1 == 2) {
                    if (num.containsKey(s[i])) {
                        temp = num.get(s[i]);
                    } else {
                        return null;
                    }
                }

                if (s[i - 1].equals("+")) {
                    result += temp;
                } else if (s[i - 1].equals("-")) {
                    result -= temp;
                } else if (s[i - 1].equals("*")) {
                    result *= temp;
                } else if (s[i - 1].equals("/")) {
                    result /= temp;
                }


            } else if (kinds == 2) {
                if (num.containsKey(s[i])) {
                    result = num.get(s[i]);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }


        if (result > Integer.MAX_VALUE) return Long.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Long.MIN_VALUE;

        return result;

    }


    private static int findKinds(String string) {
        if (string.charAt(0) >= '1' && string.charAt(0) <= '9' || (string.charAt(0) == '-' && string.length() > 1)) {
            return 0;
        } else if (string.length() == 1 && (string.charAt(0) == '+' || string.charAt(0) == '-'
                || string.charAt(0) == '*' || string.charAt(0) == '/')) {
            return 1;
        } else if (isFirstUsed(string.charAt(0))) {
            return 2;
        }
        return -1;
    }

    private static boolean isLaw(String string) {

        if (string.length() == 0) return false;

        if (isFirstUsed(string.charAt(0))) {
            for (int i = 1; i < string.length(); i++) {
                if (!isUsed(string.charAt(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    private static boolean isFirstUsed(char ch) {
        if (ch == '_' || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }


    private static boolean isUsed(char ch) {
        if (ch == '_' || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
}


/**




let var1 = 1
let var2 = 3
let var3 = var1 + var2
out(var3)
out(var2)
out(var)
let var4 = -2147483649
let var5 = 2147483648
out(var4)
out(var5)
let x.y = 1

 */