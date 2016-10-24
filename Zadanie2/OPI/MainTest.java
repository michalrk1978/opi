package OPI;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Michal on 2016-06-13.
 */
public class MainTest {
    @org.junit.Test
    public void sprawdzPoprawnoscNawiasowTest1() throws Exception
    {
        String s = "(a(c)";
        assertFalse(Main.czyPoprawneNawiasy(s));
    }

    @org.junit.Test
    public void sprawdzPoprawnoscNawiasowTest2() throws Exception
    {
        String s = ")b ";
        assertFalse(Main.czyPoprawneNawiasy(s));
    }

    @org.junit.Test
    public void sprawdzPoprawnoscNawiasowTest3() throws Exception
    {
        String s = "(b(s)) ";
        assertTrue(Main.czyPoprawneNawiasy(s));
    }

    //Test sprawdzający, czy zwróci fałsz jeśli nawias zamykający jest przed otwierającym
    @org.junit.Test
    public void sprawdzPoprawnoscNawiasowTest4() throws Exception
    {
        String s = "(a))b(";
        assertFalse(Main.czyPoprawneNawiasy(s));
    }

    //Test sprawdzający, czy dla nulla zwróci wyjątek IOException
    @org.junit.Test(expected = IOException.class)
    public void sprawdzPoprawnoscNawiasowTest5() throws Exception
    {
        String s = null;
        Main.czyPoprawneNawiasy(s);
    }

}