package ec.edu.espoch.cuentabancaria.cuentas;

public class CuentaAhorros extends Cuenta {
    
    protected boolean activa; //cuenta activa por defecto
    
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = true; //operación dentro
    }
    
    @Override //sobreescribir
    public boolean consignar(float cantidad) {
        if (activa) {
            return super.consignar(cantidad);
        } else {
            System.out.println("Cuenta INACTIVA — no se puede consignar.");
            return false;
        }
    }
    
    @Override
    public boolean retirar(float cantidad) {
        if (activa) {
            return super.retirar(cantidad);
        } else {
            System.out.println("Cuenta INACTIVA — no se puede retirar.");
            return false;
        }
    }

    @Override
    public void extractoMensual() {
        if (retiros > 4) {
            comisionMensual += (retiros - 4) * 1000;
        }

        super.extractoMensual();
        activa = saldo >= 10000; // se recalcula
    }

    @Override
    public void imprimir() {
        System.out.println("=== CUENTA DE AHORROS ===");
        super.imprimir();
        System.out.println("Cuenta activa: " + activa);
        System.out.println("Transacciones totales: " + (consignaciones + retiros));
    }
    
    @Override
    public String toString() {
        return "CuentaAhorros{" + super.toString() + "activa=" + activa + '}';
    }
}
