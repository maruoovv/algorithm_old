package sim.week3

fun main() {
    print(search(arrayOf(4,5,6,7,0,1,2).toIntArray(), 2))
}

// 일반적인 binary search 를 사용할수 없는 상황.
// 4 5 6 7 0 1 2 에서 0 을 찾는다고 했을때, 일반적인 bs 로는 해결을 할수없다.
// bs 는 보통 mid 값을 비교하여 찾는값이 크면 오른쪽, 작으면 왼쪽부분을 재귀적으로 찾게 되는데, 정렬이 되지 않은 상황에선 사용할수없다.
// 그렇다면 비교값을 mid 값을 사용할수 없을때, 다른값을 사용하도록 한다면?
// 4 5 6 7 0 1 2 에서 0을 찾는다고 하면 오른쪽 부분을 찾게 해야한다.
// -INF -INF -INF -INF 0 1 2 이렇게 바꿔주면 오른쪽부분을 찾게 할수있다.
// 반대로 4 5 6 7 0 1 2 에서 5를 찾는다고 하면 4 5 6 7 INF INF INF 이렇게 바꿔주면 왼쪽 부분을 찾게할수있다.
// 이 해법에서 중요한건, mid 값을 그대로 쓸수 있는지, 사용할수 없다면 비교값을 -INF, INF 로 바꿔주는 것이다.
// mid 값을 그대로 쓸수 있는 경우는, target 값과 mid 가 같은 부분에 있다고 판단될때이다.
// **mid 값을 사용할수 있는 경우**
// 1. 찾는값이 num[low]보다 작을때는, num[mid] 도 num[low] 보다 작아야 한다.
// ex) 4 5 6 0 1 2 3 에서 2를 찾는다고 할때, 2는 4보다 작고 0은 4보다 작으므로 mid 를 사용할수 있다.
//     4 5 6 7 1 2 3 에서 2를 찾는다고 할때, 2는 4보다 작은데 7은 4보다 크다. 이 경우에 mid 값을 비교자로 사용하게 되면 왼쪽 부분을 찾게 되어 제대로된 이분탐색이 되지 않는다.
// 2. 찾는값이 num[low]보다 클때, num[mid]도 num[low] 보다 커야한다.
// ex) 4 5 6 7 1 2 3 에서 5를 찾는다고 할때, 5는 4보다 크고 7은 4보다 크므로 mid 를 사용할수 있다.
//     4 5 6 0 1 2 3 에서 5를 찾는다고 할때, 5는 4보다 큰데 0은 4보다 작다. 이 경우에 mid 값을 비교자로 사용하게 되면 오른쪽 부분을 찾게 되어 제대로된 이분탐색이 되지 않는다.
// 이 조건을 만족하지 못할때는, mid 대신 -INF 나 INF 를 사용해야 하는 상황인것이다.
// 정렬이 된 상황이라면 위의 2번 조건을 항상 만족한다.

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    var low = 0
    var high = nums.size - 1

    while (low <= high) {
        val mid = (high - low) / 2 + low
        var comp = nums[mid]
        comp = if ((target < nums[low] && nums[mid] < nums[low]) || (target >= nums[low] && nums[mid] >= nums[low])) {
            nums[mid]
        } else {
            if (target < nums[low]) {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }

        when {
            comp > target -> high = mid - 1
            comp < target -> low = mid + 1
            else -> return mid
        }
    }

    return -1
}