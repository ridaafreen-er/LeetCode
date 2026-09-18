class Solution(object):
    def findCircleNum(self, isConnected):

        n = len(isConnected)

        visited = set()

        def dfs(city):

            visited.add(city)

            for neighbor in range(n):

                if isConnected[city][neighbor] == 1:
                    if neighbor not in visited:
                        dfs(neighbor)

        provinces = 0

        for city in range(n):

            if city not in visited:

                provinces += 1

                dfs(city)

        return provinces