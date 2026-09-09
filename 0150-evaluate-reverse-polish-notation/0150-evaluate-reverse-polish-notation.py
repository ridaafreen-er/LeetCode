class Solution(object):
    def evalRPN(self, tokens):
        stack=[]
        for token in tokens:
            if token not in ['+','-','/','*']:
                stack.append(int(token))
            else:
                b=stack.pop()
                a=stack.pop()

                if token=='+':
                    stack.append(a+b)
                elif token=='-':
                    stack.append(a-b)
                elif token == '/':
                    if a * b < 0:
                        stack.append(-(abs(a) // abs(b)))
                    else:
                        stack.append(abs(a) // abs(b))
                                                   
                elif token=='*':
                    stack.append(a*b)
        return stack[-1]