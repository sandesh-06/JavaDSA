package Stack.Problems;

import java.util.Stack;

public class P_11_PrefixAndPostfixEvaluation {
    static int evaluatePostfix(String str){
        Stack<Integer> num = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);

            if((int)ch >= 48 && (int)ch<=57){ //if the char is a number then directly push it.
                int n = (int)ch - 48;
                num.push(n);
            }
            else{ //if it's an operation, pop first 2 elements and perform the operation and push the ans
                int val2 = num.pop(); //the first popped element is val2
                int val1 = num.pop();
                if(ch == '+') num.push(val1+val2);
                else if(ch == '-') num.push(val1-val2);
                else if(ch == '*') num.push(val1*val2);
                else if(ch == '/') num.push(val1/val2);
            }
        }
        return num.peek();
    }
    static int evaluatePrefix(String str){
        Stack<Integer> num = new Stack<>();

        for(int i = str.length()-1; i>=0; i--){ //for post fix traverse the string from reverse
            char ch = str.charAt(i);

            if((int)ch >= 48 && (int)ch<=57){ //if the char is a number then directly push it.
                int n = (int)ch - 48;
                num.push(n);
            }
            else{ //if it's an operation, pop first 2 elements and perform the operation and push the ans
                int val1 = num.pop(); //the first element is val1
                int val2 = num.pop();
                if(ch == '+') num.push(val1+val2);
                else if(ch == '-') num.push(val1-val2);
                else if(ch == '*') num.push(val1*val2);
                else if(ch == '/') num.push(val1/val2);
            }
        }
        return num.peek();
    }
    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        String prefix = "-9/*+5346";

        System.out.println("The evaluation of postfix expression " + postfix + " is: " + evaluatePostfix(postfix));
        System.out.println("The evaluation of prefix expression " + prefix + " is: " + evaluatePrefix(prefix));
    }
}
