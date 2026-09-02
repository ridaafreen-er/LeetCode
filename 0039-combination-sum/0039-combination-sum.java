class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] c, int t) {
        back(c,t,0,new ArrayList<>());
        return res;
    }
    void back(int[] c,int t,int i,List<Integer> cur){
        if(t==0){res.add(new ArrayList<>(cur)); return;}
        if(t<0) return;
        for(int j=i;j<c.length;j++){
            cur.add(c[j]);
            back(c,t-c[j],j,cur);
            cur.remove(cur.size()-1);
        }
    }
}
