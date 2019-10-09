# https://leetcode.com/problems/next-permutation/
class Solution:
    def nextPermutation(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        index = -1
        for i in range(length-1, 0, -1):
            if nums[i-1] < nums[i]:
                index = i - 1
                break
        print(index)
        if index >= 0:
            j = index + 1
            while j < len(nums) and nums[index] < nums[j]:
                j += 1
            nums[index], nums[j-1] = nums[j-1], nums[index]

        start = index + 1
        end = len(nums) - 1
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
        print(nums)

input = [1,2]
temp = Solution()
print(temp.nextPermutation(input))