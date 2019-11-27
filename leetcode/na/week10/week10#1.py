# https://leetcode.com/problems/maximum-product-subarray/
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        reverse_nums = nums[::-1]
        for i in range(1, len(nums)):
            nums[i] *= nums[i-1] or 1
            reverse_nums *= reverse_nums[i-1] or 1

        return max(nums + reverse_nums)