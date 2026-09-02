class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] a) {
        back(a,0);
        return res;
    }
    void back(int[] a,int i){
        if(i==a.length){
            List<Integer> l=new ArrayList<>();
            for(int n:a) l.add(n);
            res.add(l); return;
        }
        for(int j=i;j<a.length;j++){
            int t=a[i]; a[i]=a[j]; a[j]=t;
            back(a,i+1);
            t=a[i]; a[i]=a[j]; a[j]=t;
        }
    }
}
