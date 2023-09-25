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

        for (int i = 0; i < array.length; i++){
            System.out.print(array1[i]+ " ");
        }
    }
}
