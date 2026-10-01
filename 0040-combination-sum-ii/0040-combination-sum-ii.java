class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] c, int t) {
        Arrays.sort(c);
        back(c,t,0,new ArrayList<>());
        return res;
    }
    void back(int[] c,int t,int i,List<Integer> cur){
        if(t==0){res.add(new ArrayList<>(cur)); return;}
        for(int j=i;j<c.length && c[j]<=t;j++){
            if(j>i && c[j]==c[j-1]) continue;
            cur.add(c[j]);
            back(c,t-c[j],j+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
