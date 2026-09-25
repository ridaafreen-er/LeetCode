class Solution(object):
    def findTargetSumWays(self, nums, target):

        dp = {0: 1}

        for num in nums:

            new_dp = {}

            for total in dp:

                new_dp[total + num] = \
                    new_dp.get(total + num, 0) + dp[total]

                new_dp[total - num] = \
                    new_dp.get(total - num, 0) + dp[total]

            dp = new_dp

        return dp.get(target, 0)