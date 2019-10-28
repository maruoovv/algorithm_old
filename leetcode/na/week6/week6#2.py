# https://leetcode.com/problems/sort-colors/
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        hint : dutch partitioning problem
        """
        red, white, blue = 0, 0, len(nums)-1

        while white <= blue:
            if nums[white] == 0:
                nums[red], nums[white] = nums[white], nums[red]
                white += 1
                red += 1
            elif nums[white] == 1:
                white += 1
            else:
                nums[white], nums[blue] = nums[blue], nums[white]
                blue -= 1
        return

"""
if not nums:
            return
        onesIdx = 0
        twosIdx = len(nums) - 1
        idx = 0
        while idx <= twosIdx:
            if nums[idx] == 0:
                nums[onesIdx], nums[idx] = nums[idx], nums[onesIdx]
                onesIdx += 1
                idx += 1
            elif nums[idx] == 2:
                nums[twosIdx], nums[idx] = nums[idx], nums[twosIdx]
                twosIdx -= 1
            else:
                idx += 1
"""
        
        
input = [2,0,2,1,1,0]
# output = [0,0,1,1,2,2]
temp = Solution()
print(temp.sortColors(input))