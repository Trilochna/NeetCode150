# REFER : [link](https://github.com/Trilochna/NeetCode150/tree/main/Tries/212.%20Word%20Search%20II)

# ALGORITHM :

The provided code is an implementation of a solution for the "Word Search II" problem. This problem involves finding all valid words that can be formed by traversing adjacent letters on a 2D board, given a list of words to search for. The solution uses a Trie data structure for efficient word lookup and backtracking to explore possible word paths on the board.

Here's a detailed algorithm based on the provided code:

1. Create a class `Solution` that contains the following member variables:
   - `rows` and `columns` to store the dimensions of the board.
   - `currTrie` to keep track of the current TrieNode.
   
2. Define a method `findWords` that takes a 2D board (`board`) and an array of words (`words`) as input and returns a list of valid words found on the board.
   
3. Initialize `rows` and `columns` with the dimensions of the `board`.

4. Create an empty TrieNode `root`.

5. Iterate through each word in the `words` array and add it to the Trie using the `addWord` method, which adds each character of the word to the Trie.

6. Create two empty HashSet collections, `result` to store the found words, and `visited` to keep track of visited characters on the board.

7. Perform a nested loop through all cells on the board:
   - For each cell `(i, j)`:
     - Call the `dfsBacktrack` method to explore word paths starting from this cell, passing the board, an empty string `word`, the current TrieNode `root`, `result`, `visited`, and `root` as arguments.

8. After the loop, convert the `result` HashSet to an ArrayList and return it as the final list of found words.

9. Define the `dfsBacktrack` method, which is a recursive function to explore word paths on the board:
   - Check for the base case:
     - If the current cell `(i, j)` is out of bounds, return.
     - If the character at `(i, j)` on the board does not exist in the Trie, return.
     - If the references count for the current character in the Trie is less than 1 (meaning it has already been used), return.
     - If the cell `(i, j)` has already been visited, return.
   
   - Mark the cell `(i, j)` as visited by adding it to the `visited` set.
   
   - Update the current TrieNode to the child corresponding to the character at `(i, j)` on the board.
   
   - Append the character at `(i, j)` to the `word`.
   
   - Check if the current TrieNode represents the end of a word:
     - If yes, remove the word from the Trie by calling `root.removeWord(word)`.
     - Add the word to the `result` set since it's a valid word.

   - Recursively explore all adjacent cells:
     - Call `dfsBacktrack` for the cell below `(i + 1, j)`.
     - Call `dfsBacktrack` for the cell above `(i - 1, j)`.
     - Call `dfsBacktrack` for the cell to the right `(i, j + 1)`.
     - Call `dfsBacktrack` for the cell to the left `(i, j - 1)`.

   - Unmark the cell `(i, j)` as visited by removing it from the `visited` set.

10. Finally, define the `TrieNode` class, which represents a node in the Trie data structure:
    - It contains a `children` HashMap to store child nodes.
    - `endOfWord` is a boolean flag to indicate if a word ends at this node.
    - `refs` is an integer to count references to the node.

11. The `TrieNode` class also has two main methods:
    - `addWord` to add a word to the Trie.
    - `removeWord` to remove a word from the Trie.

This algorithm efficiently finds all valid words on the board using Trie-based word lookup and backtracking to explore possible word paths. The result is a list of unique words found on the board.
