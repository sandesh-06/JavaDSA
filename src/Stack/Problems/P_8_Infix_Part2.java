package Stack.Problems;

import java.util.Stack;

//NOTE: THE INPUT SHOULD CONTAIN ONLY SINGLE DIGIT NOS
//HERE THE INPUT MAY ALSO CONTAIN BRACKET (), WHICH HAS THE TOP MOST PRIORITY
public class P_8_Infix_Part2 {
    static int solveInfix(String str){
        //YOU'LL NEED 2 STACKS, 1 FOR STORING NUMBERS AND OTHER FOR STORING OPERATIONS
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            //if the char is a number
            if((int)ch >= 48 && (int)ch<=57){
                int n = ((int)ch - 48); //to convert the char into the number, if ch = 5; 53-48 = 5;
                num.push(n);
            }
            else if(oper.isEmpty() || ch == '(' || oper.peek() == '(') oper.push(ch);
            else if (ch == ')') {
                while(oper.peek()!='('){ //until you encounter a opening bracket perform the operations
                    int val2 = num.pop();
                    int val1 = num.pop();
                    if(oper.peek() == '+') num.push(val1 + val2);
                    else if(oper.peek() == '-') num.push(val1 - val2);
                    else if(oper.peek() == '*') num.push(val1 * val2);
                    else if(oper.peek() == '/') num.push(val1 / val2);
                    oper.pop();
                }
                //once the opening bracket is reached, pop it out
                oper.pop();
            }
            else{ //if the char is an operation
                if (ch == '+' || ch == '-'){ //doesn't matter which is at the top of stack, either it's gonna be same or higher, so perform the operation present on top first.
                    int val2 = num.pop();
                    int val1 = num.pop();
                    if(oper.peek() == '+') num.push(val1 + val2);
                    else if(oper.peek() == '-') num.push(val1 - val2);
                    else if(oper.peek() == '*') num.push(val1 * val2);
                    else if(oper.peek() == '/') num.push(val1 / val2);
                    oper.pop();
                    oper.push(ch);
                }
                else{ // ch == "*" || ch == "/"
                    if(oper.peek() == '+' || oper.peek() == '-') oper.push(ch); //if the top ch is of low priority then just push the operation
                    else{ //if top is higher or equal, perform top operation for 2 vals, and then insert the oper
                        int val2 = num.pop();
                        int val1 = num.pop();
                        if(oper.peek() == '*') num.push(val1 * val2);
                        else if(oper.peek() == '/') num.push(val1 / val2);
                        oper.pop();
                        oper.push(ch);
                    }
                }
            }
        }

        //once the for loop is over, there will still be some nums and operation left in the stack, perform the operations until you are left with 1 value in the num stack, which is our ans
        while(num.size()>1){
            int val2 = num.pop();
            int val1 = num.pop();
            if(oper.peek() == '+') num.push(val1 + val2);
            else if(oper.peek() == '-') num.push(val1 - val2);
            else if(oper.peek() == '*') num.push(val1 * val2);
            else if(oper.peek() == '/') num.push(val1 / val2);
            oper.pop();
        }

        //return the element present in the num stack, that is our ans
        return num.peek();
    }
    public static void main(String[] args) {
        String str = "(9-5+3)*4/7";
        System.out.println(solveInfix(str));
    }
}
