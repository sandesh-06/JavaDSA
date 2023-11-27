package Strings;

public class DistinctStringPermutation {
    static String findDistinct(String str){
        StringBuilder d_str = new StringBuilder("");
        for(int i = 0; i<str.length(); i++){
            boolean flag = false;
            for(int j = 0; j<d_str.length(); j++){
                if(str.charAt(i)==d_str.charAt(j)) flag=true;
            }
            if(!flag){
                d_str.append(str.charAt(i));
            }
        }
        return d_str.toString();
    }
    static void findPermutation(String str){
        for(int i = 0; i<str.length(); i++){
            StringBuilder p_str = new StringBuilder("" + str.charAt(i)) ;
            for(int j = 0; j<str.length(); j++){
                if(i != j){
                    p_str.append(str.charAt(j));
                }
            }
            System.out.println(p_str);
        }
    }
    public static void main(String[] args) {
        String str = "apple";
        String distinct_str = findDistinct(str);
//        System.out.println(distinct_str);
        findPermutation(distinct_str);
    }
}
