class Solution(object):
    def rotate(self, matrix):
        n=len(matrix)
        for i in range(n-1, -1, -1):
            for j in range(i-1, -1, -1):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        for i in range(n):
            matrix[i].reverse()
        