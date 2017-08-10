package Algorithms;


//Implementation of Interpolation Search
/*
Interpolation: Estimation of an unknown quantity between two known quantities.
-Interpolation search is a modification of binary search algorithm. As in binary search we divide the array into two
 half and compare element with the middle element.

-But here in interpolation search we try to estimate the position of key in array using a formula or algorithm then
 search for key at that position. If not found then the search space is reduced appropriately and the position is
 recalculated and the process continues until the key is found or the search space is over.

-The search space is reduced to the left part of the position element or right part of the position element when key is
 not found at arr[position]

-Basically instead of dividing array into half as in BS we divide array from a particular position from where the
 element is nearer

-Interpolation search works on sorted array but will be more efficient if the array is uniformly evenly distributed

-On average the interpolation search makes about log(log(n)) comparisons (if the elements are uniformly distributed),
 where n is the number of elements to be searched. In the worst case (for instance where the numerical values of the
 keys increase exponentially) it can make up to O(n) comparisons.
 */

public class InterpolationSearch {

    //Method to implement Interpolation Search algorithm
    private int interpolationSearchImpl(int[] arr, int len, int key) {
        int low = 0;
        int high = len - 1;
        int distance,arr_range;
        double fraction;
        int index_range;
        int estimatedPos;
        int i = 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {

            distance = key - arr[low];
            arr_range = arr[high] - arr[low];
            fraction = (double)distance/(double)arr_range;
            index_range = high - low;
            estimatedPos = (int)(low + fraction * index_range);

            //The above set of statements can be squeezed into the statement below
            //estimatedPos = (int)(low + (((double)(key - arr[low]))/((double)(arr[high] - arr[low]))) * (high - low));

            System.out.println("Estimated position during iteration no "+i+" : "+estimatedPos);
            i++;

            if (arr[estimatedPos] == key) {
                return estimatedPos;
            }

            else if (key > arr[estimatedPos]) {
                low = estimatedPos + 1;
            }

            else {
                high = estimatedPos - 1;
            }
        }
        i = 0;
        return -1;
    }

    //Driver method used in testing
    public static void main(String[] args) {

        InterpolationSearch obj = new InterpolationSearch();

        int[] arr = new int[]{0,7,12,17,21,26,31,33,40,43,49,51,64,66,72,73,81,87,95,99};
        int len = arr.length;
        int key = 87;
        int result = obj.interpolationSearchImpl(arr,len,key);
        if(result == -1){
            System.out.println("Key "+key+" not found in the list");
        }
        else{
            System.out.println("Key "+key+" found at position : "+result);
        }

        System.out.println("");

        arr = new int[]{0,10,20,30,40,50,60,70,80,90,100};
        len = arr.length;
        key = 77;
        result = obj.interpolationSearchImpl(arr,len,key);
        if(result == -1){
            System.out.println("Key "+key+" not found in the list");
        }
        else{
            System.out.println("Key "+key+" found at position : "+result);
        }
    }
}
/*
Output:
Estimated position during iteration no 1 : 16
Estimated position during iteration no 2 : 17
Key 87 found at position : 17

Estimated position during iteration no 1 : 7
Key 77 not found in the list
 */
