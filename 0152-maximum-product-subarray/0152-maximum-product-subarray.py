class Solution(object):
    def maxProduct(self, nums):

        current_max = nums[0]
        current_min = nums[0]

        answer = nums[0]

        for i in range(1, len(nums)):

            x = nums[i]

            old_max = current_max
            old_min = current_min

            current_max = max(
                x,
                x * old_max,
                x * old_min
            )

            current_min = min(
                x,
                x * old_max,
                x * old_min
            )

            answer = max(answer, current_max)

        return answer