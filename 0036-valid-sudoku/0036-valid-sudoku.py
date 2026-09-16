class Solution(object):
    def isValidSudoku(self, board):

        rows = [set() for i in range(9)]
        cols = [set() for i in range(9)]
        boxes = [set() for i in range(9)]

        for i in range(9):
            for j in range(9):

                if board[i][j] == ".":
                    continue

                num = board[i][j]

                # Check row
                if num in rows[i]:
                    return False
                rows[i].add(num)

                # Check column
                if num in cols[j]:
                    return False
                cols[j].add(num)

                # Find box number
                box = (i // 3) * 3 + (j // 3)

                if num in boxes[box]:
                    return False

                boxes[box].add(num)

        return True