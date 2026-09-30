class Solution {
    public boolean canJump(int[] a) {
        int reach=0;
        for(int i=0;i<a.length;i++){
            if(i>reach) return false;
            reach=Math.max(reach,i+a[i]);
        }
        return true;
    }
}
