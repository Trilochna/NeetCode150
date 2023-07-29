// approch of O(n)

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> brackets = new Stack<>();

        Map<Character, Character> bracketLookup = new HashMap<>();

        bracketLookup.put(')', '(');
        bracketLookup.put(']', '[');
        bracketLookup.put('}', '{');

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(bracketLookup.containsKey(c)){
                if(!brackets.isEmpty() && bracketLookup.get(c).equals(brackets.peek())){
                    brackets.pop();
                } else {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }

        return brackets.isEmpty();
    }
}

// simple approach 

// class Solution {

//     public boolean isValid(String s) {
//         if (s.length() % 2 != 0) return false;
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (
//                 stack.isEmpty() &&
//                 (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
//             ) return false; else {
//                 if (!stack.isEmpty()) {
//                     if (
//                         stack.peek() == '(' && s.charAt(i) == ')'
//                     ) stack.pop(); else if (
//                         stack.peek() == '{' && s.charAt(i) == '}'
//                     ) stack.pop(); else if (
//                         stack.peek() == '[' && s.charAt(i) == ']'
//                     ) stack.pop(); else stack.add(s.charAt(i));
//                 } else stack.add(s.charAt(i));
//             }
//         }
//         return stack.isEmpty();
//     }
// }


//=======================


// https://www.codingninjas.com/studio/problems/valid-parenthesis_795104?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0%3Fsource%3Dyoutube&campaign=Lovebabbarcodestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio


//   import java.util.*;

// public class Solution {
//     public static boolean isValidParenthesis(String expression) {
//         // Write your code here.

//         Stack<Character> s = new Stack<>();

//         for(char c : expression.toCharArray()){
//             if(c == '(' || c == '{' || c == '['){
//                 s.add(c);
//             } else {
//                 if(s.isEmpty()){
//                     return false;
//                 }
//                 if(c == ')' && s.peek() != '(' || c == '}' && s.peek() != '{' || c == ']' && s.peek() != '['){
//                     return false;
//                 }
//                 s.pop();             
//             }
//         }
//         return s.isEmpty();
//     }
// }

