class Solution {
    public String minWindow(String s, String t) {
        int[] f=new int[128];
        for(char c:t.toCharArray()) f[c]++;
        int l=0,r=0,cnt=t.length(),min=Integer.MAX_VALUE,start=0;

        while(r<s.length()){
            if(f[s.charAt(r++)]-- >0) cnt--;
            while(cnt==0){
                if(r-l<min){ min=r-l; start=l; }
                if(f[s.charAt(l++)]++==0) cnt++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}
