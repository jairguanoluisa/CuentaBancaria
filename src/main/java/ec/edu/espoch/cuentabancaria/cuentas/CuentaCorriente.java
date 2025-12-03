package ec.edu.espoch.cuentabancaria.cuentas;

public class CuentaCorriente extends Cuenta {
    
    protected float sobregiro = 0;
    
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }
    
    @Override //sobreescribir
    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            sobregiro += (cantidad - saldo);
            saldo = 0;
        }
        retiros++;
        return true;
    }

    @Override
    public boolean consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
                return true;
            }
        }
        return super.consignar(cantidad);
    }

    @Override
    public void imprimir() {
        System.out.println("=== CUENTA CORRIENTE ===");
        super.imprimir();
        System.out.println("Sobregiro: " + sobregiro);
    }
    
    @Override
    public String toString() {
        return "CuentaCorriente{" + super.toString() + "sobregiro=" + sobregiro + '}';
    }
}