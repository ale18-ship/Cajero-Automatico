package org.cajero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        Scanner sc = new Scanner(System.in);

        cajero.agregarUsuario(new Usuario("Juan", 1, 1000));
        cajero.agregarUsuario(new Usuario("Maria", 2, 500));

        int opcion;
        do {
            System.out.println("\n=== Menú Cajero ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ID del usuario: ");
                    int idConsulta = sc.nextInt();
                    Usuario u1 = cajero.buscarUsuario(idConsulta);
                    if (u1 != null) {
                        System.out.println("Saldo de " + u1.getNombre() + ": " + u1.getCuenta().getSaldo());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingresa el ID del usuario: ");
                    int idDep = sc.nextInt();
                    Usuario u2 = cajero.buscarUsuario(idDep);
                    if (u2 != null) {
                        System.out.print("Monto a depositar: ");
                        double monto = sc.nextDouble();
                        u2.getCuenta().depositar(monto);
                        System.out.println("Depósito exitoso. Saldo actual: " + u2.getCuenta().getSaldo());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el ID del usuario: ");
                    int idRet = sc.nextInt();
                    Usuario u3 = cajero.buscarUsuario(idRet);
                    if (u3 != null) {
                        System.out.print("Monto a retirar: ");
                        double monto = sc.nextDouble();
                        if (u3.getCuenta().retirar(monto)) {
                            System.out.println("Retiro exitoso. Saldo actual: " + u3.getCuenta().getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el cajero!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}