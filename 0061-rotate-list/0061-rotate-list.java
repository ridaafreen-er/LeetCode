class Solution {
    public ListNode rotateRight(ListNode h, int k) {
        if(h==null) return h;
        ListNode cur=h; int n=1;
        while(cur.next!=null){cur=cur.next;n++;}
        cur.next=h; k%=n;
        for(int i=0;i<n-k;i++) cur=cur.next;
        ListNode nh=cur.next;
        cur.next=null;
        return nh;
    }
}
