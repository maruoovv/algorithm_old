package week1

import java.math.BigDecimal
import java.util.*

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val list1 = reverseListNode(l1!!)
    val list2 = reverseListNode(l2!!)

    val intValue1 = getBigDecimalValue(list1)
    val intValue2 = getBigDecimalValue(list2)

    val sum = intValue1 + intValue2
    val resultList = makeListNode(sum)
    return reverseListNode(resultList)
}

private fun reverseListNode(listNode: ListNode): ListNode {
    val stack = Stack<ListNode>()

    var node = listNode
    while (true) {
        stack.push(node)

        if (node.next == null) break
        node = node.next!!
    }

    val head = ListNode(stack.pop().`val`)
    var tempNode = head
    while (!stack.empty()) {
        val node = ListNode(stack.pop().`val`)
        tempNode.next = node
        tempNode = node
    }

    return head
}

private fun getBigDecimalValue(listNode: ListNode): BigDecimal {
    val stringBuilder = StringBuilder()

    var node = listNode
    while (true) {
        stringBuilder.append(node.`val`)
        if (node.next == null) break
        node = node.next!!
    }

    return stringBuilder.toString().toBigDecimal()
}

private fun makeListNode(value: BigDecimal): ListNode {
    val stringValue = value.toString()

    val head = ListNode((stringValue[0] - '0'))
    var node = head
    stringValue.substring(1).forEach {
        node.next = ListNode(it - '0')
        node = node.next!!
    }

    return head
}


data class ListNode(var `val`: Int) {
    var next: ListNode? = null

}