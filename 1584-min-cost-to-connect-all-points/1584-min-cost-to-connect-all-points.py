class Solution:
    def minCostConnectPoints(self, points):

        n = len(points)

        visited = [False] * n
        minDist = [float('inf')] * n

        minDist[0] = 0

        answer = 0

        for _ in range(n):

            current = -1

            for i in range(n):

                if not visited[i] and (
                    current == -1 or
                    minDist[i] < minDist[current]
                ):
                    current = i

            visited[current] = True
            answer += minDist[current]

            x1, y1 = points[current]

            for j in range(n):

                if not visited[j]:

                    x2, y2 = points[j]

                    distance = abs(x1 - x2) + abs(y1 - y2)

                    if distance < minDist[j]:
                        minDist[j] = distance

        return answer