package ec.edu.epn.tdd.GestorCitas;

import ec.edu.epn.tdd.GestorPersonal.GestorPersonal;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorCitasTest {
    //Modify Technician Data
    @Test
    //Test to check existence of a technician before modification
    public void given_technician_name_when_check_existence_then_ok(){
        GestorPersonal g1 = new GestorPersonal();
        assertTrue(g1.comprobarExistenciaTecnico("PerezJuan"));
    }

    //Test to check modify data of a technician
    @Test
    public void given_technician_data_when_modify_then_ok(){
        GestorPersonal g1 = new GestorPersonal();
        boolean modifications [] = {true, true};
        assertArrayEquals(modifications, g1.modificarDatosTecnico("PerezJuan",
                998466352));
    }

}