class Solution {
    public int[][] merge(int[][] i) {
        Arrays.sort(i,(a,b)->a[0]-b[0]);
        List<int[]> r=new ArrayList<>();
        for(int[] in:i){
            if(r.isEmpty()||r.get(r.size()-1)[1]<in[0])
                r.add(in);
            else
                r.get(r.size()-1)[1]=Math.max(r.get(r.size()-1)[1],in[1]);
        }
        return r.toArray(new int[r.size()][]);
    }
}
