class Solution(object):
    def reverse(self,nums,i,j):
        le=i
        ri=j

        while le<ri:
            temp=nums[le]
            nums[le]=nums[ri]
            nums[ri]=temp

            le+=1
            ri-=1

    def rotate(self, nums, k):
        k=k%len(nums)
        if(k<0):
            k+=len(nums)

        self.reverse(nums, 0, len(nums) - k - 1)
        self.reverse(nums, len(nums) - k, len(nums) - 1)
        self.reverse(nums, 0, len(nums) - 1)
                          
        

        