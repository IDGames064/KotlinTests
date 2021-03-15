import kotlin.math.floor

fun treeSort(ar: IntArray) {
    class Node(val key: Int, var left: Node? = null, var right: Node? = null)

    fun addNode(node: Node?, key: Int): Node {
        if (node == null) return Node(key)
        if (key < node.key) node.left = addNode(node.left, key)
        else node.right = addNode(node.right, key)
        return node
    }

    var idx = 0
    fun traverse(node: Node?) {
        if (node != null) {
            traverse(node.left)
            ar[idx++] = node.key
            traverse(node.right)
        }
    }

    val root = addNode(null, ar[0])
    for (i in 1 until ar.size) addNode(root, ar[i])

    traverse(root)

}


fun bubbleSort(ar: IntArray) {
    for (i in ar.size-2 downTo 0) {
        for (j in 0..i) {
            if (ar[j] > ar[j+1]) {
                ar[j] = ar[j+1].apply { ar[j+1] = ar[j] }
            }
        }
    }
}

fun quickSort(ar: IntArray) {
    fun sort(ar: IntArray, left: Int, right: Int) {
        var (i, j) = Pair(left, right)
        val pivot = ar[(i+j) / 2]
        while (i < j) {
            while (ar[i] < pivot) i++
            while (ar[j] > pivot) j--
            if (i <= j) ar[i] = ar[j].also { ar[j--] = ar[i++] }
        }
        if (i < right) sort(ar, i, right)
        if (j > left) sort(ar, left, j)
    }
    sort(ar,0,ar.size-1)
}

fun mergeSort(ar: IntArray) {
    fun merge(arResult: IntArray, arLeft: IntArray, arRight: IntArray) {
        var (resIdx,leftIdx,rightIdx) = Triple(0,0,0)
        while (leftIdx < arLeft.size && rightIdx < arRight.size) {
            if (arLeft[leftIdx] < arRight[rightIdx]) arResult[resIdx++] = arLeft[leftIdx++]
            else arResult[resIdx++] = arRight[rightIdx++]
        }
        for (i in leftIdx until arLeft.size) arResult[resIdx++] = arLeft[i]
        for (j in rightIdx until arRight.size) arResult[resIdx++] = arRight[j]
    }
    if (ar.size == 1) return
    val middleIndex = ar.size / 2
    val left = IntArray(middleIndex)
    left.forEachIndexed { index, _ -> left[index] = ar[index] }
    val right = IntArray(ar.size - left.size)
    right.forEachIndexed { index, _ -> right[index] = ar[middleIndex + index] }

    mergeSort(left)
    mergeSort(right)
    merge(ar, left, right)
}

fun heapSort(ar: IntArray) {
    fun maxHeapify(array: IntArray, rootIndex: Int, heapSize: Int = array.size - 1) {
        val leftChildIndex = (2 * rootIndex) + 1
        val rightChildIndex = (2 * rootIndex) + 2
        var largestElementIndex = rootIndex
        if (leftChildIndex <= heapSize && array[leftChildIndex] > array[rootIndex]) {
            largestElementIndex = leftChildIndex
        }
        if (rightChildIndex <= heapSize && array[rightChildIndex] > array[largestElementIndex]) {
            largestElementIndex = rightChildIndex
        }
        if (largestElementIndex != rootIndex) {
            array[rootIndex] = array[largestElementIndex].also { array[largestElementIndex] = array[rootIndex] }
            maxHeapify(array, largestElementIndex, heapSize)
        }
    }

    fun buildMaxHeap(array: IntArray) {
        for (i in ((array.size/2) - 1) downTo 0) {
            maxHeapify(array, i)
        }
    }

    buildMaxHeap(ar)
    for (i in ar.size - 1 downTo 1) {
        ar[0] = ar[i].also { ar[i] = ar[0]}
        maxHeapify(ar, 0, i - 1)
    }
}

fun insertSort(ar: IntArray) {
    for (j in 1 until ar.size){
        var i = j - 1
        val processedValue = ar[j]
        while ( (i >= 0) && (ar[i] > processedValue) ){
            ar[i + 1] = ar[i]
            i--
        }
        ar[i + 1] = processedValue
    }
}


fun selectionSort(ar: IntArray) {
    for (unsortedPartFirstIndex in ar.indices){
        var minNumberIndex = unsortedPartFirstIndex
        for (unsortedPartCurrentIndex in unsortedPartFirstIndex + 1 until ar.size){
            if (ar[unsortedPartCurrentIndex] < ar[minNumberIndex]){
                minNumberIndex = unsortedPartCurrentIndex
            }
        }
        if (minNumberIndex != unsortedPartFirstIndex){
            ar[unsortedPartFirstIndex] = ar[minNumberIndex].also { ar[minNumberIndex] = ar[unsortedPartFirstIndex] }
        }
    }
}

fun combSort(ar: IntArray) {
    var gap = ar.size
    val DIVISOR = 1.247330950103979
    var swappedElements : Boolean

    do {
        gap = floor((gap / DIVISOR)).toInt()
        if (gap < 1) gap = 1
        swappedElements = false
        var i = 0
        do {
            if (ar[i] > ar[i + gap]){
                ar[i] = ar[i + gap].also { ar[i + gap] = ar[i] }
                swappedElements = true
            }
            i++
        } while (i + gap < ar.size)

    } while ( (gap != 1) || swappedElements)
}


fun radixSort(ar: IntArray) {
    fun countingSort(place: Int) {
        val result = IntArray(ar.size)
        val count = IntArray(10)
        for (element in ar) {
            val digit = (element / place) % 10
            count[digit]++
        }
        for (i in 1 until count.size) {
            count[i] += count[i-1]
        }
        for (i in ar.size-1 downTo 0) {
            val digit = (ar[i] / place) % 10
            result[count[digit]-1] = ar[i]
            count[digit]--
        }
        result.copyInto(ar)

    }
    val max = ar.maxOrNull()!!
    var place = 1
    while (max / place > 0) {
        countingSort(place)
        place *= 10
    }

}

fun printResults(array:IntArray, method: (IntArray) -> Unit) {
    method(array)
    println(array.joinToString())
}