//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 738 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {

        StringBuilder stringBuilder = new StringBuilder();
        int flage = 0, // 进位的标志
            num1Length = num1.length(),
            num2Length = num2.length(),
            maxLength = num1Length > num2Length ? num1Length : num2Length,
            minLength = num1Length < num2Length ? num1Length : num2Length,
            temp = 0;

        for (int i = 0; i < minLength; i++) {
            temp = num1.charAt(num1Length - i - 1) - '0' + num2.charAt(num2Length - i - 1) - '0' + flage;
//            stringBuilder.insert(0, temp % 10);
            stringBuilder.append(temp % 10);
            flage = temp / 10;
        }

        if (num1.length() > num2.length()) {
            for (int i = minLength; i < maxLength; i++) {
                temp = num1.charAt(num1Length - i - 1) - '0' + flage;
//                stringBuilder.insert(0, temp % 10);
                stringBuilder.append(temp % 10);
                flage = temp / 10;
            }
        } else {
            for (int i = minLength; i < maxLength; i++) {
                temp = num2.charAt(num2Length - i - 1) - '0' + flage;
//                stringBuilder.insert(0, temp % 10);
                stringBuilder.append(temp % 10);
                flage = temp / 10;
            }
        }
        if (flage == 1) {
//            stringBuilder.insert(0, flage);
            stringBuilder.append(flage);
        }

        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
