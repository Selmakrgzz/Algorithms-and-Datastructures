package org.example;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        if (array.length <= 1) return;

        //Kjører dobbel for-løkker for å kunne sammenligne
        //elementene i arrayet.
        for (int i = 0; i < array.length-1; i++){
           for (int j = 0; j < array.length-i-1; j++){
               //Er elementet til venstre større enn det til høyre,
               //så bytter vi plass
               if (array[j] > array[j+1]){
                   int temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
               }
           }
        }
    }
}
