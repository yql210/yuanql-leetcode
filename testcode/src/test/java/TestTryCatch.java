/**
 * @BelongsProject: leetcode
 * @BelongsPackage: PACKAGE_NAME
 * @BelongsClassName: TestTryCatch
 * @Author: yuanql
 * @CreateTime: 2023-09-28  09:56
 * @Description:
 * @Version: 1.0
 */


public class TestTryCatch {

    public static void main(String[] args) {

        System.out.println("num() = " + num());
    }

    public static int num() {
        int flag = 0;
        try {
            throw new RuntimeException();
        } catch (RuntimeException exception) {
            return flag + 111;
        } finally {
            return flag + 20;
        }
    }
}
