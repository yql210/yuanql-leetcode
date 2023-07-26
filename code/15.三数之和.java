import java.lang.reflect.Array;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result1 = new ArrayList<>();

        // 思路一：暴力求解
        // 结果：有重复解
        // for (int i = 0; i < nums.length - 2; i++) {
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         for (int j2 = j + 1; j2 < nums.length; j2++) {
        //             if (nums[i] + nums[j] + nums[j2] == 0) {
        //                 List<Integer> le = new ArrayList<>();
        //                 le.add(nums[i]);
        //                 le.add(nums[j]);
        //                 le.add(nums[j2]);
        //                 result1.add(le);
        //             }
        //         }
        //     }
        // }

        //思路二：先进行排序，再判断
        //结果：超时

        // Arrays.sort(nums);


        // for (int i = 0; (nums[i] < 1 && i < nums.length - 2); i++) {

        //     // 第二轮循环
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         if (i!=0 && nums[i] == nums[i -1]) 
        //             break;

        //         // 第三轮循环
        //         for (int j2 = j + 1; j2 < nums.length; j2++) {

        //             if (j!=i + 1 && (nums[j] == nums[j -1])) 
        //                 break;

        //             if (nums[i] + nums[j] + nums[j2] == 0) {

        //                 if (j2!=j + 1 && nums[j2] == nums[j2 -1]) 
        //                     break;
                        
                        
        //                 // 添加正确答案
        //                 List<Integer> le = new ArrayList<>();
        //                 le.add(nums[i]);
        //                 le.add(nums[j]);
        //                 le.add(nums[j2]);
        //                 result1.add(le);

        //             }
        //         }
        //     }
        // }

        //根据题解得：先进行排序，再使用指针

        Arrays.sort(nums);
        
        int letf,right;
        for (int i = 0; (nums[i] < 1 && i < nums.length - 2); i++) {
            if (i!=0 && nums[i] == nums[i -1]) 
                continue;
            letf = i + 1;
            right = nums.length - 1;
            while (letf < right) {
                if (nums[right] + nums[letf] > -nums[i]){
                    right--;
                } else if (nums[right] + nums[letf] == -nums[i]) {
                        // 添加正确答案
                        List<Integer> le = new ArrayList<>();
                        le.add(nums[i]);
                        le.add(nums[letf]);
                        le.add(nums[right]);
                        result1.add(le);
                        while(nums[right] == nums[--right]) 
                            if (right == 0) break;

                        while(nums[letf] == nums[++letf]) 
                            if (letf == nums.length - 1) break;

                } else {
                    letf ++;
                }
            }
        }
        






        

        return result1;

    }

    // public static void main(String[] args) {
    //     int[] a = new int[]{-2,0,1,1,2};

    //     System.out.println(new Solution().threeSum(a).toString());
    // }
}
// @lc code=end


