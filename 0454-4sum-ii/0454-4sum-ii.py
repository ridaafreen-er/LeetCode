class Solution(object):
    def fourSumCount(self, nums1, nums2, nums3, nums4):

        freq = {}

        # Store sums of nums1 + nums2
        for a in nums1:
            for b in nums2:

                total = a + b

                freq[total] = freq.get(total, 0) + 1

        count = 0

        # Find complementary sums
        for c in nums3:
            for d in nums4:

                total = c + d

                needed = -total

                if needed in freq:
                    count += freq[needed]

        return count