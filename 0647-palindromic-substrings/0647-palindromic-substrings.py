class Solution(object):
    def countSubstrings(self, s):
        n = len(s)

        dp = [[False] * n for _ in range(n)]

        count = 0

        for i in range(n):
            dp[i][i] = True
            count += 1

        for length in range(2, n + 1):

            for i in range(n - length + 1):

                j = i + length - 1

                if length == 2:
                    dp[i][j] = (s[i] == s[j])

                else:
                    dp[i][j] = (s[i] == s[j] and
                                dp[i + 1][j - 1])

                if dp[i][j]:
                    count += 1

        return count