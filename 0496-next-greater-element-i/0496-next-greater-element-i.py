class Solution:
    def nextGreaterElement(self, nums1, nums2):

        stack = []
        nextGreater = {}

        for num in nums2:

            while stack and num > stack[-1]:

                smaller = stack.pop()
                nextGreater[smaller] = num

            stack.append(num)

        while stack:
            nextGreater[stack.pop()] = -1

        answer = []

        for num in nums1:
            answer.append(nextGreater[num])

        return answer