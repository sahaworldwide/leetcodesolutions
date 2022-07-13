/*
 * @lc app=leetcode id=102 lang=scala
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def levelOrder(root: TreeNode): List[List[Int]] = {
      def bfs(nodes: List[TreeNode] = Option(root).toList): List[List[Int]] =
        if (nodes.isEmpty) Nil
        else List(nodes.map(_.value)) ++ bfs(nodes.flatMap(node => List(Option(node.left), Option(node.right)).flatten))

        bfs()      
    }
}
// @lc code=end

