package com.company;

/**
 * Class implements minimal heap data structure pattern.
 */
public class MinimalHeap {

    /**
     * Maximum number of elements in the heap
     */
    private int free_position;

    /**
     * Storage for heap elements
     */
    private byte[] storage;

    /**
     * Initialize the heap with a given amount of bytes
     * @param size The storage of the heap will have the specified size
     */
    public void AllocTinyHeap (int size) {
        this.storage = new byte[size];
        this.free_position = 0;
    }

    /**
     * Free a memory associated to a heap
     */
    public void DeleteTinyHeap () {
        this.storage = null;
        this.free_position = 0;
    }

    /**
     * Allocates a given number of bytes on the heap if there is room
     * @param items An array to add to the current allocated storage
     */
    public void TinyAlloc (byte[] items) {
        if (this.storage.length == 0) {
            System.out.println("The heap should be initialized first.");
        } else if (this.free_position > this.storage.length || (this.free_position + items.length) > this.storage.length) {
            System.out.println("There is not enough space to allocate the specified items.");
        } else {
            for (byte item : items) {
                InsertItem(item);
            }
            AdjustHeap();
        }
    }

    /**
     * Insert an item in the storage array
     * @param item An item to add to the storage
     */
    private void InsertItem (byte item) {
        this.storage[this.free_position] = item;
        this.free_position++;
    }

    /**
     * After array storage assignment the heap should be adjusted
     */
    private void AdjustHeap() {
        for (int i = (this.free_position - 1) / 2; i >= 0; i--) {
            SortHeap(i);
        }
    }

    /**
     * Sort the heap with an ascending order
     * @param index The root index to iterate and perform sorting operations
     */
    private void SortHeap(int index){
        int left = (2 * index) + 1;
        int right = left + 1;
        int temp_index = index;
        byte temp_value;
        if (left < this.free_position && this.storage[left] < this.storage[index]) {
            temp_index = left;
        }
        if (right < this.free_position && this.storage[right] < this.storage[temp_index]) {
            temp_index = right;
        }
        if (temp_index != index) {
            temp_value = this.storage[temp_index];
            this.storage[temp_index] = this.storage[index];
            this.storage[index] = temp_value;
            SortHeap(temp_index);
        }
    }

    /**
     * Frees a specific location on the heap
     * @param position This is a position which will be removed from the storage
     */
    public void TinyFree (int position) {
        if (position < this.storage.length) {
            byte[] temp_storage = new byte[this.storage.length - 1];
            int key = 0;
            int temp_free_position = 0;
            for (int i = 0; i < this.storage.length; i++) {
                if(i != position) {
                    temp_storage[key] = this.storage[i];
                    if (this.storage[i] == 0 && temp_free_position == 0){
                        temp_free_position = key;
                    }
                    key++;
                }
            }
            this.storage = temp_storage;
            this.free_position = temp_free_position;
            AdjustHeap();
        }
    }
}
