class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Create padded array
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // length is the distance between i and j
        for (int length = 2; length < n + 2; length++) {
            for (int i = 0; i + length < n + 2; i++) {
                int j = i + length;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]
                    );
                }
            }
        }

        return dp[0][n + 1];
    }
}