class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] a) {
        back(0,a,new ArrayList<>());
        return res;
    }
    void back(int i,int[] a,List<Integer> cur){
        if(i==a.length){ res.add(new ArrayList<>(cur)); return; }
        cur.add(a[i]);
        back(i+1,a,cur);
        cur.remove(cur.size()-1);
        back(i+1,a,cur);
    }
}
