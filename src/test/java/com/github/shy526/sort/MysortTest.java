package com.github.shy526.sort;

import org.junit.Before;
import org.junit.Test;



public class MysortTest extends SortTest {

    @Test
    public void testQuickSort() {
        Mysort.quickSort(testArray,0,testArray.length-1);
    }

}