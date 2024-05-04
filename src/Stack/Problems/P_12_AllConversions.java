package Stack.Problems;

import java.util.Stack;

public class P_12_AllConversions {
    // 1. CONVERT PREFIX TO POSTFIX
    static String convertPrefixToPostfix(String str){
        Stack<String> st = new Stack<>();

        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String val1 = st.pop();
                String val2 = st.pop();
                char operation = ch;
                String ans = val1 + val2 + operation; //to convert to postfix
                st.push(ans);
            }
        }
        return st.peek();
    }

    // 2. CONVERT POSTFIX TO PREFIX
    static String convertPostfixToPrefix(String str){
        Stack<String> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String val2 = st.pop();
                String val1 = st.pop();
                char operation = ch;
                String ans = operation + val1 + val2; //to convert to prefix
                st.push(ans);
            }
        }
        return st.peek();
    }

    /// 3. CONVERT POSTFIX TO INFIX
    static String convertPostfixToInfix(String str){
        Stack<String> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String val2 = st.pop();
                String val1 = st.pop();
                char operation = ch;
                String ans = "(" + val1 + operation + val2 + ")"; //to convert to infix
                st.push(ans);
            }
        }
        return st.peek();
    }

    /// 4. CONVERT PREFIX TO INFIX
    static String convertPrefixToInfix(String str){
        Stack<String> st = new Stack<>();

        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){
                String s = "" + ch;
                st.push(s);
            }
            else{
                String val1 = st.pop();
                String val2 = st.pop();
                char operation = ch;
                String ans = "(" + val1 + operation + val2 + ")"; //to convert to infix
                st.push(ans);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        String postfix = "953+4*6/-";
        //1
        System.out.println("1.Prefix:" + prefix + " to Postfix:" + convertPrefixToPostfix(prefix));

        //2
        System.out.println("2.Postfix:" + postfix + " to Prefix:" + convertPostfixToPrefix(postfix));

        //3
        System.out.println("3.Postfix:" + postfix + " to Infix:" + convertPostfixToInfix(postfix));

        //4
        System.out.println("4.Prefix:" + prefix + " to Infix:" + convertPrefixToInfix(prefix));
    }
}
