package ec.edu.epn.tdd.GestorPersonal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Array;
import java.util.Scanner;

public class GestorPersonal {
    //Atributos
    private Tecnico tecnico;
    private String nombreTecnico;
    private int numeroTecnico;

    //Scanner para lectura de datos
    Scanner lectura = new Scanner (System.in);

    //Métodos

    //Registro Personal
    public void RegistrarTecnico(){
        //Ingreso de datos del nuevo Tecnico
        System.out.println("\t Registrar Tecnico ");
        System.out.println("Ingrese el apellido del técnico:");
        nombreTecnico = lectura.next();
        System.out.println("Ingrese el nombre del técnico:");
        nombreTecnico += lectura.next();
        System.out.println("Ingrese el numero telefonico del técnico:");
        numeroTecnico = lectura.nextInt();
        tecnico = new Tecnico(nombreTecnico.toUpperCase(), numeroTecnico); //Registro del tecnico
    }

    //Eliminar Tecnico
    public void EliminarTecnico(String nombreTecnico){
        try {
            File archivo = new File("C:\\Users\\Steven\\Desktop\\PersonalConcesionario\\"
                    + nombreTecnico.toUpperCase() +".txt");
            if (archivo.delete()) {
                System.out.println("Tecnico eliminado Correctamente");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar");

        }
    }

    //Metodos para modificar
    public boolean comprobarExistenciaTecnico(String nombreTecnico){
        File archivo;
        FileReader fr;
        BufferedReader br;

        try {
            archivo = new File("C:\\Users\\Steven\\Desktop\\PersonalConcesionario\\" +
                    nombreTecnico.toUpperCase() +".txt");
            if (archivo.exists()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se encontró registros para la cita especificada");
        }
        return false;
    }

    public boolean[] modificarDatosTecnico(String nombreTecnico, int numero) {
        boolean modificaciones [] = {false, false};
        if (comprobarExistenciaTecnico(nombreTecnico)){
            modificaciones[0] = true; //El tecnico a modificar existe

            Tecnico t1 = new Tecnico(nombreTecnico, numero);
            t1.RegistrarRespaldo();
            modificaciones[1] = true; //Se modifico de manera adecuada los datos del tecnico
                                      //y se respaldo la informacion
        }
        return modificaciones;
    }


    //Menu
    public void Menu(){
        int opcion=0;
        while (opcion != 3) {

            System.out.println("---------------------------------------------------------");
            System.out.println("\t Concesionario de Autos - Gestor Personal" +
                    "\n  1.Registrar Tecnico" +
                    "\n  2.Eliminar Tecnico"+
                    "\n  3.Salir")
            ;

            Scanner lectura = new Scanner (System.in);
            System.out.print("Ingrese la opcion requerida: ");
            opcion = lectura.nextInt();
            System.out.println("---------------------------------------------------------");


            switch (opcion){
                case 1:                //Registro Tecnico
                    RegistrarTecnico();
                    tecnico.RegistrarRespaldo();
                    break;
                case 2:  //Eliminar Tecnico
                    System.out.println("Eliminar Tecnico ");
                    System.out.println("Ingrese el apellido del técnico a eliminar:");
                    nombreTecnico = lectura.next();
                    System.out.println("Ingrese el nombre del técnico a eliminar:");
                    nombreTecnico += lectura.next();
                    EliminarTecnico(nombreTecnico);
                    break;
                case 3:  //Modificar
                    System.out.println("Eliminar Tecnico ");
                    System.out.println("Ingrese el apellido del técnico a modificar:");
                    nombreTecnico = lectura.next();
                    System.out.println("Ingrese el nombre del técnico a modificar:");
                    nombreTecnico += lectura.next();
                    System.out.println("Ingrese el nuevo numero del tecnico:");
                    numeroTecnico += lectura.nextInt();
                    modificarDatosTecnico(nombreTecnico, numeroTecnico);

                    break;
                default:
                    System.out.print("Opcion no valida");
                    break;
            }
        }

    }

}
