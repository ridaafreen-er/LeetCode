class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(1,n,k,new ArrayList<>());
        return res;
    }
    void back(int s,int n,int k,List<Integer> cur){
        if(cur.size()==k){ res.add(new ArrayList<>(cur)); return; }
        for(int i=s;i<=n;i++){
            cur.add(i);
            back(i+1,n,k,cur);
            cur.remove(cur.size()-1);
        }
    }
}
