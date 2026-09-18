class Solution(object):
    def cloneGraph(self, node):

        if node is None:
            return None

        copies = {}

        def dfs(node):

            if node in copies:
                return copies[node]

            copy = Node(node.val)

            copies[node] = copy

            for neighbor in node.neighbors:
                copy.neighbors.append(dfs(neighbor))

            return copy

        return dfs(node)