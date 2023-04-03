package MSort;


public class MergeSort {

    public static void MergeSort(int[] arr){
        int x = arr.length;
        int[] LastArray = new int[x];
        int m = 1;

        while (m < x ){
            for (int i = 0; i < x; i += 2* m){
                int left = i;
                int mid = Math.min(i+m ,x);
                int right = Math.min(i + 2*m, x);
                merge(arr, LastArray, left, mid, right);
            }
            System.arraycopy(LastArray, 0, arr,0, x);
            m *=2;
        }
    }

    public static void merge(int[]arr, int[] LastArray, int left, int mid, int right){
        int i = left;
        int j = mid;
        int k = left;
        while (i < mid && j < right){
            if (arr[i] <= arr[j]){
                LastArray[k++] = arr[i++];
            }else {
                LastArray[k++] = arr[j++];
            }
        }
        while (i < mid){
            LastArray[k++] = arr[i++];
        }
        while (j < right){
            LastArray[k++] = arr[j++];
        }
    }
}
