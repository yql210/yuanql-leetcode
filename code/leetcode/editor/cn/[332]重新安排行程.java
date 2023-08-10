//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 815 👎 0


import javax.swing.text.Style;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> temp = new ArrayList<>();

    private List<List<String>> resultTemp = new ArrayList<>();

    private int[] used;

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new int[tickets.size()];
        temp.add("JFK");

        HashMap<String, PriorityQueue<String>> ticketsMap = new HashMap<>(); // 将原始的列表数据转换为HashMap数据，方便进行遍历和查找

        PriorityQueue<String> queue;
        for (List<String> ticket : tickets) {
            if (ticketsMap.containsKey(ticket.get(0))) {
                queue = ticketsMap.get(ticket.get(0));
            } else {
                queue = new PriorityQueue<String>((o1, o2) -> o1.compareTo(o2)); // 使用优先队列，将数据按照字典表从小到大进行排列
            }
            queue.add(ticket.get(1));
            ticketsMap.put(ticket.get(0), queue);
        }

        backtracking(ticketsMap, 0, tickets.size()); // 回溯函数

        return resultTemp.get(0);
    }

    /**
     * 回溯函数
     * @param ticketsMap 输入的数据
     * @param size 已经遍历过的数据长度
     * @param length tickets的长度，此处主要用于判断终止条件
     */
    private void backtracking(HashMap<String, PriorityQueue<String>> ticketsMap, int size, int length) {
        if (length == size) { // 此时找到了最优的解
            resultTemp.add(new ArrayList<>(temp));
            return;
        }

        // 获取所有可能的下一站，其是按照优先队列进行排列的
        PriorityQueue<String> queue = ticketsMap.get(temp.get(temp.size() - 1));

        int index = 0; // 取优先队列中的第几个数据

        // 此处循环判断条件较多，一项一项进行分析：
        // queue != null ： 当前所在的站点可能没有下一个站点去走，所以返回的优先队列可能是null，需要排除到此情况
        // !queue.isEmpty() ： 此站点可能有下一个站点，但是此站点可能走过了，所以此路不通，另寻他路
        // resultTemp.isEmpty() ： 结果数据当前没有数据，意味着此时还没有找到最优解，如果找到了，直接结束，返回数据就可
        // index < queue.size() ： 防止我们需要进行遍历的数据超出优先队列的范围，如果到达这一步，意味着我们现在站的这一个站点没有最优解，请返回，重新查找
        while (queue != null && !queue.isEmpty() && resultTemp.isEmpty() && index < queue.size()) {

            String poll = findIndexOfQueue(queue, index); // 获取优先队列重点 数据

            temp.add(poll); // 将数据加入到路径中
            backtracking(ticketsMap, size + 1, length);
            temp.remove(temp.size() - 1); // 回溯：将此数据弹出
            queue.add(poll); // 回溯： 需要将弹出来的再重新加载回去

            index++;
        }
    }

    /**
     * 获取优先队列中的第 index 位的数据
     * @param queue 输入的优先队列
     * @param index 想查出第几位的数据
     * @return 最终的返回值
     */
    private String findIndexOfQueue(PriorityQueue<String> queue, int index) {

        String[] list = new String[index + 1];
        for (int i = 0; i <= index; i++) {
            list[i] = queue.poll();
        }
        for (int i = 0; i < index; i++) {
            queue.add(list[i]);
        }
        return list[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
