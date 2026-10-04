class Solution {
    public boolean checkValidString(String s) {
         // Variable to track minimum possible open brackets at current index
        int minOpen = 0;

        // Variable to track maximum possible open brackets at current index
        int maxOpen = 0;

        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {

            // Get current character
            char c = s.charAt(i);

            // If character is '(', it increases both minOpen and maxOpen
            if (c == '(') {
                minOpen++;
                maxOpen++;
            }

            // If character is ')', it decreases both minOpen and maxOpen
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }

            // If character is '*', it can be '(', ')' or ''
            else {
                  // if '*' is ')'
                minOpen--;   
                 // if '*' is '('
                maxOpen++;    
            }

            // If maxOpen becomes negative, too many closing brackets : invalid string
            if (maxOpen < 0) return false;

            // minOpen can't go below 0, as we can't have negative unmatched '('
            if (minOpen < 0) minOpen = 0;
        }

        // If minOpen is 0 at the end, it's a valid configuration
        return minOpen == 0;
    }
}