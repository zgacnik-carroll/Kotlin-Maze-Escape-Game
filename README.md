# Maze Escape (Kotlin Console-Based Game)

---

## Description
Maze Escape is a simple console-based maze navigation game written in Kotlin.  
The player moves through a maze using keyboard input and attempts to reach the exit while avoiding walls.

---

## How to Play

When the game starts, the maze is displayed in the console.

### Controls
- **W** — Move up
- **A** — Move left
- **S** — Move down
- **D** — Move right
- **Q** — Quit the current game

Game instructions are also provided at program runtime.

### Objective
Navigate the player (`P`) through the maze and reach the exit (`E`).

### Maze Symbols
- `P` — Player (Green)
- `E` — Exit (Red)
- `#` — Wall (cannot pass through)
- ` ` — Open path

---

## Requirements

- Kotlin 2.3.10
- Java 21.0.7
- A terminal that supports ANSI color codes

---

## How to Run

1. Clone this GitHub repository into your desired directory.
2. Navigate to your desired directory, then navigate to the source code folder:
   ```bash
   cd src/
   ```
3. Next, compile and run the program using the following command:
    ```bash
    kotlinc Maze.kt -include-runtime -d temp.jar && java -jar temp.jar && rm temp.jar
    ```
   This command compiles the Kotlin file into a temporary JAR, runs the program, and then deletes the JAR to keep the project directory clean.

   
   Now the program will be up and running! Be sure to follow the instructions on the screen

---

## Closing Remarks

This project was created to strengthen my understanding of Kotlin programming concepts through the development of an interactive console application. It provides a solid foundation for expanding into more advanced game logic and future Kotlin projects.
