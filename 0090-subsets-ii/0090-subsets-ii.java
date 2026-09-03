class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(0, nums, new ArrayList<>());
        return res;
    }
    void back(int i, int[] a, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            cur.add(a[j]);
            back(j + 1, a, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
