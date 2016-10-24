/*
Rozwiązanie podobnego problemu znajduje się pod poniższym adresem internetowym
https://stackoverflow.com/questions/21176777/codility-equilibrium-index-sample-test-my-stab-at-it

 W przeciwieństwie do problemu z powyżej podanej strony internetowej zakładam, że w przedstawionym problemie
 suma lewostronna obejmuje wszystkie elementy po lewej stronie od bierzącego włącznie z bierzącym, a suma prawostronna
 wszystkie pozostałe elementy znajdujące się po prawej stronie. Zakładam, że minimalne przegięcie sumy lewostronnej nad prawostronną
 następuje dla najmniejszego indeksu kiedy suma lewostronna staje się ostro większa niż suma prawostronna
 */

package OPI;

public class Solution {

    public static int solution(int[] A)
    {
        //Domyślna wartość zwracana przez funkcję.
        int equilibrium = -1;

        // Sprawdzenie poprawności argumentów
        if (A == null || A.length <= 1)
        {
            throw new IllegalArgumentException("A");
        }
        else
        {
            long sumLeft = 0;
            long sumRight = 0;

            //Licze poczatkowa sumę prawostronną
            for (int a : A) {
                sumRight += a;
            }

            //Przechodzę przez elementy tablicy A zwiększając o bierzący element sumę lewostronną
            // i zmniejszając o ten element sumę prawostronną.
            for (int i = 0; i < A.length; i++)
            {
                sumLeft += A[i];
                sumRight -= A[i];
                if (sumLeft > sumRight)
                {
                    //Wyznaczam indeks pierwszego elementu dla którego suma lewostronna jest większa od sumy prawostronnej.
                    equilibrium = i;
                    break;
                }

            }
        }
        // Zwracam wynik
        return equilibrium;
    }

    //Test dla danych z treści zadania
    public static void main(String[] args) {

        int[] A = {1, 2, 5, 2, 1};

        System.out.println(solution(A));
    }
}
