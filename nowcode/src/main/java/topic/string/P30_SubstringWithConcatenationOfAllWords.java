package topic.string;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 657 👎 0

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P30_SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new P30_SubstringWithConcatenationOfAllWords().new Solution();
//        String[] strings = new String[]{"word","good","best","word"};
        String[] words = new String[]{"a","a"};
//        List<Integer> list = solution.findSubstring("wordgoodgoodgoodbestword", strings);
        List<Integer> list = solution.findSubstring("a", words);
        System.out.println(new Gson().toJson(list));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //录入词汇表，数量为1
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (null == map.get(word)){
                map.put(word, 1);
            }else {
                map.put(word, map.get(word) + 1);
            }
        }
        HashMap defaultMap = (HashMap) map.clone();
        List<Integer> result = new ArrayList<>();

        //拿到词汇长度
        int len = words[0].length();

        char[] chars = s.toCharArray();
        String substring;
        int i = 0;
        while (i < chars.length-len && (s.length()-i < len*words.length)){ //
            substring = new String(chars, i, len);//0,1,2
            if (map.containsKey(substring)){
                //如果map中匹配上，那就往后匹配
                map.put(substring, map.get(substring)-1);//
                //第二个单词[i+len*1,+3
                int loopNum = 1;
//                while (i+len*(loopNum+1) < s.length()){     //这里
                while (loopNum < words.length && (i+len*(loopNum+1) <= s.length())){
//                    int rightOffset = i+len*(loopNum+1);
                    String curSubString = new String(chars,i+len*loopNum,len);//3,4,5

                    if (map.containsKey(curSubString) && map.get(curSubString) > 0){
                        map.put(curSubString,map.get(curSubString)-1);
                        loopNum++;
                    }else {
                        //如果不存在，那么这次匹配失败，从下一个s的起始点开始
                        map = (HashMap<String, Integer>) defaultMap.clone();
                        break;
                    }

                }
                boolean zeroFlag = true;
                for (Integer value : map.values()) {
                    if (value != 0){
                        zeroFlag = false;
                        break;
                    }
                }
                if (zeroFlag){
                    result.add(i);
//                    i += len * words.length;//barfoofoobarthefoobarman <-> "bar","foo","the" 这样的特殊情况，一次只能跳一个单词
                    map = (HashMap<String, Integer>) defaultMap.clone();
                    i += len;
                    continue;
                }
            }
            i++;
        }
        /**
         * 如果s中的单词数量和words的单词数量一样长，那就直接比较吧
         * s:a
         * words:a,a
         * []
         * ---
         * s:a
         * words:a
         * [0]
         */
        if (s.equals(words[0]) && words.length*words[0].length() <= s.length()){
            result.add(0);
            return result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}