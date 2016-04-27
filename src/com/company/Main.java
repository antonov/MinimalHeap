package com.company;

public class Main {

    public static void main(String[] args) {
        MinimalHeap minimalHeap = new MinimalHeap();
        minimalHeap.AllocTinyHeap(25);
        byte[] test_array = {55, 25, 44, -10, 5, 3};
        minimalHeap.TinyAlloc(test_array);

        minimalHeap.TinyFree(0);
        minimalHeap.TinyFree(1);
        minimalHeap.TinyFree(3);

        minimalHeap.DeleteTinyHeap();
    }
}
