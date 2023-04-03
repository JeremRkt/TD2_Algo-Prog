package RadixS;

import java.io.*;
import java.util.*;

public class RadixSort {

    public static void print(int arr[], int n){
        for (int i = 0; i < n ; i++){
            System.out.println(arr[i] + "");
        }
    }

    //
    public static void radixsort(int arr[], int n){

        //Find the max to know the maximum number of digit
        int m = max(arr, n);

        // Do counting sort of every digit
        for (int exp = 1; m / exp > 0 ; exp *= 10){
            countSort(arr, n, exp);
        }
    }


    //find the maximum value from the array
    public static int max(int[]arr, int n){

        int mx = arr[0];

        for (int i = 1; i < n; i++){
            if (arr[i] > mx){
                mx = arr[i];
            }
        }
        return mx;
    }

    //Counting sort of the array according to the digit represented by exp
    public static void countSort(int []arr, int n, int exp){

        int output[] = new int[n];
        int i ;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of the occurences in count[]
        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        // Change count[i] so it contains actual position of this digit in output
        for (i = 1; i < 10; i++){
            count[i] += count[i-1];
        }

        //Build output array
        for (i = n-1; i >= 0; i--){
            output[count[(arr[i]/ exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10] --;
        }

        // Copy the output array to arr[], the array contains sorted number according to current digit
        for (i = 0; i < n ; i++){
            arr[i] = output[i];
        }
    }

}
