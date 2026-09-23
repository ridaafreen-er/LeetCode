import heapq
from collections import defaultdict

class DualHeap:

    def __init__(self, k):
        self.small = []
        self.large = []

        self.delayed = defaultdict(int)

        self.small_size = 0
        self.large_size = 0

        self.k = k

    def prune(self, heap):

        while heap:

            if heap is self.small:
                num = -heap[0]
            else:
                num = heap[0]

            if self.delayed[num] > 0:
                self.delayed[num] -= 1
                heapq.heappop(heap)
            else:
                break

    def makeBalance(self):

        if self.small_size > self.large_size + 1:

            num = -heapq.heappop(self.small)

            heapq.heappush(self.large, num)

            self.small_size -= 1
            self.large_size += 1

            self.prune(self.small)

        elif self.small_size < self.large_size:

            num = heapq.heappop(self.large)

            heapq.heappush(self.small, -num)

            self.small_size += 1
            self.large_size -= 1

            self.prune(self.large)

    def add(self, num):

        if not self.small or num <= -self.small[0]:

            heapq.heappush(self.small, -num)
            self.small_size += 1

        else:

            heapq.heappush(self.large, num)
            self.large_size += 1

        self.makeBalance()

    def remove(self, num):

        self.delayed[num] += 1

        if num <= -self.small[0]:

            self.small_size -= 1

            if num == -self.small[0]:
                self.prune(self.small)

        else:

            self.large_size -= 1

            if self.large and num == self.large[0]:
                self.prune(self.large)

        self.makeBalance()

    def getMedian(self):

        if self.k % 2 == 1:
            return float(-self.small[0])

        return (-self.small[0] + self.large[0]) / 2.0


class Solution(object):

    def medianSlidingWindow(self, nums, k):

        dh = DualHeap(k)
        result = []

        for i in range(k):
            dh.add(nums[i])

        result.append(dh.getMedian())

        for i in range(k, len(nums)):

            dh.add(nums[i])

            dh.remove(nums[i - k])

            result.append(dh.getMedian())

        return result