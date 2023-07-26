class Solution {
    // Define a class named "Solution" to encapsulate the Sudoku solving logic.

    public boolean isValidSudoku(char[][] board) {
        // Define a public method "isValidSudoku" that takes a 2D character array (Sudoku board) as input and returns a boolean (true if the Sudoku is valid, false otherwise).

        // A set of the characters that we have already come across (excluding '.' which denotes an empty space) in a row and column.
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        // Loop through each row (i = 0 to 8) of the Sudoku board.
        for (int i = 0; i < 9; i++) {
            // Reinitialize the row and column sets for each row, so we don't carry over found characters from the previous run.
            rowSet = new HashSet<>();
            colSet = new HashSet<>();

            // Loop through each column (j = 0 to 8) of the Sudoku board.
            for (int j = 0; j < 9; j++) {
                char r = board[i][j]; // Get the character at the i-th row and j-th column.
                char c = board[j][i]; // Get the character at the j-th row and i-th column.

                // Check if the character in the current row is not '.' (empty space).
                if (r != '.'){
                    // If the rowSet already contains the character, it means it's duplicated in the row, making the Sudoku invalid.
                    if (rowSet.contains(r)){
                        return false;
                    } else {
                        // Otherwise, add the character to the rowSet to keep track of encountered characters in this row.
                        rowSet.add(r);
                    }
                }

                // Check if the character in the current column is not '.' (empty space).
                if (c != '.'){
                    // If the colSet already contains the character, it means it's duplicated in the column, making the Sudoku invalid.
                    if (colSet.contains(c)){
                        return false;
                    } else {
                        // Otherwise, add the character to the colSet to keep track of encountered characters in this column.
                        colSet.add(c);
                    }
                }
            }
        }

        // Check the validity of each block (3x3 subgrid) of the Sudoku board.
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                // Call the "checkBlock" method to validate the current 3x3 block.
                if (!checkBlock(i, j, board)) {
                    return false; // If the block is not valid, the entire Sudoku board is not valid.
                }
            }
        }

        // If the Sudoku board passed all tests and reached this point, it is valid.
        return true;
    }

    // Define a helper method to check the validity of a 3x3 block in the Sudoku board.
    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        // Create a new set to store the characters encountered in the current 3x3 block.
        Set<Character> blockSet = new HashSet<>();

        // Calculate the ending row and column indices of the current block.
        int rows = idxI + 3;
        int cols = idxJ + 3;

        // Loop through the current 3x3 block.
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                // Check if the character in the current cell of the block is not '.' (empty space).
                if (board[i][j] == '.') {
                    continue; // If it's an empty space, skip to the next cell.
                }

                // If the blockSet already contains the character, it means it's duplicated in the block, making the block and, thus, the Sudoku invalid.
                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                // Otherwise, add the character to the blockSet to keep track of encountered characters in this block.
                blockSet.add(board[i][j]);
            }
        }

        // If all characters in the block are distinct (no duplicates), the block is valid.
        return true;
    }
}
