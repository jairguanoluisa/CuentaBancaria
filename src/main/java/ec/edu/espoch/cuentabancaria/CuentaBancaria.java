package ec.edu.espoch.cuentabancaria;

import ec.edu.espoch.cuentabancaria.cuentas.CuentaAhorros;
import ec.edu.espoch.cuentabancaria.cuentas.CuentaCorriente;

/**
 * Integrantes:
 *  JAIR GUANOLUISA Y JHON ALCIVAR
 */
public class CuentaBancaria {

    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros(10,5);
        System.out.println(cuentaAhorros.toString());
        
        CuentaCorriente cuentaCorriente = new CuentaCorriente(10,5);
        System.out.println(cuentaCorriente.toString());
    }
}
