/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;



import javax.swing.JOptionPane;

class CuentaBanco {
  
    public String cliente;
    public  int numeroCuenta;
    public  String telefono;
    public float limite = 999999; 
    private float saldo = 0;       

    
    public CuentaBanco() {
        this.cliente = "";
        this.numeroCuenta = 0;
        this.telefono = "";
    }

   
    public float getSaldo() { 
        return saldo;
    }

    public void depositar(float monto) {
        if (monto < 0) {
            JOptionPane.showMessageDialog(null, "El monto a depositar no puede ser negativo.");
        } else if (saldo + monto > limite) {
            JOptionPane.showMessageDialog(null, "El saldo no puede superar el limite permitido de " + limite);
        } else {
            saldo += monto;
            JOptionPane.showMessageDialog(null, "Deposito realizado exitosamente. Saldo actual: " + saldo);
        }
    }

    public void retirar(float monto) { 
        if (monto < 0) {
            JOptionPane.showMessageDialog(null, "El monto a retirar no puede ser negativo.");
        } else if (saldo - monto < 0) {
            JOptionPane.showMessageDialog(null, "El saldo no puede quedar en un numero negativo.");
        } else {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente. Saldo actual: " + saldo);
        }
    }

        public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

public class CuentaBancaria {
    public static void main(String[] args) {
        CuentaBanco cuenta = new CuentaBanco();

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        cuenta.setCliente(nombre);

        String numeroCuentaStr = JOptionPane.showInputDialog("Ingrese su numero de cuenta:");
        int numeroCuenta = Integer.parseInt(numeroCuentaStr);
        cuenta.setNumeroCuenta(numeroCuenta);

        String telefono = JOptionPane.showInputDialog("Ingrese su telefono:");
        cuenta.setTelefono(telefono);

        int opcion;
        do {
           
            String menu = """
                --- Menu ---
                1. Retirar
                2. Depositar
                3. Ver saldo
                4. Salir
                Seleccione una opcion:
                """;
            String opcionStr = JOptionPane.showInputDialog(menu);
            opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1 -> {
                    String retiroStr = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                    float montoRetiro = Float.parseFloat(retiroStr);
                    cuenta.retirar(montoRetiro);
                }
                case 2 -> {
                    String depositoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                    float montoDeposito = Float.parseFloat(depositoStr);
                    cuenta.depositar(montoDeposito);
                }
                case 3 -> JOptionPane.showMessageDialog(null, "Saldo actual: " + cuenta.getSaldo());
                case 4 -> JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. Hasta pronto!");
                default -> JOptionPane.showMessageDialog(null, "Opción no valida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
}
