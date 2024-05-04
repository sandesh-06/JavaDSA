package Stack.Problems;

import java.util.Stack;

//Infix - "9-(5+3)*4/7"
//Prefix - "-9/*+5347"
public class P_9_InfixToPrefix {
    static String findPrefix(String str){
        Stack<String> prefix = new Stack<>();
        Stack<Character> oper = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            //if it's a number
            if((int)ch >= 48 && (int)ch <= 57){
                String s = "" + ch;
                prefix.push(s); //push it as a string, not as a char
            }
            else if(oper.isEmpty() || ch == '(' || oper.peek() == '(') oper.push(ch);
            else if(ch == ')'){
                while(oper.peek()!='('){
                    //perform operation
                    String val2 = prefix.pop();
                    String val1 = prefix.pop();
                    char operation = oper.pop();
                    String ans = operation + val1 + val2 ;
                    prefix.push(ans);
                }
                //pop the opening bracket
                oper.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    String val2 = prefix.pop();
                    String val1 = prefix.pop();
                    char operation = oper.pop();
                    String ans = operation + val1 + val2;
                    prefix.push(ans);
                    oper.push(ch);
                }
                else{ //ch == '*' || ch == '/'
                    if(oper.peek() == '+' || oper.peek() == '-') oper.push(ch);
                    else{
                        String val2 = prefix.pop();
                        String val1 = prefix.pop();
                        char operation = oper.pop();
                        String ans = operation + val1 + val2;
                        prefix.push(ans);
                        oper.push(ch);
                    }
                }
            }
        }

        while(prefix.size()>1){
            String val2 = prefix.pop();
            String val1 = prefix.pop();
            char operation = oper.pop();
            String ans = operation + val1 + val2;
            prefix.push(ans);
        }

        return prefix.peek();
    }
    public static void main(String[] args) {
        String str = "9-(5+3)*4/7";

        System.out.println("The prefix of " + str + " is: " + findPrefix(str));
    }
}
