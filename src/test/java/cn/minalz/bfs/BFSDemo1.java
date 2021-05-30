package cn.minalz.bfs;

import org.junit.jupiter.api.Test;

/**
 * @description: 200.岛屿数量
 * @author: minalz
 * @date: 2021-05-30 22:05
 **/
public class BFSDemo1 {

    private int res;

    /**
     * 通用解决方法
     * 解题思路链接：
     * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        res = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                // 遇到1才会遍历 会把相邻的都遍历掉
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    res ++;
                }
                System.out.print(grid[i][j] + ",");
            }
            System.out.println();
        }
        return res;
    }

    private void dfsGrid(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';
        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);
    }

    @Test
    public void test01() {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    @Test
    public void test02() {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }

}