 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10_tp5;

/**
 *
 * @author GRUPO 10
 *
 * Altamirano Karina Gianfranco Antonacci Matías Bequis Marcos Ezequiel Dave
 * Natalia Quiroga Dorzan Alejo Franzinni Tatiana
 */
public class Contacto implements Comparable <Contacto> {

    private long dni;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;
    private long telefono;

    public Contacto(long dni, String nombre, String apellido, String ciudad, String direccion, long telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String datosContacto() {
        return "\nDNI: " + dni + "\n"
                + "Nombre: " + nombre + " " + apellido + "\n"
                + "Ciudad: " + ciudad + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n------------------------------------";
    }

    
    @Override
    public String toString() {
        return dni + " " + telefono;
    }

    @Override
    public int compareTo(Contacto t) {
          
        if (dni == t.dni){
            return 0;
        }else if (dni>t.dni){
    
            return 1;
        }else{ 
            return -1;
        }
    }
}
