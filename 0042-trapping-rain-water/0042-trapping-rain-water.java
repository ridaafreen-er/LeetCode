class Solution {
    public int trap(int[] h) {
        int l=0,r=h.length-1,left=0,right=0,res=0;
        while(l<r){
            if(h[l]<h[r]){
                left=Math.max(left,h[l]);
                res+=left-h[l++];
            }else{
                right=Math.max(right,h[r]);
                res+=right-h[r--];
            }
        }
        return res;
    }
}
