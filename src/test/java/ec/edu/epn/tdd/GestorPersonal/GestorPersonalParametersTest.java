package ec.edu.epn.tdd.GestorPersonal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class GestorPersonalParametersTest {
    private String nombre, nombreE;
    private int numero, numeroE;

    //Parameters
    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"PerezJuan", 998466067});      //Modificacion
        objects.add(new Object[]{"RodriguezPedro", 98462157});  //Modificacion
        objects.add(new Object[]{"CruzMario", 97842651});       //Modificacion
        objects.add(new Object[]{"TorresManuel", 989631522});   //Modificacion
        objects.add(new Object[]{"PaezJuan", 992746822});       //Modificacion
        return objects;
    }

    //Constructor
    public GestorPersonalParametersTest(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }

    //Test with Parameters: Modify technician Data
    @Test
    public void given_parameters_when_modify_data_then_error(){
        GestorPersonal g1 = new GestorPersonal();
        //To check correct modifications
        boolean modifications [] = {false, false};
        assertArrayEquals(modifications, g1.modificarDatosTecnico(nombre,
                    numero));

    }



}