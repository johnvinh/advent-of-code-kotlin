package day12

import dev.johnvinh.getInput
import java.lang.IndexOutOfBoundsException
import java.util.LinkedList
import java.util.Queue

class Node(val row: Int, val col: Int, var prev: Node?, var elevation: Char, var tentativeDistance: Double) {
    override fun equals(other: Any?): Boolean {
        if (other !is Node) return false
        return (this.row == other.row) && (this.col == other.row)
    }

    override fun toString(): String {
        return "Node(${row}, ${col})"
    }
}

fun getStartOrEndLocation(start: Boolean, grid: List<String>): Array<Int> {
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

fun getNeighbors(grid: ArrayList<ArrayList<Node>>, node: Node): ArrayList<Node> {
    val out = ArrayList<Node>()
    // Above, left, right, below
    val potentialNeighbors = arrayOf(
        arrayOf(node.row - 1, node.col),
        arrayOf(node.row, node.col - 1),
        arrayOf(node.row, node.col + 1),
        arrayOf(node.row + 1, node.col)
    )
    for (potentialNeighbor in potentialNeighbors) {
        try {
            val neighbor = grid[potentialNeighbor[0]][potentialNeighbor[1]]
            if ((neighbor.elevation == (node.elevation + 1)) || (neighbor.elevation <= node.elevation)) {
                out.add(neighbor)
            }
        } catch (e: IndexOutOfBoundsException) {
            continue
        }
    }
    return out
}

fun getShortestPathDistance(grid: List<String>): Double {
    val nodeGrid = ArrayList<ArrayList<Node>>()
    for (i in grid.indices) {
        nodeGrid.add(ArrayList())
        for (j in grid[i].indices) {
            if (grid[i][j] == 'S') {
                nodeGrid[i].add(Node(i, j, null, 'a', 0.0))
            } else if (grid[i][j] == 'E') {
                nodeGrid[i].add(Node(i, j, null, 'z', 0.0))
            } else {
                nodeGrid[i].add(Node(i, j, null, grid[i][j], 0.0))
            }
            nodeGrid[i][j].tentativeDistance = Double.POSITIVE_INFINITY
        }
    }
    val startLocation = getStartOrEndLocation(true, grid)
    val endLocation = getStartOrEndLocation(false, grid)
    val start = Node(startLocation[0], startLocation[1], null, 'a', 0.0)
    val queue = LinkedList<Node>()
    val visited = HashSet<Node>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val v = queue.remove()
        if (v.row == endLocation[0] && v.col == endLocation[1]) {
            return v.tentativeDistance
        } else {
            val neighbors = getNeighbors(nodeGrid, v)
            for (neighbor in neighbors) {
                if (!visited.contains(neighbor)) {
                    neighbor.prev = v
                    neighbor.tentativeDistance = v.tentativeDistance + 1
                    queue.add(neighbor)
                }
            }
        }
        visited.add(v)
    }
    return -1.0
}

fun main() {
    val input = getInput()
    println(getShortestPathDistance(input))
}