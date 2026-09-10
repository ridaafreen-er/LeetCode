class Solution(object):
    def topKFrequent(self, nums, k):

        freq = {}

        # Count frequency
        for num in nums:
            freq[num] = freq.get(num, 0) + 1

        # Create buckets
        bucket = [[] for _ in range(len(nums) + 1)]

        # Put numbers into their frequency bucket
        for num in freq:
            count = freq[num]
            bucket[count].append(num)

        # Read from highest frequency
        result = []

        for i in range(len(bucket) - 1, 0, -1):

            for num in bucket[i]:
                result.append(num)

                if len(result) == k:
                    return result