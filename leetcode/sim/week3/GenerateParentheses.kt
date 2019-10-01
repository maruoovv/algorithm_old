package sim.week3

fun main() {
    generateParenthesis(3)
}

fun generateParenthesis(n: Int): List<String> {
    return makeParenthesis(n*2, 0, "", mutableListOf())
}

fun makeParenthesis(n : Int, index : Int, cur : String, parenthesis : MutableList<String>) : MutableList<String> {
    if (index == n) {
        if (isWellFormedParenthesis(cur))
            parenthesis.add(cur)
        return parenthesis
    }

    makeParenthesis(n, index + 1, "$cur(", parenthesis)
    makeParenthesis(n, index + 1, "$cur)", parenthesis)

    return parenthesis
}

fun isWellFormedParenthesis(parenthesis: String) : Boolean {
    var count = 0
    parenthesis.forEach {
        if (count < 0) return false
        if (it == ')') count--
        else count++
    }

    return count == 0
}