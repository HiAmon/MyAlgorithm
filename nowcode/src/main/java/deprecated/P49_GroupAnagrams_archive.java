package deprecated;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 1134 👎 0

import com.google.gson.Gson;

import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class P49_GroupAnagrams_archive{
    public static void main(String[] args) {
        Solution solution = new P49_GroupAnagrams_archive().new Solution();
//        System.out.println(solution.checkAnagrams("eat", "tea"));
//        System.out.println(solution.getKey("tra"));
//        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strings = new String[]{};
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream = null;
        int read = 0;
        try {
//            fileInputStream = new FileInputStream("/Users/wohamon/IdeaProjects/MyAlgorithm/nowcode/src/main/java/topic/deprecated/input.txt");
            while (( read= fileInputStream.read()) != -1){
//                System.out.printf((char)read +"");
                stringBuffer.append((char)read);
            }
            String substring = stringBuffer.substring(0, stringBuffer.length());
            String[] strings = new Gson().fromJson(substring, String[].class);
            long before = System.currentTimeMillis();
            List<List<String>> res = solution.groupAnagrams(strings);
//        System.out.println(new Gson().toJson(res));
            System.out.println(System.currentTimeMillis()-before);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Solution solution = new Solution();
        if (null == strs || strs.length == 0){
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1){
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }

        /**
         * {
         *     "ate":["eat","tea"],
         *
         * }
         */
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        map.put(solution.getKey(strs[0]), list);
        for (int i = 1; i < strs.length; i++) {
            Iterator<String> iterator = map.keySet().iterator();
            boolean beGrouped = false;
            while (iterator.hasNext()){
                String current = iterator.next();
                if (solution.checkAnagrams(strs[i], current)){
                    map.get(current).add(strs[i]);
                    beGrouped = true;
                    break;
                }
            }
            if (!beGrouped){
                List<String> templist = new ArrayList<>();
                templist.add(strs[i]);
                map.put(getKey(strs[i]), templist);
            }
        }
        map.forEach(new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String s, List<String> strings) {
                result.add(strings);
            }
        });
        return result;
    }



    public String getKey(String source){
        char[] charArray = source.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }


    /**
     * 检查target单词和source是否是字母异位词
     */
    public boolean checkAnagrams(String source, String target){
//        char[] sourceCharArray = source.toCharArray();
//        Arrays.sort(sourceCharArray);
//        char[] targetCharArray = target.toCharArray();
//        if (targetCharArray.length != sourceCharArray.length){
//            return false;
//        }
//        Arrays.sort(targetCharArray);
//        String oSource = String.valueOf(sourceCharArray);
//        String oTarget = String.valueOf(targetCharArray);
//        getKey(source)
        return getKey(source).equals(getKey(target));
//        if (oSource.equals(oTarget)){
//            return true;
//        }
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}