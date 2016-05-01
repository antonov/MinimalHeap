package com.company;


import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.*;

public class MinimalHeapTest {
    private byte[] test_array = {55, 25, 44, -10, 5, 3};

    /** Allocate an array with specific number of bytes in MinimalHeap object */
    @Test
    public void testAllocTinyHeap() throws Exception {
        MinimalHeap minimalHeap = new MinimalHeap();
        minimalHeap.AllocTinyHeap(test_array.length);
        assertEquals("Heap storage length should be 6", 6, minimalHeap.getStorage().length);
    }

    /** Check that the heap storage and position pointer has been reset after method invoke */
    @Test
    public void testDeleteTinyHeap() throws Exception {
        MinimalHeap minimalHeap = new MinimalHeap();
        minimalHeap.AllocTinyHeap(test_array.length);
        minimalHeap.TinyAlloc(test_array);
        minimalHeap.DeleteTinyHeap();
        assertEquals("Heap storage should point to null", null, minimalHeap.getStorage());
        assertEquals("The current free position in heap should be 0", 0, minimalHeap.getFreePosition());
    }

    /** Check that the bytes array is allocated correctly **/
    @Test
    public void testTinyAlloc() throws Exception {
        MinimalHeap minimalHeap = new MinimalHeap();
        minimalHeap.AllocTinyHeap(25);
        minimalHeap.TinyAlloc(test_array);
        assertEquals("Heap storage length should be 25", 25, minimalHeap.getStorage().length);
        assertEquals("Allocated array length should be 6", 6, minimalHeap.getFreePosition());
        assertEquals("The first item of heap is -10", -10, minimalHeap.getStorage()[0]);
    }

    /** Check that a memory is released **/
    @Test
    public void testTinyFree() throws Exception {
        MinimalHeap minimalHeap = new MinimalHeap();
        minimalHeap.AllocTinyHeap(25);
        minimalHeap.TinyAlloc(test_array);
        minimalHeap.TinyFree(0);
        assertEquals("Heap storage length should be 24", 24, minimalHeap.getStorage().length);
        assertEquals("Allocated array length should be 5", 5, minimalHeap.getFreePosition());
        assertEquals("The first item of heap is 3", 3, minimalHeap.getStorage()[0]);
    }

}