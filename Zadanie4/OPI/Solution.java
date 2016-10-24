package OPI;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Michal on 2016-06-13.
 */
public class Solution {

    //Metoda licząca  długość maksymalnej ścieżki zstępującej, która
    //biegnie zawsze w lewo lub zawsze w prawo. Metoda ta wykorzystuje stosową implementację przechodzenia
    // drzewa binarnego w głąb (DFS). Metoda ta przy każdym umieszczaniu wskazan na dziecko lewe na stosie zwieksza
    // licznik dlugosci scieżki lewej, a jesli takie dziecko nie istnieje to zeruje licznik długości tej ścieżki.
    // Taka sama procedura jest wykonywana przy umieszczaniu dziecka prawego na stosie. Nastepnie jako bieżąca dlugość
    // maksymalnej ścieżki jest wybierana najwięksa spośród: dotychczasowej maksymalnej ścieżki, licznika długości ścieżki
    // lewej i licznika długości ścieżki prawej.

    public int solution(Tree t)
    {
        Deque<Tree> stos = new ArrayDeque<Tree>();
        Tree wezel;
        int iloscLewych = 0;
        int iloscPrawych = 0;
        int wynik = 0;
        stos.addFirst(t);                 // na stosie umieszczamy wskazanie korzenia

        while(!stos.isEmpty())
        {
            wezel = stos.removeFirst();           // pobieramy ze stosu wskazanie węzła

            // na stosie umieszczamy wskazania dzieci, jeśli istnieją

            if(wezel.r != null)
            {
                stos.addFirst(wezel.r);
                ++iloscPrawych;
            }
            else
            {
                iloscPrawych = 0;
            }

            if(wezel.l != null)
            {
                stos.addFirst(wezel.l);
                ++iloscLewych;
            }
            else
            {
                iloscLewych = 0;
            }

            wynik = Math.max(wynik, Math.max(iloscPrawych, iloscLewych));
        }

        return wynik;
    }
}
