class Solution {
    // Method to check if one string is a permutation of another string
    public boolean checkInclusion(String s1, String s2) {
        // If the second string is shorter than the first one, it can't be a permutation
        if (s2.length() < s1.length()) return false;

        // Initialize an array of integers to store character frequencies
        int[] arr = new int[26];
        
        // Loop through each character in the first string (s1)
        // and increment the corresponding index in the array
        // which represents the character's frequency.
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        // Initialize two pointers, i and j, both pointing to the start of s2
        int i = 0;
        int j = 0;

        // Move the second pointer (j) to the same position as the first string's length in s2
        // and decrement the corresponding frequency in the array
        for (; j < s1.length(); j++) {
            arr[s2.charAt(j) - 'a']--;
        }

        // Move j back by one position to correct its position in the array
        j--;

        // If the array representing character frequencies is empty, return true
        if (isEmpty(arr)) return true;

        // Now we'll use a sliding window approach to check for permutations
        // Move the window (i, j) through s2 while updating the character frequencies
        while (j < s2.length()) {
            arr[s2.charAt(i) - 'a']++; // Increment the frequency of character at index i
            i++; // Move the start of the window to the right

            j++; // Move the end of the window to the right
            if (j < s2.length()) arr[s2.charAt(j) - 'a']--; // Decrement the frequency of character at index j

            // If the array representing character frequencies is empty, return true
            if (isEmpty(arr)) return true;
        }

        // If we reach this point and the array is still not empty, return false
        return isEmpty(arr);
    }

    // Helper method to check if all frequencies in the array are 0
    public boolean isEmpty(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}

