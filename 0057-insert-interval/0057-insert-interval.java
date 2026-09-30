class Solution {
    public int[][] insert(int[][] in, int[] n) {
        List<int[]> r=new ArrayList<>();
        int i=0;
        while(i<in.length && in[i][1]<n[0]) r.add(in[i++]);
        while(i<in.length && in[i][0]<=n[1]){
            n[0]=Math.min(n[0],in[i][0]);
            n[1]=Math.max(n[1],in[i++][1]);
        }
        r.add(n);
        while(i<in.length) r.add(in[i++]);
        return r.toArray(new int[r.size()][]);
    }
}
