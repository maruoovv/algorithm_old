package sim.week3

fun main() {
    print(nextPermutation(arrayOf(1,3,2).toIntArray()))
}

fun nextPermutation(nums: IntArray): IntArray {
    var index = nums.size - 2

    while (index >= 0 && nums[index + 1] <= nums[index]) {
        index--
    }

    if (index >= 0) {
        var j = nums.size - 1
        while(j >= 0 && nums[j] <= nums[index]) {
            j--
        }

        swap(nums, index, j)
    }
    reverse(nums, index + 1)
    return nums
}

fun reverse(nums : IntArray, i : Int) {
    var start = i
    var end = nums.size - 1
    while(start < end) {
        swap(nums, start, end)
        start++
        end--
    }
}

fun swap(nums: IntArray, i : Int, j : Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}