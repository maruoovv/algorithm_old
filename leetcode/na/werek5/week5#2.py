# https://leetcode.com/problems/jump-game/
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        length = len(nums)
        index = length - 1

        for i in range(length-2, -1, -1):
            if index - i <= nums[i]:
                index = i
        return index == 0