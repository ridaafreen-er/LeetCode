import heapq

class Solution:
    def networkDelayTime(self, times, n, k):
        graph = {}

        for u, v, time in times:
            if u not in graph:
                graph[u] = []
            graph[u].append((v, time))

        distances = [float('inf')] * (n + 1)
        distances[k] = 0

        heap = [(0, k)]

        while heap:
            current_time, node = heapq.heappop(heap)

            if current_time > distances[node]:
                continue

            for neighbor, time in graph.get(node, []):
                new_time = current_time + time

                if new_time < distances[neighbor]:
                    distances[neighbor] = new_time
                    heapq.heappush(heap, (new_time, neighbor))

        answer = max(distances[1:])

        if answer == float('inf'):
            return -1

        return answer