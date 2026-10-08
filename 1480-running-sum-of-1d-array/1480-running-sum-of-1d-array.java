class Solution {
    public int[] runningSum(int[] nums) {
     int[] num= new int[nums.length];
     int nuu=0;
     for(int i=0;i<nums.length;i++){
        nuu+=nums[i];
        num[i]=nuu;
     }
     return num;
    }
}