/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10_tp5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author GRUPO 10
 *
 * Altamirano Karina Gianfranco Antonacci Matías Bequis Marcos Ezequiel Dave
 * Natalia Quiroga Dorzan Alejo Franzinni Tatiana
 */
public class Directorio {

    private static TreeMap<Long, Contacto> directorio = new TreeMap<>();
    private static TreeSet<String> ciudades = new TreeSet<>();
    private static TreeSet<String> apellidos = new TreeSet<>();

    public Directorio(TreeMap<Long, Contacto> directorio, TreeSet<String> ciudades, TreeSet<String> apellidos) {
        this.directorio = directorio;
        this.ciudades = ciudades;
        this.apellidos = apellidos;
    }

    public Directorio() {

    }

    public static void preCargarContactos() {
        Directorio.agregarContacto(2664795210L, (new Contacto(35698741L, "Agustina", "Paez", "San Luis", "Santa Fe 23", 2664795210L)));
        Directorio.agregarContacto(2664258969L, (new Contacto(33214569L, "Carlos", "Oviedo", "San Luis", "San Juan 123", 2664258969L)));
    }

    public static boolean agregarContacto(Long telefono, Contacto contacto) {
        if (directorio.containsKey(telefono)) {
            return false;
        }
        contacto.setTelefono(telefono);
        directorio.put(telefono, contacto);
        ciudades.add(contacto.getCiudad());
        return true;
    }

    public Contacto buscarContacto(Long telefono) {
        return directorio.get(telefono);
    }

    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> telefonos = new TreeSet<>();

        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            if (entry.getValue().getApellido().equalsIgnoreCase(apellido)) {
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }

    public ArrayList<Contacto> buscarContactos(String ciudad) {
        ArrayList<Contacto> contactos = new ArrayList<>();

        for (Contacto contacto : directorio.values()) {
            if (contacto.getCiudad().equalsIgnoreCase(ciudad)) {
                contactos.add(contacto);
            }
        }
        return contactos;
    }

    public static boolean borrarContacto(Long telefono) {
        if (directorio.containsKey(telefono)) {
            directorio.remove(telefono);
            return true;
        }
        return false;
    }

    public static void mostrarContactos() {
        int i = 0;
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            System.out.println("--------------- Contacto " + (i + 1) + " ---------------");
            System.out.println(entry.getValue().datosContacto());
            i++;
        }
    }

    public static Contacto borrarCliente(long dni) {
        Iterator<Contacto> it = directorio.values().iterator();

        while (it.hasNext()) {
            Contacto c = it.next();
            if (c.getDni() == dni) {
                it.remove(); // elimina de forma segura durante la iteración
                return c; // devuelve el contacto eliminado
            }
        }
        return null; // si no se encuentra
    }

    public static Collection<Contacto> getTodosLosContactos() {
        return directorio.values();
    }

    // Agregar ciudad
    public static boolean agregarCiudad(String ciudad) {
        return ciudades.add(ciudad); // devuelve false si ya existía
    }

    // Saber si existe una ciudad
    public static boolean existeCiudad(String ciudad) {
        return ciudades.contains(ciudad);
    }

    // Obtener todas las ciudades 
    public static Set<String> obtenerCiudades() {
        return Collections.unmodifiableSet(ciudades);
    }

    // isEmpty
    public static boolean ciudadesEstaVacio() {
        return ciudades.isEmpty();
    }

    public static void preCargarCiudades() {
        // Precarga de ciudades
        String[] ciudades = {"Mendoza", "San Luis", "San Juan", "Buenos Aires"};
        boolean a;

        for (String ciudad : ciudades) {
            a = Directorio.agregarCiudad(ciudad);
        }

    }

    public static Contacto buscarPorApellido(String apellido) {

        for (Contacto c : directorio.values()) {
            if (c.getApellido().equalsIgnoreCase(apellido)) {
                return c;
            }
        }
        return null;
    }
    
    public static int sizeMap(){
        return directorio.size();
    }

}
