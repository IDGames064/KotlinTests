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