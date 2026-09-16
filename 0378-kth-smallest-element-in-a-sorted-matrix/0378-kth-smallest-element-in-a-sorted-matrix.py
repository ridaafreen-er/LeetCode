import heapq

class Solution(object):
    def kthSmallest(self, matrix, k):

        n = len(matrix)

        heap = []

        # Put first element of every row
        for i in range(n):
            heapq.heappush(heap, (matrix[i][0], i, 0))

        # Remove smallest k-1 times
        for i in range(k - 1):

            value, row, col = heapq.heappop(heap)

            # Add next element from same row
            if col + 1 < n:
                heapq.heappush(
                    heap,
                    (matrix[row][col + 1], row, col + 1)
                )

        return heapq.heappop(heap)[0]     