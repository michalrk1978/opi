package OPI;

import static org.junit.Assert.*;

/**
 * Created by Michal on 2016-06-13.
 */
public class SolutionTest {

    //test dla drzewa pokazanego na rysunku do zadania.
    @org.junit.Test
    public void solutionTest1() throws Exception
    {
        Tree f = new Tree(); f.l = null; f.r = null; f.x = 5;
        Tree e = new Tree(); e.l = null; e.r = null; e.x = 4;
        Tree d = new Tree(); d.l = e; d.r = f; d.x = 3;
        Tree c = new Tree(); c.l = d; c.r = null; c.x = 2;
        Tree b = new Tree(); b.l = null; b.r = null; b.x = 1;
        Tree a = new Tree(); a.l = b; a.r = c; a.x = 0;
        Solution s = new Solution();
        assertEquals(2, s.solution(a));
    }

    //test dla drzewa składającego się z samego korzenia
    @org.junit.Test
    public void solutionTest2() throws Exception
    {
        Tree a = new Tree(); a.l = null; a.r = null; a.x = 0;
        Solution s = new Solution();
        assertEquals(0, s.solution(a));
    }

    @org.junit.Test
    public void solutionTest3() throws Exception
    {
        Tree f = new Tree(); f.l = null; f.r = null; f.x = 5;
        Tree e = new Tree(); e.l = null; e.r = null; e.x = 4;
        Tree d = new Tree(); d.l = e; d.r = f; d.x = 3;
        Tree c = new Tree(); c.l = null; c.r = null; c.x = 2;
        Tree b = new Tree(); b.l = d; b.r = null; b.x = 1;
        Tree a = new Tree(); a.l = b; a.r = c; a.x = 0;
        Solution s = new Solution();
        assertEquals(3, s.solution(a));
    }

    //test sprawdzający, czy dla korzenia wynoszącego null wyrzuci wyjątek NullPointerException
    @org.junit.Test(expected = NullPointerException.class)
    public void solutionTest4() throws Exception
    {
        Tree a = null;
        Solution s = new Solution();
        s.solution(a);
    }

}