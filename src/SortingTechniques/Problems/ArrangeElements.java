package SortingTechniques.Problems;
/* arrange the arr = {19, -20, 7, -4, -13, 11, -5, 3} in such a way that all the negative nos are to the left
   and all the positive nos are to the right. NOTE: THE ARRAY NEED NOT BE SORTED, JUST SATISFY THE CONDITION*/
public class ArrangeElements {

    /* LOGIC: We are gonna use quick sort for this problem(quite obvious)
           Take the pivot element(imaginary) as 0
           so that all the elements <0 can be moved to left
           and elements >0 moved to the right. LETS GO!*/
    static void arrangeElements(int[] arr){
       int pivotElement = 0;

       //traverse the array:
        int i = 0, j = arr.length-1;
        while(i<j){
            while(arr[i]<0) i++;
            while(arr[j]>=0) j--;
            if(arr[i]>0 && arr[j]<=0){
                //swap them:
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }


    }
    public static void main(String[] args) {   //-5 -20 7 -4 -13 11 19 3
        int[] arr = {19, -20, 7, -4, -13, 11, 0, -5, 3};
        arrangeElements(arr);
        for(int val: arr){
            System.out.print(val + " ");
        }
    }
}
