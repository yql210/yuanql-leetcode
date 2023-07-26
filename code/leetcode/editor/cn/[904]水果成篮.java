//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 519 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0,   // 滑动窗口的左测
                right = 1,  // 滑动窗口的右侧
                temp = left, // 下一次左侧窗口的落脚点
                flag = -1, // 判断当前滑动窗口中除了左侧，水果的种类 --> -1：代表当前只有一种水果，水果的种类是 left 所在的种类， 其他数值代表着其他的水果种类
                result = 1; // 滑动窗口的最大数值，也就是收集水果的 最大 数目。
                            // 为什么写1呐： 当数组的长度为1的时候，其无法正常进入到下述循环中，所以默认数值设置为1用于解决数组长度为1的情况

        for (; right < fruits.length; right++) {
            // 此时 右侧的水果种类不等于左侧的水果种类
            if (fruits[right] != fruits[left]) {
                // 此时滑动窗口内只有一种水果
                if (flag == -1) {
                    flag = fruits[right]; // 直接将水果放入，进行下一轮循环
                    temp = right;
                } else { // 此时滑动窗口已经有两种水果了
                    if (fruits[right] == flag) { // 此时新加的水果种类依然属于其中的一种
                        if (fruits[right] != fruits[temp]) { // 此处用于判断temp的情况 001101  ，此时temp为0但是走到了1 这一步，就需要将temp更新为1
                            temp = right;
                        }
                    } else { // 此时有新的品种加入到了窗口中，需要收缩窗口，      并计算相关的数值
                        left = temp;
                        flag = fruits[right]; // 直接将水果放入，进行下一轮循环
                        temp = right;
                    }
                }
            } else { // 此处用于判断temp的情况 00110  ，此时temp为1但是走到了0 这一步，就需要将temp更新为0
                if (fruits[right] != fruits[temp]) {
                    temp = right;
                }
            }
            // 每次计算一轮，求解一次最大值
            if (result < (right - left + 1)) {
                result = right - left + 1;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
