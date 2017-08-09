//Implementing Binary Search Algorithm using both iterative and recursive methods

/*Using this algorithm we can find a key in an array in O(log n) in worst case because the search space is reduced to
half after each iteration.*/


/*In this algorithm we are actually reducing our search space recursively by adjusting the low and high pointers
        Now for the exit condition to our recursion can be if we find the key in the array or we exhaust the whole
        search space.
        -When this condition(low <= high) is true then we have search space
        -When the condition(low == high) is true we have only one element in the search space
        -When the below condition becomes false we have exhausted the search space completely and need to exit the
        loop*/

package Algorithms;

public class BinarySearch {

    private int BinarySearchIterative(int[] arr,int len, int key){

        int low = 0;        //low represent the starting index of the partial or complete array to search for key
        int high = len - 1;    //high represent the ending index of the partial or complete array to search for the key
        int mid;               //mid represent the center of the array

        while(low <= high){

            mid = low + ((high-low)/2);//Since (low + mid)/2 may cause an overflow issue

            if(arr[mid] == key){//The key element can be in the arr[mid] or the element is smaller or greater
                return mid;    //than arr[mid]
            }

            else if(key < arr[mid]){//If the key is smaller than arr[mid] we change the high index
                high = mid - 1;      //so for next iteration the partial array considered will be from 0 to high
            }

            else if(key > arr[mid]){//If the key is smaller than arr[mid] we change the low index
                low = mid + 1;    //so for next iteration the partial array considered will be from low to n-1
            }
        }                      //key if present in the list will be found in mid position itself after no of iterations

        return -1;      //If key is found then its position is returned else -1 is returned
    }



    //base condition for the recursion to end can be either the search space is over or the key is found in the array

    private int BinarySearchRecursive(int[] arr, int low, int high, int key){
        if(low > high){                     //base condition 1 for when no search space is left
            return -1;
        }
        else {
            int mid;
            mid = low + ((high - low) / 2); //calculating mid

            if (arr[mid] == key) {          //base condition 2 for when key is found
                return mid;
            }

            else if (key > arr[mid]) {
                return BinarySearchRecursive(arr, mid + 1, high, key);
            }

            else{
                return BinarySearchRecursive(arr, low, mid - 1, key);
            }
        }
    }





    //Driver Method for testing the iterative and recursive methods of binary search
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        int[] arr = new int[]{10,20,30,40,50,60,70,80};//Binary search algorithm works only on sorted array
        int key = 10;
        int len = arr.length;
        int iterativeResult = obj.BinarySearchIterative(arr,len,key);
        System.out.println("Using Iterative Method");
        if(iterativeResult == -1){
            System.out.println("Key "+key+" is not found in the list");
        }
        else{
            System.out.println("The key "+key+" is found at position: "+iterativeResult);
        }

        int low = 0;
        int high = len - 1;
        key = 80;
        int recursiveResult = obj.BinarySearchRecursive(arr,low,high,key);
        System.out.println("\nUsing Recursive Method");
        if(recursiveResult == -1){
            System.out.println("Key "+key+" is not found in the list");
        }
        else{
            System.out.println("The key "+key+" is found at position: "+recursiveResult);
        }
    }
}
/*Output:
Using Iterative Method
The key 10 is found at position: 0

Using Recursive Method
The key 80 is found at position: 7
 */
