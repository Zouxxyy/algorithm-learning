package nc01;

/*
岛屿数量

给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
示例1
输入
复制
[[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
返回值
复制
3
备注:
01矩阵范围<=200*200
 */

/**
 * @author zxy
 */
public class Solution09 {

    private static final int[][] STEPS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here

        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return res;

    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {

        for (int[] step : STEPS) {
            int newI = i + step[0];
            int newJ = j + step[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1') {
                grid[newI][newJ] = '0';
                dfs(grid, newI, newJ, m, n);
            }
        }
    }

}
