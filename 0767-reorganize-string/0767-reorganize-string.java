import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = {-1, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            result.append((char)(curr[0] + 'a'));
            curr[1]--;

            // Reinsert previous character if it still has remaining count
            if (prev[1] > 0) {
                pq.offer(prev);
            }

            prev = curr;
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}