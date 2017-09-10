package Algorithms;

import java.util.Arrays;
public class QuickSort {
    static int arr[] = new int[]{2,12,16,9,6,14,7,3,20,11};
    private void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int partition(int[] arr, int low, int high){
        int pivot, i, j;
        pivot = arr[high];
        i = low - 1;
        for(j = low; j < high; j++){
            if(arr[j] <= pivot){
                i = i + 1;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1, high);
        return (i+1);
    }
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi;
            pi = partition(arr,low,high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();

        System.out.print("Unsorted Array: ");
        System.out.print(Arrays.toString(arr));

        obj.quickSort(arr,0, arr.length-1);

        System.out.println("\n");
        System.out.print("Sorted Array  : ");
        System.out.println(Arrays.toString(arr));
    }
}
