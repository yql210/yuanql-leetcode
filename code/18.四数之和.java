import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int right,left;
        
        // 方案一
        // 注意点： 1、数值超出Int的最大值
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                
                left = j + 1;
                right =  nums.length - 1;

                while (left < right) {

                    // 溢出判断，此处有待于更进一步的优化
                    if (nums[i] + nums[j] + nums[left] + nums[right] < 0 && nums[i] > 0) {
                        break;
                    }

                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> tem =  new ArrayList<Integer>();
                        tem.add(nums[i]);
                        tem.add(nums[j]);
                        tem.add(nums[left]);
                        tem.add(nums[right]);
                        result.add(tem);
                        while (nums[right] == nums[--right]) {
                            if (right < left + 2)
                                break;
                        }
                        while (nums[left] == nums[++left]) {
                            if (left > right - 2)
                                break;
                        }
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end

