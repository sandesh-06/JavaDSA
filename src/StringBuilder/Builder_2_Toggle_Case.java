package StringBuilder;
//Toggle the case of character in a string. from upper to lower or vice versa

//ascii: a - 97, A - 65, 0 - 48;
// diff betw a & A is : 32. so diff btw a letter and it's caps is 32
public class Builder_2_Toggle_Case {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("sAnDeSh0 9GreaT");
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i); // 's'
            int ascii = (int)ch; //convert into ascii value
            System.out.println(ch + " " + ascii);
            if(ch == ' ' || (ascii >= 48 && ascii <= 57)) continue;
            boolean flag = true; // considering it's a capital letter
            if(ascii>=97) flag = false;
            if(flag){
                ascii += 32; //if its a capital value, add 32 to make it it's respective lowercase value
                char n = (char)ascii;
                str.setCharAt(i, n);
            }
            else{
                ascii -= 32; //if its a lowercase value, sub 32 to make it it's respective uppercase value
                char n = (char)ascii;
                str.setCharAt(i, n);
            }
        }
        System.out.println(str);
    }
}
