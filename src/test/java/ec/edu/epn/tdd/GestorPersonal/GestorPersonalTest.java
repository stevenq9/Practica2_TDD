package ec.edu.epn.tdd.GestorPersonal;

import org.junit.Test;

import static org.junit.Assert.*;

public class GestorPersonalTest {

    //Test to Develop Modify Technician Data
    @Test
    public void given_technician_name_when_check_existence_then_ok(){
        GestorPersonal g1 = new GestorPersonal();
        assertTrue(g1.comprobarExistenciaTecnico("PerezJuan"));
    }

}