package ec.edu.epn.tdd.GestorPersonal;

import org.junit.Test;

import static org.junit.Assert.*;

public class GestorPersonalTest {

    @Test
    public void given_when_them(){
        GestorPersonal g1 = new GestorPersonal();
        int expected = 6;
        int actual = g1.add(4,2);
        assertEquals(expected, actual);
    }

}