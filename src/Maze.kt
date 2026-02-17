/**
 * Maze Escape - Console-Based Kotlin Game
 *
 * Author: Zack Gacnik
 *
 * Description:
 * This program implements a simple console-based maze navigation game.
 * The player navigates through a predefined maze using keyboard input
 * and attempts to reach the exit while avoiding walls.
 *
 * Features:
 * - ANSI-colored console rendering
 * - Input validation
 * - Replay functionality
 * - Modular function design
 *
 * The game continues prompting the user until they choose not to replay.
 */

/**
 * Resets console text formatting to default.
 */
const val RESET = "\u001B[0m"

/**
 * ANSI escape code for red text (used for the exit).
 */
const val RED = "\u001B[31m"

/**
 * ANSI escape code for green text (used for the player).
 */
const val GREEN = "\u001B[32m"

/**
 * Main entry point of the application.
 *
 * Displays the title screen, runs the maze game,
 * and continues looping until the user declines replay.
 */
fun main() {
    do {
        showTitleScreen()
        playMazeGame()
    } while (askReplay())

    println("Thanks for playing! Goodbye!")
}

/**
 * Displays the game title and instructions.
 * Waits for the user to press ENTER before starting.
 */
fun showTitleScreen() {
    println()
    println("WELCOME TO MAZE ESCAPE!")
    println()
    println("Instructions:")
    println("Use W/A/S/D to move your player (P) through the maze.")
    println("W - move up")
    println("A - move left")
    println("S - move down")
    println("D - move right")
    println("Reach the exit (E) to win. Walls (#) block your path.")
    println("Press Q anytime to quit the current game.\n")
    println("Press ANY KEY to start...")

    // Pause execution until user presses any key.
    readln()
}

/**
 * Runs a single session of the maze game.
 *
 * The maze is represented as a 2D array of characters.
 * The player navigates the maze until they reach the exit
 * or choose to quit.
 */
fun playMazeGame() {

    // 2D character array representing the maze layout.
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

    // Track player's current position in the maze.
    var playerRow = 1
    var playerCol = 1

    // Main gameplay loop.
    while (true) {

        // Display current maze state.
        printMaze(maze)

        println("Move (W/A/S/D) or Q to quit:")
        val input = readln().uppercase()

        // Handle quit command.
        if (input == "Q") {
            println("You quit the maze.")
            break
        }

        // Determine new position based on input.
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

        // Retrieve the character at the proposed new position.
        val nextTile = maze[newRow][newCol]

        // Handle interaction based on tile type.
        when (nextTile) {

            // Wall collision.
            '#' -> println("You hit a wall!")

            // Exit reached.
            'E' -> {
                println("\nYou escaped the maze! Congratulations!")
                break
            }

            // Open path — update player position.
            ' ' -> {
                maze[playerRow][playerCol] = ' '   // Clear previous position.
                playerRow = newRow
                playerCol = newCol
                maze[playerRow][playerCol] = 'P'   // Move player.
            }
        }
    }
}

/**
 * Prompts the user to determine whether they would like to replay.
 *
 * @return true if the user selects 'Y'
 * @return false if the user selects 'N'
 */
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

/**
 * Prints the current state of the maze to the console.
 *
 * @param maze A 2D character array representing the maze layout.
 *
 * Player (P) is rendered in green.
 * Exit (E) is rendered in red.
 */
fun printMaze(maze: Array<CharArray>) {
    for (row in maze) {
        for (cell in row) {
            when (cell) {
                'P' -> print("$GREEN$cell$RESET") // Player rendered in green.
                'E' -> print("$RED$cell$RESET")   // Exit rendered in red.
                else -> print(cell)              // Walls and paths printed normally.
            }
        }
        println()
    }
}
