package com.example.myapplication.java.legacy;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
// definimos el contructor
    public Producto (String id,String Nombre, double precio){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;

    }
// definimos los Getters y Setters
  public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    // toString para que sea legible al imprimir [cite: 31, 40]
    @Override
    public String toString() {
        return "Producto{id='" + id + "', nombre='" + nombre + "', precio=" + precio + "}";
    }

    // equals y hashCode para que funcione en colecciones como HashSet [cite: 31, 46]
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return Double.compare(p.precio, precio) == 0 && id.equals(p.id) && nombre.equals(p.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, nombre, precio);
    }
}
