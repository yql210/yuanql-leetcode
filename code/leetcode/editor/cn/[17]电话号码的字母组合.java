//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2557 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        backtracking(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtracking (String digits, int start, StringBuilder path,List<String> result) {
        if (start == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (Character character : chooseLetter(digits.charAt(start))) {
            path.append(character);
            backtracking(digits, start + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private List<Character> chooseLetter(char ch) {
        List<Character> result = new ArrayList<>();
        switch (ch) {
            case '2':
                result.add('a');
                result.add('b');
                result.add('c');
                break;
            case '3':
                result.add('d');
                result.add('e');
                result.add('f');
                break;
            case '4':
                result.add('g');
                result.add('h');
                result.add('i');
                break;
            case '5':
                result.add('j');
                result.add('k');
                result.add('l');
                break;
            case '6':
                result.add('m');
                result.add('n');
                result.add('o');
                break;
            case '7':
                result.add('p');
                result.add('q');
                result.add('r');
                result.add('s');
                break;
            case '8':
                result.add('t');
                result.add('u');
                result.add('v');
                break;
            case '9':
                result.add('w');
                result.add('x');
                result.add('y');
                result.add('z');
                break;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
