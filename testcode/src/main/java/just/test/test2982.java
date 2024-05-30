package just.test;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: just.test
 * @BelongsClassName: test2982
 * @Author: yuanql
 * @CreateTime: 2024-05-30  09:29
 * @Description:
 * @Version: 1.0
 */


public class test2982 {
    public static int maximumLength(String s) {
        int ans = -1;
        int[][][] ch_list = new int['z' - 'a' + 1][3][2];
//        List<Integer>[] ch_list = new ArrayList['z' - 'a'+ 1];
        Character ch = s.charAt(0);
        int ch_num = 1;
        ch_list[ch - 'a'][0][0] = 1;
        ch_list[ch - 'a'][0][1]++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                ch_num++;
                for (int j = 0; j < 3; j++) {
                    if (ch_list[ch - 'a'][j][0] == 0) {
                        ch_list[ch - 'a'][j][0] = ch_num;
                        ch_list[ch - 'a'][j][1]++;
                        break;
                    }
                    if (ch_list[ch - 'a'][j][0] <= ch_num) {
                        ch_list[ch - 'a'][j][1]++;
                        if (ch_list[ch - 'a'][j][1] >= 3) {
                            ans = Math.max(ans, ch_list[ch - 'a'][j][0]);
                        }
                    }
                }
                if (ch_list[ch - 'a'][2][0] != 0 && ch_list[ch - 'a'][2][0] < ch_num) {
                    ch_list[ch - 'a'][0][0] = ch_list[ch - 'a'][1][0];
                    ch_list[ch - 'a'][0][1] = ch_list[ch - 'a'][1][1];
                    ch_list[ch - 'a'][1][0] = ch_list[ch - 'a'][2][0];
                    ch_list[ch - 'a'][1][1] = ch_list[ch - 'a'][2][1];
                    ch_list[ch - 'a'][2][0] = ch_num;
                    ch_list[ch - 'a'][2][1] = 1;
                }
            } else {
                ch = s.charAt(i);
                ch_num = 1;
                if (ch_list[ch - 'a'][0][0] == 1) {
                    ch_list[ch - 'a'][0][1]++;
                    if (ch_list[ch - 'a'][0][1] >= 3) {
                        ans = Math.max(ans, 1);
                    }
                } else {
                    ch_list[ch - 'a'][0][0] = 1;
                    ch_list[ch - 'a'][0][1]++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        int i = maximumLength(s);
        System.out.println("i = " + i);
    }
}
