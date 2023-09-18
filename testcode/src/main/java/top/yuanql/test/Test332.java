package top.yuanql.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test332
 * @Author: yuanql
 * @CreateTime: 2023-08-10  08:59
 * @Description:
 * @Version: 1.0
 */


public class Test332 {

    private List<String> temp = new ArrayList<>();

    private List<List<String>> resultTemp = new ArrayList<>();

    private int[] used;

    public static void main(String[] args) {

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new int[tickets.size()];
        temp.add("JFK");
        backtracking(tickets, 0);

//        List<String> result = resultTemp.get(0);
//
//        for (int i = 1; i < resultTemp.size(); i++) {
//            for (int j = 1; j < result.size(); j++) {
//                if (result.get(j).compareTo(resultTemp.get(i).get(j)) > 0) {
//                    result = resultTemp.get(i);
//                    break;
//                } else if (result.get(j).compareTo(resultTemp.get(i).get(j)) < 0) {
//                    break;
//                }
//            }
//        }

//        for (List<String> strList :
//                resultTemp) {
//            System.out.println(strList);
//        }


        return resultTemp.get(0);
    }

    private void backtracking(List<List<String>> tickets, int size) {
        if (tickets.size() == size) {
            resultTemp.add(new ArrayList<>(temp));
            return;
        }

        HashSet<String> leaveUsed = new HashSet<>();
        int index = -1;
        String str = "";

        while (resultTemp.size() == 0) {
            for (int i = 0; i < tickets.size(); i++) { // 此循环用于找到相对较小的那个字符串
                if (used[i] == 1) continue;

                if (tickets.get(i).get(0).equals(temp.get(temp.size() - 1)) && !leaveUsed.contains(tickets.get(i).get(1))) {

                    if ("".equals(str)) {
                        index = i;
                        str = tickets.get(i).get(1);
                    } else {
                        if (tickets.get(i).get(1).compareTo(str) < 0) {
                            index = i;
                            str = tickets.get(i).get(1);
                        }
                    }
                }
            }

            if (index != -1) {

                used[index] = 1;
                temp.add(tickets.get(index).get(1));

//                System.out.println(tickets.get(index).get(1));
//                System.out.println(index);

                leaveUsed.add(tickets.get(index).get(1));
                backtracking(tickets, size + 1);

                used[index] = 0;
                temp.remove(temp.size() - 1);
                str = "";
            } else {
                break;
            }
        }
    }
}
