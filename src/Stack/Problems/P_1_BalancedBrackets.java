package Stack.Problems;

import java.util.Scanner;
import java.util.Stack;

// '()(()())' - balanced ; '(())(()' - not balanced
public class P_1_BalancedBrackets {
    static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);

            else{ //the closing brackets
                if(st.isEmpty()) return false;
                if(ch == ')' && st.peek()!='(') return false;
                if(ch == ']' && st.peek()!='[') return false;
                if(ch == '}' && st.peek()!='{') return false;
                st.pop();
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //input the brackets

        for(int i = 0; i < str.length(); i++){
            //1. If you encounter an '(' just push it to stack
            if(str.charAt(i) == '(') st.push('(');

            //2. If you encounter an ')' and if stack is empty just return false;
            else if(str.charAt(i) == ')' && st.isEmpty()){
                System.out.println("False");
                break;
            }

            //3. If you encounter an ')' and if the top has '(', pop '('.
            else if(str.charAt(i) == ')' && st.peek() == '('){
                st.pop();
            }
        }

        //4. Check if stack is empty. If empty then the brackets are balanced or not.
        if(st.empty()){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

        //WRITING IT IN A FUNCTION IS MORE BETTER WAY
        System.out.println("Answer using the isBalanced function: " + isBalanced(str));
    }
}
