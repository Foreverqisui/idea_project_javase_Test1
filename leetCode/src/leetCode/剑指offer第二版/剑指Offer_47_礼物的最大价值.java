package leetCode.剑指offer第二版;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class 剑指Offer_47_礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(maxValue(grid));
    }

    private static int maxValue(int[][] grid) {
        //dp --
        int m = grid.length, n = grid[0].length;
        //构建dp矩阵
        int[][] dp = new int[m + 1][n + 1];
        //状态方程：dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 初始化第一行
        for(int j = 1; j < n; j++)
        {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第一列
        for(int i = 1; i < m; i++)
        {
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
