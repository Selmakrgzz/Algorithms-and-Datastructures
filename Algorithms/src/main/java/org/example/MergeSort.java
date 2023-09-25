package org.example;

public class MergeSort {
    //Denne funksjonen deler arrayet som sendes inn
    //For så å kalle Merge funksjonen som sorterer
    //og setter sammen alle de delte arrayene. Slik
    //at vår første array i utgangspunktet blir sortert
    public static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1) return; //Vi deler ikke array hvis lengde er 1 <

        int middle = length / 2; //Finner midten av arrayet
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //Index for left array
        int j = 0; //Index for right array

        //Kjører for-loop, har allerede instansiert int i = 0 difor ;
        for (; i < length; i++){
            //Her deler vi arrayet inn i left- og rightArray
            if (i < middle){ //Dersom i er mindre enn middle -> leftArray
                leftArray[i] = array[i];
            }
            else { //Dersom i er større enn middle -> rightArray
                rightArray[j] = array[i];
                j++; //Øker j for hver gang
            }
        }

        //Dette er en rekursiv funksjon. Derfor så trenger vi
        //å kalle funksjonen i seg selv i selve funksjonen.
        //Dette gjør vi for å dele arrayet.
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray,rightArray);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, l = 0, r = 0; //Indexer

        //Loopen kjører så lengde det er elementer i
        //arrayene. Så lenge l er mindre enn leftSize
        //og r er mindre enn rightSize. Det betyr at
        //det er fortsatt elementer i arrayene
        while (l < leftSize && r < rightSize){
            //Her sjekker vi om elementene i leftArray er mindre
            //enn elementene i rightArray. Dersom den er det, så
            //legger vi den til i hoved arrayet først og øker indexene
            //Samme omvendt hvis det gjelder for rightArray.
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        //Dersom det er noen elementer igjen i arrayene som
        //ikke kan sammenlignes, så kjører vi to separerte
        //løkker for hver av left- og rightArray.

        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
