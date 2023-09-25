package org.example;

public class Main {
    public static void main(String[] args){
        int[] array = {4,3,6,8,6,4,2,1,3};

        MergeSort.mergeSort(array);

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }
}
