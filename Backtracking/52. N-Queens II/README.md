# [52. N-Queens II](https://leetcode.com/problems/n-queens-ii/description/)

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

![image](https://github.com/Trilochna/NeetCode150/assets/97858274/deec4623-84ab-49cf-800d-642b150cc08b)

Constraints:

1 <= n <= 9

# Solution Algorithm : 

### `totalNQueens(int n)` Function:
1. Create an empty list `allBoards` to store all possible solutions.
2. Create a 2D character array `board` of size `n x n` to represent the chessboard.
3. Call the `helper` function with the `allBoards`, `board`, and `col` set to 0 to start the recursive process.
4. Return the size of the `allBoards` list, which represents the number of solutions found.

### `helper(List<List<String>> allBoards, char[][] board, int col)` Function:
1. Check if `col` is equal to the size of the `board`, indicating that all queens have been successfully placed on the board.
   - If true, call the `saveBoard` function to save the current board configuration to `allBoards` and return.
2. Iterate through each row `row` from 0 to the size of the `board`.
   - Check if it's safe to place a queen at position `(row, col)` by calling the `isSafe` function.
   - If it's safe:
     - Place a queen ('Q') at `(row, col)` on the board.
     - Recursively call `helper` with `col + 1`.
     - If the recursive call returns and didn't find a solution, remove the queen ('Q') from `(row, col)` to backtrack and explore other possibilities.

### `isSafe(int row, int col, char[][] board)` Function:
1. Check if there is a queen ('Q') in the same row by iterating through all columns in that row. If found, return `false`.
2. Check if there is a queen ('Q') in the same column by iterating through all rows in that column. If found, return `false`.
3. Check for queens in the diagonal directions:
   - Upper left: Iterate upwards and to the left (r-1, c-1) until reaching the board boundaries, checking for queens. If found, return `false`.
   - Upper right: Iterate upwards and to the right (r-1, c+1) until reaching the board boundaries, checking for queens. If found, return `false`.
   - Lower left: Iterate downwards and to the left (r+1, c-1) until reaching the board boundaries, checking for queens. If found, return `false`.
   - Lower right: Iterate downwards and to the right (r+1, c+1) until reaching the board boundaries, checking for queens. If found, return `false`.
4. If no conflicts are found, return `true`, indicating that it's safe to place a queen at `(row, col)`.

### `saveBoard(List<List<String>> allBoards, char[][] board)` Function:
1. Create an empty list `FinalBoard` to represent the current solution.
2. Iterate through each row of the `board` and construct a string `row` to represent the current row with 'Q' for queens and '.' for empty cells.
3. Add `row` to the `FinalBoard`.
4. Add the `FinalBoard` to the `allBoards` list, representing a valid solution.

The code uses backtracking to explore all possible board configurations and checks for the validity of queen placements at each step. When a valid solution is found, it's added to the `allBoards` list, and the process continues until all possible solutions are explored. Finally, the code returns the total number of solutions found.
