package Algorithms;
import java.util.Arrays;
public class MergeSort {
    public static int arr[] = new int[]{12,1,6,4,15,2,3,14,13,10};
    private void merge(int[] arr, int low, int mid, int high){
        int n1,n2,i,j,p;
        n1 = mid - low + 1;
        n2 = high - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        for(i = 0; i < n1; i++){
            l[i] = arr[low + i];
        }
        for(j = 0; j < n2; j++) {
            r[j] = arr[mid + 1 + j];
        }
        i = 0;
        j = 0;
        p = low;
        while(i < n1 && j < n2){
            if(l[i] <= r[j]){
                arr[p] = l[i];
                i++;
            }
            else{
                arr[p] = r[j];
                j++;
            }
            p++;
        }
        while(i < n1){
            arr[p] = l[i];
            i++;
            p++;
        }
        while(j < n2){
            arr[p] = r[j];
            j++;
            p++;
        }
    }
    public void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr,mid+1, high);
            merge(arr,low, mid, high);
        }
    }
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        System.out.print("Before Sorting: ");
        System.out.println(Arrays.toString(arr));
        obj.mergeSort(arr,0, arr.length - 1);
        System.out.println();
        System.out.print("After Sorting:  ");
        System.out.print(Arrays.toString(arr));
    }

}
