class Solution:
    def dailyTemperatures(self, temperatures):

        answer = [0] * len(temperatures)

        stack = []

        for i in range(len(temperatures)):

            while stack and temperatures[i] > temperatures[stack[-1]]:

                previous = stack.pop()

                answer[previous] = i - previous

            stack.append(i)

        return answer