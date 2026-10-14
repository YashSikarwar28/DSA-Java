//We will take stack and keep adding the characters when we see ']' we will start popping and add the character in temp stringbuilder and then we will compute the number we will take another stringbuilder for it. After that we will run a loop in order to to add the particular string which is repated and then finally run a while loop outside and print the answer.
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder temp = new StringBuilder();
                while (st.peek() != '[') {
                    temp.append(st.pop());
                    //temp.insert(0, st.pop());
                }
                temp.reverse();
                //popping out ']'
                st.pop();
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.append(st.pop());
                    //num.insert(0, st.pop());
                }
                num.reverse();
                int n = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    repeat.append(temp);
                }
                // adding the string back to stack so that after iteration we get the answer string in stack.
                for (char c : repeat.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
            //ans.insert(0, st.pop());
        }
        return ans.reverse().toString();
    }
}

// class Solution {
//     public String decodeString(String s) {
//         Stack<Character> st = new Stack<>();
//         StringBuilder ans = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             st.add(ch);
//             if (ch == ']') {
//                 st.pop();
//                 String temp = "";
//                 while (!st.isEmpty() && st.peek() != '[') {
//                     temp += st.pop();
//                     //st.pop();
//                 }
//                 ans.append(temp);
//             }
//             if (ch - '0' >= 1 && ch - '0' <= 9) {
//                 int num = ch - '0';
//                 for (int j = 1; j <= num; j++) {
//                     ans.append(ans);
//                 }
//             }
//         }
//         return ans.reverse().toString();
//     }
// }
