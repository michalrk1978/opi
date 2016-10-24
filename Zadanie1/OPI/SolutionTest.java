package OPI;

import static org.junit.Assert.*;

/**
 * Created by Michal on 2016-06-16.
 */
public class SolutionTest {
    @org.junit.Test
    //Test dla przykladowych danych z zadania
    public void solutionTest1() throws Exception {
        int[] A = {1, 2, 5, 2, 1};
        assertEquals(2, Solution.solution(A));
    }

    //Sprawdzenie czy wyrzucany jest wyjątek IllegalArgumentException jeśli tablica jest null'em lub ma mniejszy rozmiar niż 2
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void solutionTest2() throws Exception {
        int[] A = {1};
        Solution.solution(A);
    }

    @org.junit.Test
    //Test dla dwuelementowej tablicy - zakładamy, że jeśli któraś z sum nie obejmuje żadnych elementów, to wynosi 0
    public void solutionTest3() throws Exception {
        int[] A = {1, 2};
        assertEquals(1,Solution.solution(A));
    }

    @org.junit.Test
    //Mozliwe sa też przypadki kiedy przegięcie sum nie istnieje - wtedy funkcja zwraca wartosc -1
    public void solutionTest4() throws Exception {
        int[] A = {0, 0};
        assertEquals(-1,Solution.solution(A));
    }
}