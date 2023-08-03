package top.yuanql;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: StringTest
 * @Author: yuanql
 * @CreateTime: 2023-08-03  14:55
 * @Description:
 * @Version: 1.0
 */


public class StringTest {

    public static void main(String[] args) {
        boolean flag = true;
        StringBuilder strFlag = new StringBuilder();
        String str = "    /*/ declare members;/**/";
        if (str.contains("//")) {
            System.out.println("11111111");
        }


        if (str.contains("/*")) {
            String[] split = str.split("/\\*");
            strFlag.append(split[0]);
            flag = false;
            if (split[1].contains("*/")) {
                flag = true;
                String[] split1 = split[1].split("\\*/");
                if (split1.length > 1) {
                    strFlag.append(split1[1]);
                }
                if (strFlag.length() > 0) {
                    System.out.println(strFlag);
                    strFlag = new StringBuilder();
                }
            }
        }
    }
}
