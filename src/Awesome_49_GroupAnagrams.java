import java.util.*;

public class Awesome_49_GroupAnagrams {
    /*
    2020.04.06

    30 days challenge

    day 6

    思路:
    HashMap
    想办法弄一个东西把每一个string给排序了放到dic里比较

    考察怎么快速给string的字母按字母表排序，当时研究这个看了半天
    对那些工具不熟悉

    另外，在提交的时候发现了数据结构效率不同的情况
    见下面的注释

     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // HashMap<String, List<String>> map = new HashMap<>();
        // 效率会低很多
        // ArrayList vs. List
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            char[] sorted_char = current.toCharArray();
            Arrays.sort(sorted_char);
            String process_key = new String(sorted_char);

            if (map.containsKey(process_key)) {
                ArrayList<String> value = map.get(process_key);
                value.add(current);
                map.remove(process_key);
                map.put(process_key, value);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(current);
                map.put(process_key, value);
            }
        }

        List<List<String>> result = new LinkedList<>();
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }
}
