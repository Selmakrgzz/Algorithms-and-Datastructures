package org.example;

public class QuickSort {
    public static void quickSort(int[] array, int start, int end){
        //Sluttbeslutning
        if (end <= start) return;

        //Er det elementet vi skal sortere i forhold til i arrayet
        int piviot = partition(array,start,end);

        //Starter der vår venstre del starter, og slutter
        //der vår venstre del slutter
        quickSort(array,start,piviot-1);
        //Starter der vår høyre del starter, og slutter
        //der vår høyre del slutter
        quickSort(array,piviot+1,end);
    }

    public static int partition(int[] array, int start, int end){
        //Velger slik at piviot blir det bakerste elementet i arrayet
        int piviot = array[end];
        int i = start - 1;

        //Kjører gjennom arrayet utenom piviot
        for (int j = start; j < end - 1 ; j++){

            //Sjekker om elementet er mindre enn piviot
            //og bytter om dersom det stemmer
            if (array[j] < piviot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //Etter at elementene er delt riktig i forhold til piviot,
        //så flytter vi piviot til sin riktig sted i arrayet
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        //Returnerer posisjonen til piviot
        return i;
    }
}
