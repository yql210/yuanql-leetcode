import javax.management.relation.InvalidRelationIdException;
import javax.xml.crypto.dsig.DigestMethod;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {


        // 方案一
        // 结果：可正常运行

        // int[] result = new int[digits.length];
        // int flage = 1;

        // for (int i = digits.length -1 ; i > -1; i--) {
        //     if (flage == 1){
        //         if (digits[i] + 1 != 10) {
        //             result[i] = digits[i] + 1;
        //             flage = 0;
        //         } else {
        //             result[i] = 0;
        //             if (i == 0) {
        //                 int[] result1 = new int[digits.length + 1];
        //                 result1[0] = 1;
        //                 for (int j = 1; j < result1.length; j++) {
        //                     result1[j] = 0;
        //                 }
        //                 return result1;
        //             }
        //         }
        //     } else {
        //         result[i] = digits[i];
        //     }
        // }

        // 方案二
        // 根据题解知
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

        
    }
}
// @lc code=end

