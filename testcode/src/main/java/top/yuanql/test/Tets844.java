package top.yuanql.test;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Tets844
 * @Author: yuanql
 * @CreateTime: 2023-07-12  15:57
 * @Description: 844 比较含退格字符串
 * @Version: 1.0
 */


public class Tets844 {
    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        boolean b = backspaceCompare(s, t);
    }

    public static boolean backspaceCompare(String s, String t) {
        int s_slow = s.length() - 1, s_fast = s_slow, t_slow = t.length() - 1, t_fast = t_slow;

        while (true) {
            // 找出字符串 s 的退位之后的值
            while (!(s_slow == s_fast && s.charAt(s_slow) != '#')) {
                if (s.charAt(s_slow) == '#') {
                    s_fast = s_fast - 2;
                    if (s_fast < 0) {
                        break;
                    }
                }
                s_slow--;
            }
            // 找出字符串 t 的退位之后的值
            while (!(t_slow == t_fast && t.charAt(t_slow) != '#')) {
                if (s.charAt(t_slow) == '#') {
                    t_fast = t_fast - 2;
                    if (t_fast < 0) {
                        break;
                    }
                }
                t_slow--;
            }

            if (s_fast < 0 || t_fast < 0) {
                if (s_fast < 0 && t_fast < 0) {
                    return true;
                }
                return false;
            }

            if (s.charAt(s_fast) != t.charAt(t_fast)) {
                return false;
            }

            if (s_fast == 0 || t_fast == 0) {
                if (s_fast == 0 && t_fast == 0) {
                    return true;
                } else {
                    if (s_fast == 0) {
                        t_slow--;
                        t_fast--;
                        // 找出字符串 t 的退位之后的值
                        while (!(t_slow == t_fast && t.charAt(t_slow) != '#')) {
                            if (s.charAt(t_slow) == '#') {
                                t_fast = t_fast - 2;
                                if (t_fast < 0) {
                                    break;
                                }
                            }
                            t_slow--;
                        }
                        if (t_fast < 0) {
                            return true;
                        }
                        return false;
                    } else if (t_fast == 0) {
                        s_slow--;
                        s_fast--;
                        // 找出字符串 s 的退位之后的值
                        while (!(s_slow == s_fast && s.charAt(s_slow) != '#')) {
                            if (s.charAt(s_slow) == '#') {
                                s_fast = s_fast - 2;
                                if (s_fast < 0) {
                                    break;
                                }
                            }
                            s_slow--;
                        }
                        if (s_fast < 0) {
                            return true;
                        }
                        return false;
                    }
                }
            }

            s_slow--;
            s_fast--;
            t_slow--;
            t_fast--;
        }

    }

}


