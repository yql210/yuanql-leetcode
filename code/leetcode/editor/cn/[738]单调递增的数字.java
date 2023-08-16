//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 402 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
        int index = 0; // 记录当前在数字的哪一位，从0开始计数
        int result = n % 10; // 保存结果
        int up = n % 10; // 记录上一次的数值大小
        boolean flag = false; // 需要特殊判断的是 3332  其结果为 2999；为了判断其相等的时候，添加的一个标志位
        n = n / 10;

        while (n > 0) {
            int i = n % 10;
            index++;

            if (i < up) {
                result += i * Math.pow(10, index);
                flag = false;
            } else if (i == up) { // 相等的时候进行一下特殊的判断
                if (flag) {
                    result = i * (int) Math.pow(10, index) - 1;
                }else {
                    result += i * Math.pow(10, index);
                }
            }else  {
                result = i * (int) Math.pow(10, index) - 1;
                flag = true;
            }
            up = i;
            n = n / 10;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
