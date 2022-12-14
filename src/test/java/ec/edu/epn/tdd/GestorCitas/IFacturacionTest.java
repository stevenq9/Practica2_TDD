package ec.edu.epn.tdd.GestorCitas;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IFacturacionTest {
    int valor;

    @Test
    public void give_citaID_when_facturation_then_value(){
        IFacturacion f = Mockito.mock(IFacturacion.class);
        Mockito.when(f.calcularValor( "Cambio Aceite")).thenReturn(23);
        Mockito.when(f.calcularValor( "Revision Frenos")).thenReturn(15);
        Mockito.when(f.calcularValor("Cambio Pastillas")).thenReturn(20);
        Mockito.when(f.calcularValor( "Cambio Embargue")).thenReturn(55);
        Mockito.when(f.calcularValor( "Reparacion Mortor")).thenReturn(450);

        Pago p1 = new Pago();
        valor = f.calcularValor("Cambio Pastillas");
        assertEquals(f.calcularValor("Cambio Pastillas"),
                p1.solicitarValor("Cambio Pastillas"));

        p1.factura(1, "Cambio Pastillas", f.calcularValor(
                "Cambio Pastillas"),  0);
    }

    @Test
    public void give_descripcion_multa_when_facturation_then_value(){
        IFacturacion f = Mockito.mock(IFacturacion.class);
        Mockito.when(f.calcularMulta( "No retira el auto")).thenReturn(5);
        Mockito.when(f.calcularMulta( "Demora en el ingreso")).thenReturn(15);

        Pago p1 = new Pago();
        assertEquals(f.calcularMulta("Demora en el ingreso"),
                p1.solicitarValorMulta(2));

        p1.factura(1, "Cambio Pastillas", valor,
                f.calcularMulta("Demora en el ingreso"));
    }

}