package algos

import java.util.*

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

class Tree {
    fun checkIfSame(tree1: TreeNode?, tree2: TreeNode?): Boolean {
        return if (tree1 == null && tree2 == null) true else {
            tree1?.value == tree2?.value && checkIfSame(tree1?.left, tree2?.left) && checkIfSame(tree1?.right, tree2?.right)
        }
    }

    fun checkIfSameNotRec(tree1: TreeNode?, tree2: TreeNode?): Boolean {
        val stack1 = Stack<TreeNode>()
        val stack2 = Stack<TreeNode>()
        var current1 = tree1
        var current2 = tree1
        while ((current1 != null && current2 != null) || (stack1.size > 0 && stack2.size > 0) ) {

        }
        return true
    }

    fun traverse(tree: TreeNode?) {
        if (tree != null) {
            println(tree.value)
            traverse(tree.left)
            traverse(tree.right)
        }
    }

    fun traverse2(tree: TreeNode?) {
        val stack = Stack<TreeNode>()
        var current = tree
        while (current != null || stack.size > 0) {
            while (current != null) {
                println(current?.value)
                stack.push(current)
                current = current?.left
            }
            current = stack.pop()
            current = current?.right
        }
    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val q: Queue<TreeNode> = LinkedList()
        var depth = 1
        q.offer(root)
        while (!q.isEmpty()) {
            q.forEach() {
                val node = q.poll()
                if (node.left == null && node.right == null) return depth
                node.left?.run {q.offer(this) }
                node.right?.run {q.offer(this) }
            }
            depth++
        }
        return depth
    }

}