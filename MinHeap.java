package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MinHeap<T> {
    ArrayList<T> internHeap;
    Comparator<? super T> sammenlikner;

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>(Comparator.naturalOrder());

        minHeap.leggInn(3);
        minHeap.leggInn(5);
        minHeap.leggInn(2);
        minHeap.leggInn(7);
        minHeap.leggInn(1);
        minHeap.leggInn(2);
        System.out.println(minHeap);

        System.out.println(minHeap.hent());
        System.out.println(minHeap);
        while (!minHeap.tom()) {
            System.out.println(minHeap.hent());
        }
    }

    public String toString() {
        return internHeap.toString();
    }

    public MinHeap(Comparator<? super T> c) {
        internHeap = new ArrayList<>();
        internHeap.add(null);
        sammenlikner = c;
    }

    public int antall() {
        return internHeap.size()-1;
    }

    public boolean tom() {
        return antall() == 0;
    }

    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);
        int n = internHeap.size(); //Nyttig for å bestemme posisjonen til den nye elementet i heapen
        internHeap.add(verdi); //Legger til nye elementet 'verdi'
        if (n == 1) return true; //Hvis minHeapen var tom, så trengs det ikke å utføre sammenligningen, fordi det ene elementet er lagt til
        while (sammenlikner.compare(verdi, internHeap.get(n/2)) < 0) { //Løkker for å sette elementet på riktig plass
            T forelder = internHeap.get(n/2);                          //Betegnelsen i while sammenligner det nye elementet med sin forelder
            internHeap.set(n, forelder); //Bytter posisjon             //Hvis sammenligningen gir negativ verdi, betyr det at elementet er mindre
            internHeap.set(n/2, verdi);  //Bytter posisjon             //enn forelderen, og de bytter posisjon
            n = n/2; //Oppdaterer indeksen til å peke på nye posisjon til elementet
            if (n == 1) break; //Avslutter når elementet er på riktig plass
        }
        return true; //Indikerer at elementet er lagt til i heapen
    }

    public T kikk() {
        return internHeap.get(1);
    }

    public T hent() {
        T utVerdi = internHeap.get(1);
        int n = 1;
        if (internHeap.size() == 2) { //Håndterer et spesialtilfelle hvor det er to elementer i heapen
            internHeap.remove(1);
            return utVerdi;
        }
        internHeap.set(1, internHeap.remove(internHeap.size()-1)); //Erstatter rotelementet med det siste elementet i heapen, og fjerner siste element i heapen
        while (n < internHeap.size()/2) {
            T current = internHeap.get(n);
            T venstreBarn = internHeap.get(2*n);
            T høyreBarn = internHeap.get(2*n+1);
            if (sammenlikner.compare(current, venstreBarn) < 0
                    && sammenlikner.compare(current, høyreBarn) < 0) break;
            if (sammenlikner.compare(venstreBarn, høyreBarn) <= 0) {
                internHeap.set(n, venstreBarn);
                internHeap.set(2*n, current);
                n = 2*n;
            } else {
                internHeap.set(n, høyreBarn);
                internHeap.set(2*n+1, current);
                n = 2*n+1;
            }
        }
        return utVerdi;
    }
}