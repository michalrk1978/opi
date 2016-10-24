package OPI;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // funkcja przyjmuje dane alfanumeryczne i weryfikuje poprawność domknięcia nawiasów.
    // Zwraca true jeśli nawiasy są poprawnie podomykane, a w przeciwnym przypadku zwraca false
    // Algorytm bazuje na pojęciu stosu, chociaż ponieważ jest tylko jeden rodzaj nawiasów, to nie potrzeba tej
    // struktury danych wykorzystywać.

    static public boolean czyPoprawneNawiasy(String wyrazenie) throws IOException {
        int licznikStosu = 0;

        if(wyrazenie == null)
        {
            throw new IOException();
        }

        //pętla przechodzi przez wszystkie elementy wyrażenia i zwiększa licznik jeśli napotka nawias otwierający oraz
        //zmniejsza licznik jeśli napotka nawias zamykający. Przyjmuję, że nawias otwierający zawsze musi być przed zamykającym
        // dlatego jeśli licznik stosu uzyska wartość ujemną w trakcie działania pętli, to jest zwracany wynik fałsz
        for (int i = 0; i < wyrazenie.length(); ++i)
        {
            if(wyrazenie.charAt(i) == '(')
            {
                ++licznikStosu;
            }
            else if(wyrazenie.charAt(i) == ')')
            {
                --licznikStosu;
            }

            if(licznikStosu < 0)
            {
                return false;
            }
        }

        return licznikStosu == 0;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        try
        {
            if(czyPoprawneNawiasy(s))
            {
                System.out.println("Poprawne nawiasy");
            }
            else
            {
                System.out.println("Niepoprawne nawiasy");
            }
        }
        catch(IOException e)
        {
            System.out.println("Niepoprawny ciag znakow");
        }

    }
}
