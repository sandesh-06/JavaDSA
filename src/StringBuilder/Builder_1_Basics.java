package StringBuilder;

public class Builder_1_Basics {
    public static void main(String[] args) {
        // Since strings are immutable and not that efficient, we have String Builder to overcome the problem.
        StringBuilder str = new StringBuilder("Hello");

        //1. append() - you can append any value with any data type
//        str+="world";//this is not allowed, instead
        str.append("world");
        System.out.println(str);

        //2. setCharAt(idx, char) - we saw that in strings we cant directly update a character. But using SB we can
        str.setCharAt(0, 'M');
        System.out.println(str);

        //3. insert(idx, ch) and deleteCharAt(idx)
        //we can insert a char at any index, and the length gets increased by 1
        str.insert(1, 'a');
        System.out.println(str);

        //we can also delete a char at any index
        str.deleteCharAt(1);
        System.out.println(str);

        //4.reverse() and delete(i, j)
        StringBuilder str1 = new StringBuilder("Sandesh");
        System.out.println(str1.reverse()); //reverses the string

        System.out.println(str1.delete(0, 3)); //deletes the string from idx 0 to 2

        //5. substring() - same as in strings




    }
}
