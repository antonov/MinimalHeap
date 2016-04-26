package com.company;

import java.util.ArrayList;

/**
 * Class implements minimal heap data structure pattern.
 */
public class MinimalHeap {

    /**
     * Maximum number of elements in the heap
     */
    private int position;

    /**
     * Storage for heap elements
     */
    private byte[] storage;

    /**
     * Initialize the heap with a given amount of bytes
     * @param size
     */
    public void AllocTinyHeap (int size) {
        this.storage = new byte[size];
        this.position = 0;
    }

    /**
     * Free a memory associated to a heap
     */
    public void DeleteTinyHeap () {
        this.storage = null;
    }

    /**
     * Allocates a given number of bytes on the heap if there is room
     * @param items
     */
    public void TinyAlloc (byte[] items) {
        if (this.position < this.storage.length && this.position < items.length) {
            for (byte item : items) {
                InsertItem(item);
            }
        }
    }
    
    private void InsertItem (byte item) {
        this.storage[this.position] = item;
        this.position++;
    }

    public void TinyFree (int position) {
        if (position < this.storage.length) {
            this.storage[position] = 0;
        }
    }

    private void
}
