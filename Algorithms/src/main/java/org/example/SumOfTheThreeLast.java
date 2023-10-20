package org.example;

import java.util.Arrays;

public class SumOfTheThreeLast {
    static void quickSort(int[] array, int start, int end){
        if (end <= start) return;

        int piviot = partition(array, start, end);

        //Recursive calls
        quickSort(array,start,piviot-1); //Sorting the left-side
        quickSort(array,piviot+1,end); //Sorting the right-side
    }

    static int partition(int[] array, int start, int end){
        int piviot = array[end]; //The element we are going to partition the array after
        int i = start-1; //Position of our i

        //Going through the array with the start- and endpoints
        for (int j = start; j < end; j++){
            if (array[j] < piviot){ //Checking if the element on position j are less than piviot
                i++; //Increments i, so we can switch the elements of position i and j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } //We will just move on if the element on position j are greater
        }
        //When we have gone through the whole array, we will have to place out piviot on its right position in the array
        i++; //Piviot will be placed before the element on position i
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i; //Returning the position of the piviot
    }

    public static void main(String []args){
        int[] array = {2,9,5,3,6,14,7,8};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sum of the greatest numbers: ");

        //Using a for-loop to get sum the three last numbers in the array
        for (int i = 1; i < 4; i++){
            int num = array[array.length-i];
            stringBuilder.append(num);
            if (i!=3){ //Just to avoid getting a comma on the last element when printing
                stringBuilder.append(", ");
            }
            sum+=num;
        }
        stringBuilder.append(" are ").append(sum);
        System.out.println(stringBuilder);

    }
}
