package cn.minalz.bfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 200.岛屿数量
 * @author: minalz
 * @date: 2021-05-30 22:05
 **/
public class BFSDemo1 {

    private int res;

    /**
     * 第一种通用解决方法DFS
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

    /**
     * 第二种通用解决思路方法 bfs
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int number = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] kx = {1, -1, 0, 0,};
        int[] ky = {0, 0, 1, -1};
        visited[i][j] = true;
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(i);
        yQueue.offer(j);
        while (!xQueue.isEmpty()) {
            int currentX = xQueue.poll();
            int currentY = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = currentX + kx[k];
                int newY = currentY + ky[k];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY] == '1') {
                        xQueue.offer(newX);
                        yQueue.offer(newY);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    @Test
    public void test03() {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands2(grid));
    }

}
