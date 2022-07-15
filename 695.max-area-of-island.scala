/*
 * @lc app=leetcode id=695 lang=scala
 *
 * [695] Max Area of Island
 */

// @lc code=start
object Solution {
    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
        val (m, n) = (grid(0).length, grid.length)

        def islandSize(x: Int, y: Int): Int =
        if (x < 0 || y < 0 || x == m || y == n || grid(y)(x) == 0) 0
        else {
            grid(y)(x) = 0 //sink the island
            1 + islandSize(x - 1, y) + islandSize(x + 1, y) + islandSize(x, y - 1) + islandSize(x, y + 1)
        }

        var max = 0
        for (x <- 0 until m; y <- 0 until n)
        if (grid(y)(x) == 1) max = max max islandSize(x, y)

        max       
    }
}
// @lc code=end

