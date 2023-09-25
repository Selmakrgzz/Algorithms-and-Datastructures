package org.example;

public class Main {
    public static void main(String[] args){
        int[] array = {4,3,6,8,6,4,2,1,3};
        System.out.println("MergeSort:");
        MergeSort.mergeSort(array);

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }

        int[] array1 = {3,5,2,7,9,7,5,3,1,8};
        System.out.println("\nQuickSort:");
        QuickSort.quickSort(array1, 0, array1.length-1);

        for (int i = 0; i < array1.length; i++){
            System.out.print(array1[i]+ " ");
        }

        int[] array2 = {3,5,2,7,9,7,5,3,1,8};
        System.out.println("\nBubbleSort:");
        BubbleSort.bubbleSort(array2);

        for (int i = 0; i < array2.length; i++){
            System.out.print(array2[i]+ " ");
        }

        int[] array3 = {3,5,2,7,9,7,5,3,1,8};
        System.out.println("\nInsertionSort:");
        InsertionSort.insertionSort(array3);

        for (int i = 0; i < array3.length; i++){
            System.out.print(array3[i]+ " ");
        }
    }
}
