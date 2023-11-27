package StringBuilder;

// input - aaabbbbccddde; output - a3b4c2d3e
public class Builder_5_String_Compression {
    public static void main(String[] args) {
        String str = "aaabbbbcdddeee";
        String ans = "" + str.charAt(0); // ans = "a"
        int count = 1; //because one character is already added to ans
        for(int i = 1; i<str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr == prev) count++;
            else{
                //only append count if it's not = 1; i.e if str = "aaabbcddee" we need ans = "a3b2cd2e2" instead of "a3b2c1d2e2"
                if(count > 1) ans += count; //ans = "a3"
                count = 1;
                ans += curr; //ans = "a3b"
            }
        }
        if(count > 1) ans+=count; //because for the last character the count is updated, but it won't be appended to ans.
        System.out.println(ans);
    }
}
