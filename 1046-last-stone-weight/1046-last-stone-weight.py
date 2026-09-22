import heapq

class Solution:
    def lastStoneWeight(self, stones):

        heap = [-stone for stone in stones]

        heapq.heapify(heap)

        while len(heap) > 1:

            first = -heapq.heappop(heap)
            second = -heapq.heappop(heap)

            if first != second:

                remaining = first - second

                heapq.heappush(heap, -remaining)

        if heap:
            return -heap[0]

        return 0