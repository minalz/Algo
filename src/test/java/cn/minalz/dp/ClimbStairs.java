package cn.minalz.dp;

import org.junit.jupiter.api.Test;

/**
 * @description: 70.爬楼梯
 * @author: minalz
 * @date: 2021-06-05 18:40
 **/
public class ClimbStairs {

    /**
     * 方法一: 递归 但是效率很慢 虽然能解决 但是不推荐
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        // n = 1 -> 1 (ways -> 1)
        // n = 2 -> 2 (ways -> 11,2)
        // n = 3 -> 3 (ways -> 111,12,21)
        // n = 4 -> 5 (ways -> 1111,112,121,211,22)
        // n = 5 -> 8 (ways -> 11111,1211,122,1112,2111,221,212,1121)
        if (n <= 3) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    /**
     * 方法二: 提前将每一步值存入数组中 避免栈的深度太深
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    /**
     * 方法三: 和方法二差不多 但是用的滚动数组 从空间复杂度上更优化
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i%3] = steps[(i - 1)%3] + steps[(i - 2)%3];
        }
        return steps[(n - 1)%3];
    }

    @Test
    public void test01() {
        System.out.println(climbStairs1(6));
        System.out.println(climbStairs2(6));
        System.out.println(climbStairs3(6));
    }
}
