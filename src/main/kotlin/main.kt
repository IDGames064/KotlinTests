import algos.*
import problems.*
import java.lang.NumberFormatException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors


fun lengthOfLongestSubstring(s: String): Int {
    var lookup = HashSet<Char>()
    var longest = 0
    var startIdx = 0
    var endIdx = 0
    while(endIdx < s.length) {
        if (lookup.contains(s[endIdx])) {
            lookup.remove(s[startIdx++])
        } else {
            lookup.add(s[endIdx++])
            longest = Math.max(lookup.size,longest)
        }
    }
    return longest
}



fun fibonacci() = generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }.map { it.first }


fun sumDigits(s: String): Int {
    var sum = 0
    s.forEach {
        if (Character.isDigit(it)) sum += Character.getNumericValue(it)
    }
    return sum
}

fun sumDigits2(s: String) = s.toCharArray().filter { it.isDigit() }.sumOf(Character::getNumericValue)

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map1 = nums1.toList().groupingBy{it}.eachCount().toMutableMap()
    val map2 = nums2.toList().groupingBy{it}.eachCount().toMutableMap()
    return map1.flatMap { (k1,v1) ->
        val v2 = map2[k1] ?: 0
        List(minOf(v1,v2)) {k1}
    }.toIntArray()
}


fun areAnagrams(s1: String, s2: String): Boolean {
    fun mapFromString(s: String) = HashMap<Char, Int>().apply {
            s.forEach { this[it] = (this[it] ?: 0) + 1}
        }

    val map1 = mapFromString(s1)
    val map2 = mapFromString(s2)

    val map3 = s1.groupingBy { it }.eachCount()
    val map4 = s2.groupingBy { it }.eachCount()

    return map3 == map4
}

fun generateParenthesis(n: Int) {
    fun generate(s: String, nOpen: Int, nClose: Int, n: Int) {
       if (s.length == 2*n) {
           println(s)
           return
       }
       if (nOpen < n) generate("$s(",nOpen+1,nClose,n)
       if (nClose < nOpen) generate("$s)",nOpen,nClose+1, n)
    }
    generate("",0,0,n)
}

fun isPalindromeShort0(s: String) = s.filter { it.isLetterOrDigit() }.run { equals(reversed(), true) }
fun isPalindromeShort1(s: String) = s.filter { it.isLetterOrDigit() }.let { it.equals(it.reversed(), true) }
fun isPalindromeShort(s: String) = with (s.filter { it.isLetterOrDigit() }) { this.equals(this.reversed(), true) }

fun isPalindrome(s: String):Boolean {
    if (s.isEmpty()) return true
    var head = 0
    var tail = s.length - 1
    while (head <= tail) {
        if (!s[head].isLetterOrDigit()) head++ else
            if (!s[tail].isLetterOrDigit()) tail-- else
                if (s[head++].toLowerCase() != s[tail--].toLowerCase()) return false
    }
    return true
}

fun isPalindromeNumber(input: Int): Boolean {
    if (input < 0 || input == Int.MAX_VALUE) return false
    var reverseInput = 0
    var current = input
    while (current > 0) {
        reverseInput = reverseInput * 10 + current % 10
        current /= 10
    }
    return reverseInput == input
}

fun isPalindromeNumberShort(input: Int) = "$input" == "$input".reversed()

fun singleNumber(nums: IntArray) = nums.reduce{res, elem -> res xor elem}

fun arrayToFreqMap(input: IntArray) = input.toCollection(ArrayList()).groupingBy{it}.eachCount()

fun main() {
    val weights = mapOf(
        Pair("A", "B") to 2,
        Pair("A", "C") to 8,
        Pair("A", "D") to 5,
        Pair("B", "C") to 1,
        Pair("C", "E") to 3,
        Pair("D", "E") to 2
    )

    val weights2 = mapOf(
        Pair("A", "B") to 10,
        Pair("A", "C") to 3,
        Pair("B", "C") to 1,
        Pair("C", "B") to 4,
        Pair("B", "D") to 2,
        Pair("C", "D") to 8,
        Pair("D", "E") to 7,
        Pair("E", "D") to 9,
        Pair("C", "E") to 2,
    )

    val weights3 = mapOf(
        Pair("A", "B") to 2,
        Pair("B", "C") to 2,
        Pair("A", "C") to 3,
        Pair("C", "D") to 3,
        Pair("D", "E") to 3,
        Pair("C", "E") to 7,
        Pair("E", "F") to 4,
        Pair("F", "G") to 4,
        Pair("E", "G") to 6,
        Pair("G", "H") to 5,
        Pair("H", "J") to 5,
        Pair("G", "J") to 11,
    )

    val start = "A"
    val shortestPathTree = Dijkstra(Graph(weights3), start)
    val shortestPathTree2 = BellmanFord(Graph(weights3), start)

    println(shortestPath(shortestPathTree, start, "J"))
    val ar = intArrayOf(125,1076,52,2,431,312,1,7235,22,100,8,144,91,1873,14)

    printResults(ar) { radixSort(it) }

    val matrix = arrayOf(arrayOf(1,1,0,0,1),arrayOf(1,1,0,0,0),arrayOf(1,1,1,0,0),arrayOf(0,0,0,0,1),arrayOf(0,0,1,1,1))
    println("there is ${IslandCounter().getSizes(matrix)} islands")
    matrix.print()

    val ll = LinkedList(listOf(0,1,2,3,4,5))
    println(ll.shift(2).toList())

    //println(isPalindrome("A man, a plan, a canal: Panama"))
    //println(isPalindromeShort("A man, a plan, a canal: Panama"))
    println(sumDigits("assa123456"))
    println(sumDigits2("aaaa123456"))

    var a = 2
    var b = 3
    println("a=$a b=$b")
    a = b.also {b = a}
    println("a=$a b=$b")

    var n1 = TreeNode(2, TreeNode(5, null, null),TreeNode(10, null, null))
    //var n2 = TreeNode(2, TreeNode(5, null, null),TreeNode(10, null, TreeNode(1,null,null)))
    var n2 = null
    val res = Tree().checkIfSame(n1,n2)
    println("same trees? $res")
    Tree().traverse(n2)

    val tree1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
        left!!.left = TreeNode(4)
        left!!.right = TreeNode(5)
    }
    val tree2 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
        left!!.left = TreeNode(4)
        left!!.right = TreeNode(6)
    }
    println("same trees? ${Tree().checkIfSame(tree1,tree2)}")
    Tree().traverse2(tree1)

   val executor = Executors.newFixedThreadPool(2)

   println("are anagrams: {${areAnagrams("aaacomputer","uterpmcoaaa")}}")

   // generateParenthesis(4)
/*    val arr = Array(10) {1}
    arr[2] = 2
    println(arr.joinToString())*/
    //println(arrayToFreqMap(intArrayOf(1,2,3,4,5,1,2,3)))
    println(fibonacci().take(2).joinToString())

    println(findMedianSortedArrays(intArrayOf(1,3,5,7), intArrayOf(2,4)))

    val ar1 = intArrayOf(4,3,2,5,2)
    val ar2 = intArrayOf(8,7,8,9,5,2,2)
    println(intersect(ar1,ar2).joinToString())

    val lst = List(2) {5}
    val hmap = HashMap<Int,Int>(20,0.75f)

    println(lengthOfLongestSubstring("bacabca"))
}