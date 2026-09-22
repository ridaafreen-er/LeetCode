from collections import Counter

class Solution:
    def topKFrequent(self, words, k):
        count = Counter(words)

        result = sorted(
            count.keys(),
            key=lambda word: (-count[word], word)
        )

        return result[:k]