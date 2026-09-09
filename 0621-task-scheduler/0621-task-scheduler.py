from collections import Counter

class Solution(object):

    def leastInterval(self, tasks, n):

        freq = Counter(tasks)

        max_freq = max(freq.values())

        count_max = 0

        for value in freq.values():
            if value == max_freq:
                count_max += 1

        answer = (max_freq - 1) * (n + 1) + count_max

        return max(len(tasks), answer)