package top.yuanql.qiaanxin;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.qiaanxin
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-10-07  18:31
 * @Description:
 * @Version: 1.0
 */


public class two {

    public static void main(String[] args) {

        ArrayList<Point> products =  new ArrayList<>();
        products.add(new Point(2, 602));
        products.add(new Point(4, 1275));

        Solution solution = new Solution();
        ArrayList<Point> points = solution.maxIncomeProducts(products, 7);
    }


     public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
          this.x = x;
          this.y = y;
        }
      }


    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 获取最大收益理财产品组合
         *
         * @param products Point类ArrayList 理财产品数据列表
         * @param months   int整型 总投入月份
         * @return Point类ArrayList
         */
        public ArrayList<Point> maxIncomeProducts(ArrayList<Point> products, int months) {
            // write code here

            // dp数组

            int[] dp = new int[months + 1];
            ArrayList<Point>[] dpPoint = new ArrayList[months + 1];
            dpPoint[0] =  new ArrayList<>();

            for (int i = 1; i <= months; i++) {
                dp[i] = dp[i - 1];
                dpPoint[i] = new ArrayList<>(dpPoint[i - 1]);
                for (int j = 0; j < products.size(); j++) {
                    if (i - products.get(j).x >= 0) {
                        if (dp[i] < products.get(j).y + dp[i - products.get(j).x]) {
                            dp[i] = products.get(j).y + dp[i - products.get(j).x];

//                            dpPoint[products.get(j).x - i].add(products.get(j));
                            ArrayList<Point> points = new ArrayList<>(dpPoint[i - products.get(j).x]);
                            points.add(products.get(j));

                            dpPoint[i] = points;
                        }
                    }
                }
            }

            Collections.sort(dpPoint[months], (o1, o2) -> o1.x - o2.x);


            return dpPoint[months];

        }
    }
}
