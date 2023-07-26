import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    /**
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // int left = 0,
        //     right = arr.length - 1,
        //     mid = 0,
        //     flag = 0,
        //     flag_1 = 0,
        //     arr_size = arr.length - 1;
        // List<Integer> result = new ArrayList<>();
        
        // while (left <= right) {
        //     mid = left + (right - left) / 2;
        //     if (arr[mid] > x) {
        //         right =  mid - 1;
        //     } else if (arr[mid] == x) {
        //         break;
        //     } else {
        //         left =  mid + 1;
        //     }
        // }


        // right = mid - k / 2;
        // if (right < 0) {
        //     flag = 1;
        //     right = 0;
        // }
        // if ((right + k) > arr_size) {
        //     flag = 1;
        //     right = arr_size - k + 1;
        //     if (Math.abs(arr[right] - x) <= Math.abs(arr[right + k -1] - x)) {
        //         right--;
        //     }

        // }


        // while (flag == 0) {
        //     if (right < 0 || (right + k) > arr_size || flag_1 > 1 || Math.abs(arr[right] - x) == Math.abs(arr[right + k -1] - x)) {
        //         break;
        //     }
        //     flag_1 = 0;
        //     if (Math.abs(arr[right] - x) > Math.abs(arr[right + k -1] - x)) {
        //         flag_1++;
        //         right++;
        //     }
        //     if (Math.abs(arr[right] - x) < Math.abs(arr[right + k -1] - x)) {
        //         flag_1++;
        //         right--;
        //     }
        // }

        // while (true) {
        //     if (right <= 0) {
        //         break;
        //     }
        //     if (arr[right] != arr[--right]) {
        //         right++;
        //         break;
        //     }
        // }

        // if (right < 0)
        //     right = 0;

        // for (int i = 0; i < k; i++) {
        //     result.add(arr[right + i]);
        // }

        // return result;



        int left = 0,
            right = arr.length - 1,
            mid = 0;
        List<Integer> result = new ArrayList<>();
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right =  mid;
            } else {
                left =  mid + 1;
            }
        }

        left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;


    }
}
// @lc code=end

