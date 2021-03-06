package cn.minalz.string;

import org.junit.jupiter.api.Test;

/**
 * @description: 12.整数转罗马数字
 * @author: minalz
 * @date: 2021-05-31 22:08
 **/
public class IntToRomanDemo {

    /**
     * 第一种写法 直接将规律列出来
     * @param num
     * @return
     */
    public String intToRoman1(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num/100)%10] + X[(num/10)%10] + I[num%10];
    }

    /**
     * 第二种写法 贪心算法 尽可能少的字符组成
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }

    @Test
    public void test01() {
        int num = 1032;
        // 列举法: MXXXII
        System.out.println("列举法: " + intToRoman1(num));
    }

    @Test
    public void test02() {
        int num = 1032;
        // 贪心算法: MXXXII
        System.out.println("贪心算法: " + intToRoman2(num));
    }

}
