# https://leetcode.com/problems/kth-largest-element-in-an-array/
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # return sorted(nums, reverse=True)[k-1]
        return heapq.nlargest(k, nums)[k-1]