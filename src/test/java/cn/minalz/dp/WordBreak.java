package cn.minalz.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 139.单词拆分
 * @author: minalz
 * @date: 2021-06-05 23:16
 **/
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        int largestLengthWord = getLargest(dict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= largestLengthWord && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                if (dict.contains(s.substring(i - j, i))) {
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[s.length()];
    }

    public int getLargest(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}
