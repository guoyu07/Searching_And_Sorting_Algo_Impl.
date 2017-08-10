package Algorithms;

import java.lang.*;
//Implementation of Jump Search
/*
It works only on sorted array like binary search

-In worst case the algorithm will take ((n/m) + (m-1)) comparisons.The value of the function ((n/m) + m-1) will be
minimum when m = √n. Therefore, the best step size is m = √n.
When this function ((n/m) + m-1) with m = √n is solved then the time complexity in worst case is O(√n).

-The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).

-The jump search is more effective than binary search is when we need to find the smallest element in the list the it
will take less no of jumps than binary search.So in a systems where jumping back is costly, we use Jump Search
*/
public class JumpSearch {
    private int jumpSearchImpl(int[] arr, int len, int key){
        int jumpSize = (int)Math.round(Math.sqrt(len));     //Calculating the jump size
        int currentJumpIndex = 0;
        int prevJumpIndex = 0;
        while(currentJumpIndex < len-1){                      //Index should remain within the array length
            if(arr[currentJumpIndex] == key) {
                return currentJumpIndex;
            }
            else if(arr[currentJumpIndex] < key){           //if current value is less than key then only it should jump
                prevJumpIndex = currentJumpIndex;
                currentJumpIndex = currentJumpIndex + jumpSize;
            }
            else{                                          //else we break the loop and use the prev and current index
                break;                                      //to use linear search for the given search space.
            }
        }
        for(int i = prevJumpIndex+1; i <= currentJumpIndex-1; i++){ //linear search
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    // Driver program to test function
    public static void main(String[] args) {
        JumpSearch obj = new JumpSearch();
        int[] arr = new int[]{10,20,30,30,40,50,55,60,60};
        int len = arr.length;
        int key = 60;
        int result = obj.jumpSearchImpl(arr,len,key);
        if(result == -1){
            System.out.println("Key "+key+" not found in the list");
        }
        else{
            System.out.println("Key "+key+" found at position :"+result);
        }
    }
}
/*
Output:
Key 60 found at position :7
 */
