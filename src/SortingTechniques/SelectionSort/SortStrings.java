package SortingTechniques.SelectionSort;
//sort the strings in lexicographical order(dictionary order) using selection sort
public class SortStrings {
    static void sortFruits(String[] fruits){
        int len = fruits.length;
        int minIndex = 0;
        for(int i = 0; i<len-1; i++){
            minIndex = i;
            for(int j = i+1; j<len; j++){
                if(fruits[j].compareTo(fruits[minIndex])<0){  //compareTo return -ve if s1<s2, +ve if >, 0 if =
                   minIndex = j;
                }
            }
            //place the min element in sorted part by swapping
            String temp = fruits[i];
            fruits[i] = fruits[minIndex];
            fruits[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        String[] fruits = {"watermelon", "apple", "kiwi", "mango", "papaya"};
        sortFruits(fruits);
        for (String val: fruits) {
            System.out.print(val + " ");

        }
    }
}
