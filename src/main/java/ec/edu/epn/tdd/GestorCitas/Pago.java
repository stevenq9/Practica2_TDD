package ec.edu.epn.tdd.GestorCitas;

import java.util.Scanner;

public class Pago {
    private CitaMecanica cita;
    private int valor;
    private int citaID;
    private String descripcion;

    Scanner lectura = new Scanner(System.in);

    //Metodo para solicitar valor
    public int solicitarValor(String descripcion){
        switch (descripcion){
            case "Cambio Aceite":
                return 23;
            case "Revision Frenos":
                return 15;
            case "Cambio Pastillas":
                return 20;
            case "Cambio Embargue":
                return 55;
            case "Reparacion Mortor":
                return 450;
        }
        return 0;
    }

    public void factura(int ID, String descripcion, int valor){
        System.out.println("-------------- FACTURA --------------");
        System.out.println("Cita ID: "+ ID);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Valor a cancelar: $" + valor);
    }

    public void solicitarDatos(){
        System.out.println("-------------- PAGO --------------");
        System.out.println("Ingrese el ID de la Cita");
        citaID = lectura.nextInt();
        System.out.println("Ingrese la descripcion");
        descripcion = lectura.next();
        valor = solicitarValor(descripcion);

        System.out.println("");


    }



}
