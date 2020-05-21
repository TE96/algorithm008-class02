package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    /**
     * 简化了key的计算, 只需要对单词排序即可
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 计算key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 为每个单词计算key, 将具有相同key的单词放在value中
     */
    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = key(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                map.put(key, newGroup);
            }
        }
        return new ArrayList<>(map.values());
    }
    private String key(String s) {
        StringBuilder sb = new StringBuilder("");
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char c: s.toCharArray()) {
            count[c - 'a'] ++;
        }
        for (int value : count) {
            sb.append(value);
        }
        return sb.toString();
    }
}
