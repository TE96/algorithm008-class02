package advsearch;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutationBiBfs(String start, String end, String[] bank_) {
        Set<String> bank = new HashSet<>(Arrays.asList(bank_));
        if (!bank.contains(end)) {
            return -1;
        }
        char[] choice = new char[] { 'A', 'C', 'G', 'T' };
        Set<String> begin = new HashSet<>();
        Set<String> goal = new HashSet<>();
        begin.add(start);
        goal.add(end);

        int length = 1;

        while (!begin.isEmpty() && !goal.isEmpty()) {
            if (begin.size() > goal.size()) {
                Set<String> temp = begin;
                begin = goal;
                goal = temp;
            }
            bank.removeAll(begin);
            Set<String> next = new HashSet<>();
            for (String gene : begin) {
                char[] temp = gene.toCharArray();
                for (int i = 0; i < temp.length; i ++) {
                    char ch = temp[i];
                    for (char c : choice) {
                        if (ch == c) {
                            continue;
                        }
                        temp[i] = c;
                        String newGene = String.valueOf(temp);
                        if (bank.contains(newGene)) {
                            if (goal.contains(newGene)) {
                                return length;
                            }
                            next.add(newGene);
                        }
                    }
                    temp[i] = ch;
                }
            }
            begin = next;
            length ++;
        }
        // 无法到达
        return -1;
    }

    public int minMutationBfs(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        int length = 1;

        while (!queue.isEmpty()) {
            // 遍历下一层
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String cur = queue.remove();
                for (String next : bank) {
                    if (!visited.contains(next) && check(cur, next)) {
                        if (next.equals(end)) {
                            return length;
                        }
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            length ++;
        }
        // 无法到达
        return -1;
    }
    private boolean check(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < 8; i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff ++;
            }
        }
        return diff == 1;
    }
}
