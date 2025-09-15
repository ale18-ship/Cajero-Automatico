package org.cajero;

public class Usuario {
    private String nombre;
    private int id;
    private Cuenta cuenta;

    public Usuario(String nombre, int id, double saldoInicial) {
        this.nombre = nombre;
        this.id = id;
        this.cuenta = new Cuenta(saldoInicial);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
