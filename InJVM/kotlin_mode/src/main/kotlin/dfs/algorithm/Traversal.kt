package dfs.algorithm

import dfs.algorithm.Traversal.midOrder
import dfs.algorithm.Traversal.postOrder
import dfs.algorithm.Traversal.preOrder
import tree.model.BinaryTree
import kotlin.math.pow

object Traversal {
    fun generatedCompleteBinaryTree(): BinaryTree<String> {
        val n = 4
        val elementLenght = (2.0.pow(n) - 1).toInt()
        val binaryTreeList = mutableListOf<BinaryTree<String>>()
        for (i in 1..elementLenght) {
            binaryTreeList.add(BinaryTree(value = "value-$i"))
        }
        binaryTreeList.toList().forEachIndexed { index, element ->
            element.leftTree = binaryTreeList.getOrNull(2 * (index + 1) - 1)
            element.rightTree = binaryTreeList.getOrNull(2 * (index + 1))
        }
        binaryTreeList.toList().forEach {
            println(it)
        }

        println("---Generated Binary Tree---")
        println("------------------------------------------------------")

        return binaryTreeList.getOrNull(0) ?: throw Exception()
    }

    fun <Value> preOrder(tree: BinaryTree<Value>?): List<BinaryTree<Value>> {
        tree ?: return emptyList()
        val list = mutableListOf<BinaryTree<Value>>()
        list.add(tree)
        list.addAll(preOrder(tree.leftTree))
        list.addAll(preOrder(tree.rightTree))
        return list
    }

    fun <Value> midOrder(tree: BinaryTree<Value>?): List<BinaryTree<Value>> {
        tree ?: return emptyList()
        val list = mutableListOf<BinaryTree<Value>>()
        list.addAll(midOrder(tree.leftTree))
        list.add(tree)
        list.addAll(midOrder(tree.rightTree))
        return list
    }

    fun <Value> postOrder(tree: BinaryTree<Value>?): List<BinaryTree<Value>> {
        tree ?: return emptyList()
        val list = mutableListOf<BinaryTree<Value>>()
        list.addAll(postOrder(tree.leftTree))
        list.addAll(postOrder(tree.rightTree))
        list.add(tree)
        return list
    }
}

fun main() {
    val completeBinaryTree = Traversal.generatedCompleteBinaryTree()
    println("---PreOrder---")
    println(preOrder(completeBinaryTree).map { it.value })
    println("---MidOrder---")
    println(midOrder(completeBinaryTree).map { it.value })
    println("---PostOrder---")
    println(postOrder(completeBinaryTree).map { it.value })
}