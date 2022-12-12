package day12

import java.util.LinkedList
import java.util.Queue

class Node(val x: Int, val y: Int, val parent: Node?)

fun getStartOrEndLocation(start: Boolean, grid: Array<String>): Array<Int> {
    val searchTarget = if (start) {
        'S'
    } else {
        'E'
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == searchTarget) {
                return arrayOf(i, j)
            }
        }
    }
    return arrayOf(-1, -1)
}

fun getNeighbors(grid: Array<String>, node: Node): ArrayList<Node> {
    val out = ArrayList<Node>()
    // Above
    // Left
    // Right
    // Below
    return ArrayList()
}

fun getShortestPath(grid: Array<String>): Node {
    // (x, y) coordinates
    val startLocation = getStartOrEndLocation(true, grid)
    val endLocation = getStartOrEndLocation(false, grid)

    // Breadth-first search
    val queue = LinkedList<Node>()
    val visited = HashSet<Node>()
    val startNode = Node(startLocation[0], startLocation[1], null)
    queue.add(startNode)
    visited.add(startNode)

    while (queue.isNotEmpty()) {
        val v = queue.remove()
        if (v.x == endLocation[0] && v.y == endLocation[1]) {
            return v
        }
    }
    return startNode
}