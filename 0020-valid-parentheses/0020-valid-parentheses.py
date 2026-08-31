class Solution(object):
    def isValid(self, s):
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}

        for i in s:
            if i in mapping:  
                element = stack.pop() if stack else '#'
                if mapping[i] != element:
                    return False
            else:  
                stack.append(i)

        return not stack