class Solution(object):
    def change(self, amount, coins):
        dp = [0] * (amount + 1)

        dp[0] = 1

        for coin in coins:

            for current in range(coin, amount + 1):

                dp[current] += dp[current - coin]

        return dp[amount]