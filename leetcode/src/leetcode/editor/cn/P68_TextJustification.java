package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 示例：
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 */
public class P68_TextJustification{
    public static void main(String[] args) {
        Solution solution = new P68_TextJustification().new Solution();
        
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            if (words.length <= 0){
                return null;
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length()>maxWidth){
                    return null;
                }
            }
            if (words.length <= 1 ){
                list.add(words[0]);
                return list;
            }
            /**
             * 思路：贪心算法，判断当前单词能否被加入当前行，不能就换下一行，先把单词都塞进行里，然后再添加空格
             */
            List<Row> rows = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                Row row = new Row();
                if (words[i].length() < maxWidth - row.length){
                    row.words.add(words[i]);
                    row.length += words[i].length();
                }

            }

            return null;
        }
    }

    class Row{
        List<String> words;//当前行包含的单词
        int length; //当前行的单词总长度（包含每个单词后面的一个空格，不包含需要后续添加的空格数）
    }

    class Car {
        Object wheels;
        Object windows;
        Object iron;
        public void drive(){
            return;
        }
    }

    class ElectricCar{
        Car car;
        Object pad;
        Object glass;
        Object elec;
    }

    ElectricCar car = new ElectricCar();
    public void test(){
        car.car.drive();
        Tesla tesla = new Tesla();
        String o = tesla.band;
        tesla.movie();
    }

    class Tesla extends ElectricCar{
        String band;
        Object AIpad;
        Object sound;
        public void movie(){
            return;
        }
    }



//leetcode submit region end(Prohibit modification and deletion)

}