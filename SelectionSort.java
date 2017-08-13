package Algorithms;
//Implementation of Selection Sort
/*
-The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
 from unsorted part and putting it at the beginning. The algorithm maintains two sub arrays in a given array.

 1) The sub array which is already sorted.
 2) Remaining sub array which is unsorted.

-In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted sub array is
 picked and moved to the sorted sub array.


-Time Complexity is O(n^2) and is explained in the code below
 */

public class SelectionSort {

    //Method to swap two numbers in an array
    private void swap(int[] arr,int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    //Method that implements the Selection Sort
    private int[] selectionSortImpl(int[] arr, int len){
        int min;

        //passes
        for(int i = 0; i < len-1; i++){ //The condition is < len-1 since the last element need not be compared as it is
            min = arr[i];               //already sorted
            //comparisons
            for(int j = i+1; j < len; j++){
                if(arr[j] < min){
                    min = arr[j];
                    swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    //Driver method for testing
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int[] arr = new int[]{54,16,87,95,12,30,47,78,14,3};
        int len = arr.length;
        System.out.println("Array before sorting : ");
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("\n");

        arr = obj.selectionSortImpl(arr,len);
        System.out.println("Array after sorting : ");
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/*
Output:
Array before sorting :
54 16 87 95 12 30 47 78 14 3

Array after sorting :
3 12 14 16 30 47 54 78 87 95
*/

/*
Analysis:
To sort n elements, selection sort performs n - 1 passes:
on 1 st pass, it performs n - 1 comparisons to find indexSmallest
on 2 nd pass, it performs n - 2 comparisons
...
on the (n-1) st pass, it performs 1 comparison
&bull; Adding up the comparisons for each pass, we get:
C(n) = 1 + 2 + ... + (n - 2) + (n - 1)


The resulting formula for C(n) is the sum of an arithmetic
sequence:
                                        n-1
C(n) = 1 + 2 + ... + (n - 2) + (n - 1) = ∑  i
                                        i=1


Formula for the sum of this type of arithmetic sequence:

            m
            ∑  i = m(m + 1)/2
           i=1

Thus, we can simplify our expression for C(n) as follows:

C(n) = (n - 1)((n - 1)+ 1) / 2;
     = (n-1)n /2;

C(n) = n^2/2 - n/2

we’ll focus on the largest term in its operation-count expression.
• for selection sort, C(n) = n^2/2 - n/2 =  n^2/2

In addition, we’ll typically ignore the coefficient of the largest term
    (n^2)/2 ==> (n^2)  [Co-efficient here is 1/2]

We specify the largest term using big-O notation.
 we say that C(n) = n^2/2 - n/2 is O (n^2)
 */
