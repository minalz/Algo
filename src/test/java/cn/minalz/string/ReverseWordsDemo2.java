package cn.minalz.string;

import org.junit.jupiter.api.Test;

/**
 * @description: 557.反转字符串中的单词 III
 * @author: minalz
 * @date: 2021-05-31 21:43
 **/
public class ReverseWordsDemo2 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(' ' + reverseWord(words[i]));
        }
        return sb.toString().trim();
    }

    public String reverseWord(String word) {
        String res = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            res += word.charAt(i);
        }
        return res;
    }

    @Test
    public void test01() {
        String s =  "Let's take LeetCode contest"; // -> "s'teL ekat edoCteeL tsetnoc"
        System.out.println(reverseWords(s));
    }
}
