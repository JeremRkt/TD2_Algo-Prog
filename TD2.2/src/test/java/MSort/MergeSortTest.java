package MSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    public void testMergSort(){

        int[] arr = {2,5,6,8,1,9,3,7,4};
        int[] expectArr = {1,2,3,4,5,6,7,8,9};

        MergeSort.MergeSort(arr);
        assertArrayEquals(expectArr,arr);

    }
}