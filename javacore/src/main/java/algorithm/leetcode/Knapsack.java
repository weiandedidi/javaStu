package algorithm.leetcode;

/**
 * @author maqidi
 * @date 2023/4/13 8:33 PM
 */
public class Knapsack {
    public static void main(String[] args) {
        // 背包算法，也称为0-1背包问题，是一种经典的动态规划问题
        // 给定一组物品，每种物品都有自己的重量和价值，在限定的总重量内，选择其中若干个物品装入背包，使得装入背包中的物品总价值最大
        // 这里给出一个简单的实现，时间复杂度为O(N*W)，其中N为物品数量，W为背包容量
        // 输出220，即最大价值
        // 使用示例
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(W, wt, val, n));
    }

    static int knapsack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // 填充K[][]表格
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) K[i][w] = 0;
                else if (wt[i - 1] <= w) K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

}
