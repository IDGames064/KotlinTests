package problems

data class LinkedListElement(var value: Int, var next: LinkedListElement? = null)

class LinkedList(fromList: List<Int>) {
    var head: LinkedListElement? = null
    init {
        fromList.forEach { insert(it) }
    }
    fun insert(value: Int) {
        if (head == null) head = LinkedListElement(value)
        else {
            var elem = head!!
            while (elem.next != null) {
                elem = elem.next!!
            }
            elem.next = LinkedListElement(value)
        }
    }

    fun addTwoNumbers(l1: LinkedListElement?, l2: LinkedListElement?): LinkedListElement? {
        var result: LinkedListElement? = null
        var l1head = l1
        var l2head = l2
        var carry = 0
        while (l1head != null || l2head != null) {
            val member1 = l1head?.value ?: 0
            val member2 = l2head?.value ?: 0
            val sum = member1 + member2 + carry
            l1head = l1head?.next
            l2head = l2head?.next
        }
        return result
    }


    fun toList(): List<Int> {
       val result = mutableListOf<Int>()
        var elem = head
        while (elem != null) {
            result.add(elem.value)
            elem = elem.next
        }
        return result
    }
    fun shift(k: Int): LinkedList {
        if (head == null) return this
        var lastElem = head
        var listSize = 1
        while (lastElem!!.next != null) {
            lastElem = lastElem.next
            listSize++
        }
        var nShifts = k % listSize
        if (nShifts < 0) nShifts += listSize
        if (nShifts == 0) return this
        var elem = head
        repeat(listSize-nShifts-1) {
            elem = elem!!.next
        }
        head = elem!!.next.also { lastElem.next = head }
        elem!!.next = null
        return this
    }

    fun reverse(): LinkedList {
        if (head == null) return this
        var prev: LinkedListElement? = null
        var elem = head
        while (elem != null) {
            elem.next = prev.also {
                prev = elem
                elem = elem!!.next
            }
        }
        head = prev
        return this
    }

}