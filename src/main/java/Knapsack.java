public class Knapsack {
    public static int knapsackRecursive(int W, int[] weights, int[] values, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (weights[n - 1] > W) {
            return knapsackRecursive(W, weights, values, n - 1);
        } else {
            return Math.max(
                    values[n - 1] + knapsackRecursive(W - weights[n - 1], weights, values, n - 1),
                    knapsackRecursive(W, weights, values, n - 1)
            );
        }
    }

    public static int knapsack(int W, int[] weights, int[] values) {
        int[][] memory = new int[weights.length + 1][W + 1];
        for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    memory[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    memory[i][j] = Math.max(values[i - 1] + memory[i - 1][j - weights[i - 1]], memory[i - 1][j]);
                } else {
                    memory[i][j] = memory[i - 1][j];
                }
            }
        }

        return memory[weights.length][W];
    }
}
