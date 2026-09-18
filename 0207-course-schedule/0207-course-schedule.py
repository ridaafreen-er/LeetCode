class Solution(object):
    def canFinish(self, numCourses, prerequisites):

        graph = [[] for _ in range(numCourses)]

        # Build graph
        for course, prerequisite in prerequisites:
            graph[prerequisite].append(course)

        state = [0] * numCourses

        def dfs(course):

            # Currently visiting → cycle
            if state[course] == 1:
                return False

            # Already completed
            if state[course] == 2:
                return True

            # Mark as currently visiting
            state[course] = 1

            for nextCourse in graph[course]:

                if not dfs(nextCourse):
                    return False

            # Finished completely
            state[course] = 2

            return True

        for course in range(numCourses):

            if not dfs(course):
                return False

        return True