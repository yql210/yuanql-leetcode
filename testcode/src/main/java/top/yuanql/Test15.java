package top.yuanql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test15
 * @Author: yuanql
 * @CreateTime: 2023-07-18  14:43
 * @Description: 三数之和
 * @Version: 1.0
 */


public class Test15 {

    public static void main(String[] args) {
        int[] tem = new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(tem);

        System.out.println("lists = " + lists);


    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int left, right;
        for (int i = 0; nums[i] < 1 && i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (left < nums.length - 1 && nums[left] == nums[++left]) {

                    }
                    while (right > 0 && nums[right] == nums[--right]) {

                    }
                }
            }
        }

        return result;
    }
}
