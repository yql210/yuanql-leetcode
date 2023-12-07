/**
 * @BelongsProject: leetcode
 * @BelongsPackage: PACKAGE_NAME
 * @BelongsClassName: TestString
 * @Author: yuanql
 * @CreateTime: 2023-10-20  22:50
 * @Description:
 * @Version: 1.0
 */


public class TestString {
    public static void main(String[] args) {


        String s1 = new String("Hy") + new String("dra");

//        s1.intern();

        String s2 = "Hydra";

        System.out.println(s1 == s2);
    }
}
