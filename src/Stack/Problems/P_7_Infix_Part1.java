package Stack.Problems;

import java.util.Stack;

//ascii of '0' to '9' is 48 to 57; NOTE: NO 2 DIGITS NUMBER ARE GIVEN
//the priority of operation is (+ = - ) < ( * = / ). When same priority operations are encountered then perform operation from left to right.
public class P_7_Infix_Part1 {
    static int solveInfix(String str){
        //YOU'LL NEED 2 STACKS, 1 FOR STORING NUMBERS AND OTHER FOR STORING OPERATIONS
        Stack<Integer> num = new Stack<>();
        Stack<Character> characterStack = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            //if the char is a number
            if((int)ch >= 48 && (int)ch<=57){
                int n = ((int)ch - 48); //to convert the char into the number, if ch = 5; 53-48 = 5;
                num.push(n);
            }
            else{ //if the char is an operation
               if(characterStack.isEmpty()) characterStack.push(ch);
               else if (ch == '+' || ch == '-'){ //doesn't matter which is at the top of stack, either it's gonna be same or higher, so perform the operation present on top first.
                   int val2 = num.pop();
                   int val1 = num.pop();
                   if(characterStack.peek() == '+') num.push(val1 + val2);
                   else if(characterStack.peek() == '-') num.push(val1 - val2);
                   else if(characterStack.peek() == '*') num.push(val1 * val2);
                   else if(characterStack.peek() == '/') num.push(val1 / val2);
                   characterStack.pop();
                   characterStack.push(ch);
               }
               else{ // ch == "*" || ch == "/"
                   if(characterStack.peek() == '+' || characterStack.peek() == '-') characterStack.push(ch); //if the top ch is of low priority then just push the operation
                   else{ //if top is higher or equal, perform top operation for 2 values, and then insert the characterStack
                       int val2 = num.pop();
                       int val1 = num.pop();
                       if(characterStack.peek() == '*') num.push(val1 * val2);
                       else if(characterStack.peek() == '/') num.push(val1 / val2);
                       characterStack.pop();
                       characterStack.push(ch);
                   }
               }
            }
        }

        //once the for loop is over, there will still be some numbers and operation left in the stack, perform the operations until you are left with 1 value in the num stack, which is our ans
        while(num.size()>1){
            int val2 = num.pop();
            int val1 = num.pop();
            if(characterStack.peek() == '+') num.push(val1 + val2);
            else if(characterStack.peek() == '-') num.push(val1 - val2);
            else if(characterStack.peek() == '*') num.push(val1 * val2);
            else if(characterStack.peek() == '/') num.push(val1 / val2);
            characterStack.pop();
        }

        //return the element present in the num stack, that is our ans
        return num.peek();
    }
    public static void main(String[] args) {
        String str = "9-5+3*4/6";
        System.out.println(solveInfix(str));
    }
}
