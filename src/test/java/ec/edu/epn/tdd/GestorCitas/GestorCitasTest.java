package ec.edu.epn.tdd.GestorCitas;

import ec.edu.epn.tdd.GestorPersonal.GestorPersonal;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorCitasTest {
    //Modify Technician Data
    public void informacionPrueba(){
        int citaID = 1;
    }
    int infoprueba = 1;
    @Test
    //Test to check existence of a date before modification
    public void given_Id_date_when_check_existence_then_ok(){
        GestorCitas g1 = new GestorCitas();                // Crea una nueva instancia de la clase Gestor citas
        assertTrue(g1.ComprobarExistencia(1)); //Comprueba que la cita exista.
    }

    //Test to modify the information of the appointment with the valid information
    @Test
    public void given_date_data_when_modify_then_ok(){
        GestorCitas g1 = new GestorCitas();
        boolean modifications [] = {false, false};
        assertArrayEquals(modifications, g1.modificarDatosCita(1));
    }

    //Test to modify the information of the appointment with invalid information
    @Test
    public void given_date_data_not_exist_when_modify_then_error(){
        GestorCitas g1 = new GestorCitas();
        boolean modifications [] = {true, false};
        assertArrayEquals(modifications, g1.modificarDatosCita(12356));
    }

    //The information entered is wrong and could not be modified
    @Test
    public void given_date_data_when_modify_then_error(){
        GestorCitas g1 = new GestorCitas();
        boolean modifications [] = {false, false};
        assertArrayEquals(modifications, g1.modificarDatosCita(infoprueba));
    }
}