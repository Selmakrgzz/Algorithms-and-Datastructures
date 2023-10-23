package org.example;

import java.util.Arrays;

public class Eksamensoppgaver {
    public static String toString(int[] a){ //Eksamen 2014 konte
        String output = "[";
        if (a.length > 0){
            for (int i = 0; i < a.length; i++){
                output+=a[i];

                if (i!=a.length-1){
                    output+=", ";
                }
            }
        }
        output += "]";
        return output;
    }

    public static void snu(int[] a){ //Eksamen 2016 konte
        if (a.length > 0){
          int i = 0;
          int j = a.length-1;

          while (i < j){
              int temp = a[i];
              a[i] = a[j];
              a[j] = temp;
              i++;
              j--;
          }
        }
    }

    public static void frekvensFordeling(int[] a){ //Eksamen 2017
        if (a[a.length-1] < a[0]){
            throw new IllegalStateException("Arrayet er ikke sortert");
        }
        if (a.length == 0){
            System.out.println(0+" "+0);
        }

        int temp = a[0];
        int frekvens = 1;
        int i = 1;

        while (i < a.length){
            if (temp == a[i]){
                frekvens++;
            } else if (temp != a[i]){
                System.out.println(temp+" "+frekvens);
                temp = a[i];
                frekvens = 1;
            }
            i++;
        }
        System.out.println(temp+" "+frekvens);
    }

    public static int permutasjoner(int a){ //Eksamen 2020. I made it :DD
        int sum = 1;
        for (int i = 0; i < a; i++){
            sum *= 6-i;
        }
        return sum;
    }

    static void storst(int[] a){ //Eksamen 2022
        for (int i = 0; i < a.length-1; i++){
            if (a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
    }

    public static int[] snitt(int[] a, int[] b){ // Eksamen 2014 konte
        int length = Math.min(a.length, b.length);
        int[] output = new int[length];

        int antall = 0;

        for (int i = 0; i < a.length; i++){
            int verdi = a[i];
            for (int j = 0; j < b.length; j++){
                if (verdi == b[j]){
                    output[antall++] = verdi;
                }
            }
        }

        return output;
    }

    public static String fjernDublikater(int[] a){ // Eksamen 2015 Made it :DD
        int antall = 0;
        int temp = a[0];
        int[] output = new int[a.length];
        output[0] = a[0];
        int j = 1;
        for (int i = 1; i < a.length; i++){
            if (temp == a[i]){
                antall++;
                if (i != a.length-1){
                    temp = a[i-1];
                    if (temp == a[i]){
                        antall++;
                    }
                }
            } else {
                temp = a[i];
                output[j] = temp;
                j++;
            }
        }
        return "Utskrift: " +antall+ ": " +Arrays.toString(output);
    }

    public static String omorganisert(char[] a){ // Eksamen 2016
        int antall = 0;
        for (int i = 0; i < a.length-1; i++){
            for (int j = 0; j < a.length-i-1; j++){
                if (a[j] < a[j+1]){
                    char temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
            if (a[antall] > 'Z'){
                antall++;
            }
        }
        return "Utskrift: "+antall+ " :"+Arrays.toString(a);
    }

    public static int finn(int[] a, int verdi){ // Eksamen 2016 konte
        int indeks = 0;
        for (int i = 0; i < a.length; i++){
            indeks = i;
            if (a[i] == verdi){
                return indeks;
            } else {
                if (verdi < a[i]){
                    return -(indeks+1);
                }
            }
        }
        return indeks;
    }

    public static int finnMedBinarySearch(int[] a, int verdi){
        int venstre = 0;
        int hoyre = a.length-1;
        while (venstre <= hoyre){
            int m = hoyre/2;
            int midtverdi = a[m];

            if (verdi>midtverdi){
                venstre = m+1;
            } else if (verdi<midtverdi) {
                hoyre = m-1;
            } else {
                break;
            }
        }
        if (venstre > hoyre){
            return -(venstre+1);
        }

        while (venstre > 0 && a[venstre-1] == venstre){
            venstre--;
        }
        return venstre;
    }


    public static void main(String []args){
        int[] a = {};
        int[] b = {5};
        int[] c = {2,4,8,7,6,1};
        int[] d = {1,3,5,5,6,8,8,8,9,10,10};
        int[] e = {1,2,4,5,8,9};;
        int[] f = {3,5,7,8,9,6};

        System.out.println(toString(a)+ " " +toString(b)+ " " +toString(c));

        snu(c);
        System.out.println(Arrays.toString(c));

        frekvensFordeling(d);
        System.out.println(permutasjoner(6));

        storst(c);
        System.out.println(Arrays.toString(c));
        System.out.println("Snitt: "+Arrays.toString(snitt(e, f)));

        System.out.println(fjernDublikater(d));

        char[] charlist = {'d','S','l','A','B','e'};
        System.out.println(omorganisert(charlist));

        int[] temp = {2, 3, 5, 7, 10, 12, 12, 15, 18, 20};
        int num = 16;

        System.out.println(finn(temp,num));
    }
}

