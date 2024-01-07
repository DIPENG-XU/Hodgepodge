package tree.model

class BinaryTree<Value>(
    override val value: Value,
    var leftTree: BinaryTree<Value>? = null,
    var rightTree: BinaryTree<Value>? = null,
) : Tree<Value>(value) {
    override fun toString(): String {
        return "BinaryTree(value=$value, leftTree=${leftTree?.value}, rightTree=${rightTree?.value})"
    }
}