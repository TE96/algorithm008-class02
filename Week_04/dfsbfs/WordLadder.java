package dfsbfs;

import java.util.*;

public class WordLadder {

    public int ladderLengthBiBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        if (!wordDict.contains(endWord)) { return 0; }
        return bfs(start, end, wordDict, 2);
    }
    private int bfs(Set<String> start, Set<String> end, Set<String> wordDict, int length) {
        if (start.isEmpty()) {
            return 0;
        }
        if (start.size() > end.size()) {
            return bfs(end, start, wordDict, length);
        }
        wordDict.removeAll(start);
        Set<String> next = new HashSet<>();
        for (String word : start) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i ++) {
                char temp = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    if (temp == ch) { continue; }
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (wordDict.contains(newWord)) {
                        if (end.contains(newWord)) { return length; }
                        else { next.add(newWord); }
                    }
                }
                chars[i] = temp;
            }
        }
        return bfs(next, end, wordDict, length + 1);
    }

    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                for (String neighbour : neighbours(word, wordDict)) {
                    queue.offer(neighbour);
                }
            }
            level ++;
        }
        return 0;
    }
    private List<String> neighbours(String beginWord, Set<String> wordDict) {
        List<String> neighbours = new LinkedList<>();
        for (int i = 0; i < beginWord.length(); i ++) {
            char[] word = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c ++) {
                word[i] = c;
                String newWord = String.valueOf(word);
                if (wordDict.remove(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
}
