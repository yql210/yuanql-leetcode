//给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第 i 行源码。 这表示每行源码由 '
//' 分隔。 
//
// 在 C++ 中有两种注释风格，行内注释和块注释。 
//
// 
// 字符串// 表示行注释，表示//和其右侧的其余字符应该被忽略。 
// 字符串/* 表示一个块注释，它表示直到下一个（非重叠）出现的*/之间的所有字符都应该被忽略。（阅读顺序为从左到右）非重叠是指，字符串/*/并没有结束块注释
//，因为注释的结尾与开头相重叠。 
// 
//
// 第一个有效注释优先于其他注释。 
//
// 
// 如果字符串//出现在块注释中会被忽略。 
// 同样，如果字符串/*出现在行或块注释中也会被忽略。 
// 
//
// 如果一行在删除注释之后变为空字符串，那么不要输出该行。即，答案列表中的每个字符串都是非空的。 
//
// 样例中没有控制字符，单引号或双引号字符。 
//
// 
// 比如，source = "string s = "/* Not a comment. */";" 不会出现在测试样例里。 
// 
//
// 此外，没有其他内容（如定义或宏）会干扰注释。 
//
// 我们保证每一个块注释最终都会被闭合， 所以在行或块注释之外的/*总是开始新的注释。 
//
// 最后，隐式换行符可以通过块注释删除。 有关详细信息，请参阅下面的示例。 
//
// 从源代码中删除注释后，需要以相同的格式返回源代码。 
//
// 
//
// 示例 1: 
//
// 
//输入: source = ["/*Test program */", "int main()", "{ ", "  // variable 
//declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ",
// "   testing */", "a = b + c;", "}"]
//输出: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
//解释: 示例代码可以编排成这样:
///*Test program */
//int main()
//{ 
//  // variable declaration 
//int a, b, c;
///* This is a test
//   multiline  
//   comment for 
//   testing */
//a = b + c;
//}
//第 1 行和第 6-9 行的字符串 /* 表示块注释。第 4 行的字符串 // 表示行注释。
//编排后: 
//int main()
//{ 
//  
//int a, b, c;
//a = b + c;
//} 
//
// 示例 2: 
//
// 
//输入: source = ["a/*comment", "line", "more_comment*/b"]
//输出: ["ab"]
//解释: 原始的 source 字符串是 "a/*comment
//line
//more_comment*/b", 其中我们用粗体显示了换行符。删除注释后，隐含的换行符被删除，留下字符串 "ab" 用换行符分隔成数组时就是 ["ab"]
//.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= source.length <= 100 
// 0 <= source[i].length <= 80 
// source[i] 由可打印的 ASCII 字符组成。 
// 每个块注释都会被闭合。 
// 给定的源码中不会有单引号、双引号或其他控制字符。 
// 
// 
//
// Related Topics 数组 字符串 👍 95 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeComments(String[] source) {
//        List<String> result = new ArrayList<>();
//
//        boolean flag = true;
//        StringBuilder strFlag = new StringBuilder();
//        for (String str : source) {
//            if (flag && str.contains("//")) {
//                String[] split = str.split("//");
//                if (split[0].length() > 0) {
//                    result.add(split[0]);
//                }
//            } else if (flag && str.contains("/*")) {
//                String[] split = str.split("/\\*");
//                strFlag.append(split[0]);
//                flag = false;
//                if (split[split.length - 1].contains("*/")) {
//                    flag = true;
//                    String[] split1 = split[split.length - 1].split("\\*/");
//                    if (split1.length > 1) {
//                        strFlag.append(split1[split1.length - 1]);
//                    }
//                    if (strFlag.length() > 0) {
//                        result.add(strFlag.toString());
//                        strFlag = new StringBuilder();
//                    }
//                }
//            } else if (!flag && str.contains("*/")) {
//                flag = true;
//                String[] split = str.split("\\*/");
//                if (split.length > 1) {
//                    strFlag.append(split[split.length - 1]);
//                }
//                if (strFlag.length() > 0) {
//                    result.add(strFlag.toString());
//                }
//            } else if (flag){
//                result.add(str);
//            }
//        }
//
//        return result;



        List<String> result = new ArrayList<>();

        boolean flag = true;
        StringBuilder strFlag = new StringBuilder();
        for (String str : source) {
            for (int i = 0; i < str.length(); i++) {
                if (flag) {
                    if (i + 1 < str.length() && str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                        break;
                    } else if (i + 1 < str.length() && str.charAt(i) == '/' && str.charAt(i + 1) == '*') {
                        flag = false;
                        i++;
                    } else {
                        strFlag.append(str.charAt(i));
                    }
                } else {
                    if (i + 1 < str.length() && str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
                        flag = true;
                        i++;
                    }
                }
            }

            if (flag && strFlag.length() > 0) {
                result.add(strFlag.toString());
                strFlag = new StringBuilder();
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
