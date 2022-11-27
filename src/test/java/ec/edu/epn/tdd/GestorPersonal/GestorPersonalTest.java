package ec.edu.epn.tdd.GestorPersonal;

import com.sun.jdi.IntegerValue;
import net.bytebuddy.description.annotation.AnnotationValue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;

import java.awt.datatransfer.MimeTypeParseException;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class GestorPersonalTest {

    GestorPersonal g1 = null;

    @BeforeClass
    public void setUp(){
        g1 = new GestorPersonal();
    }

    private static boolean[] getBooleans(boolean parameter) {
        boolean modifications [] = {parameter, parameter};
        return modifications;
    }



    //Modify Technician Data
    @Test
    //Test to check existence of a technician before modification
    public void given_technician_name_when_check_existence_then_ok(){
        assertTrue(g1.comprobarExistenciaTecnico("PerezJuan"));
    }

    //Test to check modify data of a technician
    @Test
    public void given_technician_data_when_modify_then_ok(){
        assertArrayEquals(getBooleans(true), g1.modificarDatosTecnico("PerezJuan",
                998466352));
    }

    //Test to register a new technician and then modify his data
    @Test
    public void given_technician_data_when_register_and_modify_then_ok(){
        //Registro del nevo tecnico
        assertTrue("Tecnico Registrado", g1.RegistrarTecnico("RodriguezPedro",
                999999999));
        //Modificacion de los datos del tecnico registrado
        assertArrayEquals(getBooleans(true), g1.modificarDatosTecnico("RodriguezPedro",
                998597355));
    }

    //Test to modify technician data with invalid information
    @Test()
    public void given_technician_data_when_modify_then_error(){
        //Number is not an integer parameter
        assertArrayEquals(getBooleans(true), g1.modificarDatosTecnico("PerezJuan",
                998466068));
    }



    //Test to modify information when technician doesnt exists or system cant find him
    @Test
    public void given_technician_doesnt_exists_when_modify_then_error(){
        //Number is not an integer parameter
        assertArrayEquals(getBooleans(false), g1.modificarDatosTecnico("PaezMarco",
                998466068));
    }

}