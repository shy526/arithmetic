package com.github.shy526.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapSortTest extends SortTest {

    @Test
    public void sort() {
        HeapSort.sort(testArray);
    }
}