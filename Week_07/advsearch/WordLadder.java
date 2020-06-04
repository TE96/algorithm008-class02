package advsearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLengthBiBfs(String beginWord, String endWord, List<String> wordList_) {
        Set<String> wordList = new HashSet<>(wordList_);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        int length = 2;
        while (!begin.isEmpty() && !end.isEmpty()) {
            // prefer the smaller queue
            if (begin.size() > end.size()) {
                Set<String> t = end;
                end = begin;
                begin = t;
            }
            wordList.removeAll(begin);
            Set<String> next = new HashSet<>();
            for (String word : begin) {
                char[] temp = word.toCharArray();
                for (int i = 0; i < temp.length; i ++) {
                    char c = temp[i];
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        if (ch == c) {
                            continue;
                        }
                        temp[i] = ch;
                        String newWord = String.valueOf(temp);
                        if (wordList.contains(newWord)) {
                            if (end.contains(newWord)) {
                                return length;
                            }
                            next.add(newWord);
                        }
                    }
                    temp[i] = c;
                }
            }
            begin = next;
            length ++;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList_) {
        Set<String> wordList = new HashSet<>(wordList_);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        return biBfs(begin, end, 2, wordList);
    }
    private int biBfs(Set<String> begin, Set<String> end, int length, Set<String> wordList) {
        // terminator
        if (begin.size() == 0) {
            return 0;
        }
        if (begin.size() > end.size()) {
            // prefer the smaller queue
            return biBfs(end, begin, length, wordList);
        }
        // current level
        // words of last level should not be in the next level
        wordList.removeAll(begin);
        Set<String> next = new HashSet<>();
        for (String word : begin) {
            char[] temp = word.toCharArray();
            for (int i = 0; i < temp.length; i ++) {
                // save the current state
                char c = temp[i];
                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    // skip duplicated letter
                    if (ch == temp[i]) {
                        continue;
                    }
                    // change one char per.
                    temp[i] = ch;
                    String newWord = String.valueOf(temp);
                    // words must be in the wordList
                    if (wordList.contains(newWord)) {
                        // if find the target
                        if (end.contains(newWord)) {
                            return length;
                        }
                        // hasn't find yet;
                        next.add(newWord);
                    }
                }
                // reverse state
                temp[i] = c;
            }
        }
        // next level search
        return biBfs(next, end, length + 1, wordList);
    }
}
