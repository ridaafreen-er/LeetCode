from collections import defaultdict

class Solution(object):
    def accountsMerge(self, accounts):

        parent = {}
        owner = {}

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])

            return parent[x]

        def union(a, b):
            rootA = find(a)
            rootB = find(b)

            if rootA != rootB:
                parent[rootB] = rootA

        for account in accounts:

            name = account[0]
            first_email = account[1]

            for email in account[1:]:

                if email not in parent:
                    parent[email] = email
                    owner[email] = name

                union(first_email, email)

        groups = defaultdict(list)

        for email in parent:
            root = find(email)
            groups[root].append(email)

        result = []

        for root in groups:
            emails = groups[root]
            emails.sort()

            result.append([owner[root]] + emails)

        return result