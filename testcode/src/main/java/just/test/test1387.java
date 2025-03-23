package just.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: just.test
 * @BelongsClassName: test1387
 * @Author: yuanql
 * @CreateTime: 2024-12-22  23:20
 * @Description:
 * @Version: 1.0
 */


public class test1387 {

    private static  int[] result;

    public static void main(String[] args) {
        int i = 11;

        Integer max = (i % 2 == 0 ? i -1 : i) * 3 + 1;
        result = new int[max + 1];
        result[0] = 1;
        result[1] = 1;
        for (Integer j = 1; Math.pow(2, j) <= max; j++) {
            result[(int) Math.pow(2, j)] = j + 1;
        }

        for (int j = 2; j < 6; j++) {
            run(j);
        }




        for (int i1 = 0; i1 < result.length; i1++) {
            System.out.println(result[i1]);
        }
    }


    public static int run(int i) {
        if (result[i] != 0) {
            return result[i];
        }

        if (i % 2 == 0) {
            result[i] = run(i / 2) + 1;
        } else {
            result[i] = run(i * 3 + 1) + 1;
        }
        return result[i];
    }
}
