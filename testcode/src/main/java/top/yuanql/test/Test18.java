package top.yuanql.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test18
 * @Author: yuanql
 * @CreateTime: 2023-07-18  16:19
 * @Description: 四数之和
 * @Version: 1.0
 */


public class Test18 {
    public static void main(String[] args) {
//        int[] tem = new int[]{1,0,-1,0,-2,2}; // 	期望结果:[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//        int[] tem = new int[]{0,0,0,0}; // 	期望结果:[[0,0,0,0]]
        int[] tem = new int[]{1,-2,-5,-4,-3,3,3,5}; // 	期望结果:[[-5,-4,-3,1]]
        List<List<Integer>> lists = fourSum(tem, -11);
        System.out.println("lists = " + lists);

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int left, right;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        while (left < right && nums[left] == nums[++left]) {

                        }
                        while (left < right && nums[right] == nums[--right]) {

                        }
                    }
                }
            }
        }

        return result;
    }

}
