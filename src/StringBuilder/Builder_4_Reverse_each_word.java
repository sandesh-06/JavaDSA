package StringBuilder;

//Reverse each word separately in a String.
public class Builder_4_Reverse_each_word {
    public static void main(String[] args) {
        String str = "I am an educator";
        StringBuilder temp = new StringBuilder("");
        String ans = "";

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                temp.reverse();
                ans += " " + temp;
                temp = new StringBuilder("");
            }
            else{
                temp.append(str.charAt(i));
            }
        }
//        System.out.println(temp); //the last word is present in temp, since there is no space after it, it won't perform the operation. We can just reverse it and add it to the string before printing
        temp.reverse();
        System.out.println(ans + " " + temp);
    }
}
