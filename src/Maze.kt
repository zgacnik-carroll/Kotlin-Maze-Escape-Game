fun main() {
    do {
        showTitleScreen()
        playMazeGame()
    } while (askReplay())

    println("Thanks for playing! Goodbye!")
}

fun showTitleScreen() {
    println("#######################################")
    println("#                                     #")
    println("#        WELCOME TO MAZE ESCAPE       #")
    println("#                                     #")
    println("#######################################\n")
    println("Instructions:")
    println("Use W/A/S/D to move your player (P) through the maze.")
    println("Reach the exit (E) to win. Walls (#) block your path.")
    println("Press Q anytime to quit the current game.\n")
    println("Press ENTER to start...")
    readln()
}

fun playMazeGame() {
    val maze = arrayOf(
        "####################".toCharArray(),
        "#P   #       #     #".toCharArray(),
        "# ## # ##### # ### #".toCharArray(),
        "#    #     # #   # #".toCharArray(),
        "#### ##### # ### # #".toCharArray(),
        "#        # #     # #".toCharArray(),
        "# ###### # ##### # #".toCharArray(),
        "#      #         # #".toCharArray(),
        "# #### # #######   #".toCharArray(),
        "##################E#".toCharArray()
    )

    var playerRow = 1
    var playerCol = 1

    while (true) {
        printMaze(maze)

        println("Move (W/A/S/D) or Q to quit:")
        val input = readln().uppercase()

        if (input == "Q") {
            println("You quit the maze.")
            break
        }

        val (newRow, newCol) = when (input) {
            "W" -> Pair(playerRow - 1, playerCol)
            "S" -> Pair(playerRow + 1, playerCol)
            "A" -> Pair(playerRow, playerCol - 1)
            "D" -> Pair(playerRow, playerCol + 1)
            else -> {
                println("Invalid input! Use W/A/S/D to move.")
                Pair(playerRow, playerCol)
            }
        }

        val nextTile = maze[newRow][newCol]

        when (nextTile) {
            '#' -> println("You hit a wall!")
            'E' -> {
                printMaze(maze)
                println("\nYou escaped the maze! Congratulations!")
                break
            }
            ' ' -> {
                maze[playerRow][playerCol] = ' '
                playerRow = newRow
                playerCol = newCol
                maze[playerRow][playerCol] = 'P'
            }
        }
    }
}

fun askReplay(): Boolean {
    while (true) {
        println("Do you want to play again? (Y/N)")
        when (readln().uppercase()) {
            "Y" -> return true
            "N" -> return false
            else -> println("Invalid input. Please select 'Y' or 'N.'")
        }
    }
}

fun printMaze(maze: Array<CharArray>) {
    for (row in maze) println(row.concatToString())
}
