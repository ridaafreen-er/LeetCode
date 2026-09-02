class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    void backtrack(String d, int idx, StringBuilder sb) {
        if (idx == d.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : map[d.charAt(idx) - '0'].toCharArray()) {
            sb.append(c);
            backtrack(d, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
