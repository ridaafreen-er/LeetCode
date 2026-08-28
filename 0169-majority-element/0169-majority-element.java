class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> mapp=new HashMap<>();

        for(int i=0;i<n;i++){
            if(mapp.containsKey(nums[i])){
                mapp.put(nums[i],mapp.get(nums[i])+1);
            }else{
            mapp.put(nums[i],1);
            }
        }

        for(Integer key:mapp.keySet()){
            if(mapp.get(key)>n/2){
                return key;
            }
        }
        return -1;
    
}
}