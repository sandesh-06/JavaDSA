package Strings;

public class Strings_2_Interning_and_New {
    public static void main(String[] args) {
        //1. INTERNING:
        String str = "Hello";
        String gtr = "Hello";
        /*
            What happens here is, the string "Hello" gets stored in a Heap with a address say 'x500'.
            HEAP            STACK
          "Hello"          str - x500
           x500            gtr - x500

           both str and gtr points to the same address. THIS IS CALLED INTERNING. It is done to save space

           If suppose gtr is changed to "Mello" (gtr="Mello), then it creates a new string. In arrays if we change element in one array, then the other array will also change
           but since strings are immutable it won't change any existing string, instead a new string is created.
         */

        //2. NEW:
        String nstr = new String("Hello");
        /*
            This creates a new string "Hello" in the heap
            HEAP                STACK
           "Hello"             str - x500
            x500               gtr - x500

           "Hello"             nstr - y900
            y900
        */
    }
}
