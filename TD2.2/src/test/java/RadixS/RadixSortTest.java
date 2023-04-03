package RadixS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @Test
    public void testRadixSort(){

        int arr[] = {360, 7, 182, 74, 395};
        int expectedArr[] = {7, 74, 182, 360, 395};
        int n = arr.length;
        RadixSort.radixsort(arr, n);

        assertArrayEquals(expectedArr,arr);
    }

}