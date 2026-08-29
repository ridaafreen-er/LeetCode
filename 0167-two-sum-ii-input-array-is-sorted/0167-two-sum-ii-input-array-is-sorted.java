class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;

        while(left<right){
            int current_s=numbers[left]+numbers[right];
            if(current_s==target){
                return new int[] {left+1,right+1};
            }
            else if(current_s<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[] {};
    }
}