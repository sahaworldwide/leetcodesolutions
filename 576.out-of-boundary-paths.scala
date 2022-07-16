/*
 * @lc app=leetcode id=576 lang=scala
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
object Solution {
  def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
    val map = scala.collection.mutable.Map.empty[(Int, Int, Int), Long]
    val M = 1000_000_007

    def helper(remainingMoves: Int = maxMove, x: Int = startRow, y: Int = startColumn): Long =
      if (x < 0 || x == m || y < 0 || y == n) 1
      else if (remainingMoves == 0) 0
      else map get(x, y, remainingMoves) match {
        case Some(v) => v
        case _ => val v = (helper(remainingMoves - 1, x - 1, y) % M
          + helper(remainingMoves - 1, x + 1, y) % M
          + helper(remainingMoves - 1, x, y - 1) % M
          + helper(remainingMoves - 1, x, y + 1) % M) % M
          map += (x, y, remainingMoves) -> v
          v
      }

    (helper() % M).toInt
  }
}
// @lc code=end

