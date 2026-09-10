
class Solution(object):
    def isIsomorphic(self, s, t):

        map_s_t = {}
        map_t_s = {}

        for i in range(len(s)):

            a = s[i]
            b = t[i]

            if a in map_s_t:
                if map_s_t[a] != b:
                    return False

            if b in map_t_s:
                if map_t_s[b] != a:
                    return False

            map_s_t[a] = b
            map_t_s[b] = a

        return True
        