class Solution:
        def fib(self, n):

                first = 0
                second = 1

                for _ in range(n):

                    third = first + second

                    first = second
                    second = third

                return first