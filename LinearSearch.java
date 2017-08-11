package Algorithms;


//Implementation of linear search
/*
-This algorithm can be used on both sorted and unsorted arrays. This algorithm linearly searches or compares each
 element with the key and returns the index when found or else returns -1

-Time Complexity of this algorithm is O(n)
 */
public class LinearSearch {

    //Method to implement Linear Search
    public int linearSearchImpl(int[] arr, int len, int key){
        for(int i = 0; i < len; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    //Driver program to test function
    public static void main(String[] args) {
        LinearSearch obj = new LinearSearch();
        int[] arr = new int[]{1,4,2,33,12,78,45,69,87,55};
        int len = arr.length;
        int key = 55;
        int result = obj.linearSearchImpl(arr,len,key);
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
Key 55 found at position : 9
 */
