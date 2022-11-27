package ec.edu.epn.tdd.GestorCitas;

import ec.edu.epn.tdd.GestorPersonal.Tecnico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class GestorCitas {
    private CitaMecanica cita = new CitaMecanica();
    public static void Menu() {

        //Variables
        int opcion;

        System.out.println("---------------------------------------------------------");
        System.out.println("\t Concesionario de Autos" +
                "\n  1.Agendar Cita" +
                "\n  2.Eliminar Cita");

        Scanner lectura = new Scanner (System.in);
        opcion = lectura.nextInt();
        System.out.println("---------------------------------------------------------");

        switch (opcion){
            case 1:
                InterfazAgendar g1 = new InterfazAgendar();
                g1.InterfazAgendar();;
                break;
            case 2:
                InterfazEliminar g2 = new InterfazEliminar();
                g2.interfazEliminar();
                break;
            default:
                System.out.print("Opcion no valida");
                break;
        }
    }

    //Modificacion
    public boolean ComprobarExistencia(int citaID) {
        File archivo;
        FileReader fr;
        BufferedReader br;

        try {
            archivo = new File(cita.nombreArchivoCita(citaID));
            if (archivo.exists()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("No se encontró registros para la cita especificada");
        }

        return false;
    }

    public boolean[] modificarDatosCita(int citaID) {
        boolean modificaciones [] = {false, true};
        try {
            if (ComprobarExistencia(citaID)) {
                modificaciones[0] = true; //La cita a modificar existe

                InterfazEliminar t1 = new InterfazEliminar();
                t1.EliminarCita(citaID);
                InterfazModificar m1 = new InterfazModificar();
                m1.InterfazModificar();

                modificaciones[1] = true; //Se modifico de manera adecuada los datos de la cita
                //y se respaldo la informacion
            }else {
                System.out.println("\"Error: El registro del técnico no existe\"");
                modificaciones[0] = false; //No se encontro el respaldo de la cita
                modificaciones[1] = false; //No se modificaron los datos
            }
        }catch(Exception e){
            System.out.println("Error al modificar los datos del tecnico");
            modificaciones[0] = false;
            modificaciones[1] = false;
        }
        return modificaciones;
    }



}
