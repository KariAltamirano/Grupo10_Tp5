/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10_tp5;

import java.util.ArrayList;
import java.util.Collections;
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

    public Directorio(TreeMap<Long, Contacto> directorio, TreeSet<String> ciudades) {
        this.directorio = directorio;
        this.ciudades = ciudades;
    }

    public Directorio() {

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

    public boolean borrarContacto(Long telefono) {
        if (directorio.containsKey(telefono)) {
            directorio.remove(telefono);
            return true;
        }
        return false;
    }

    public static void mostrarContactos() {
        int i = 0;
        for (Map.Entry<Long, Contacto> entry : directorio.entrySet()) {
            System.out.println("--------------- Contacto " + (i+1) + " ---------------");
            System.out.println(entry.getValue().datosContacto());
            i++;
        }
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

    public static void precargarCiudades() {
        // Precarga de ciudades
        String[] ciudades = {"Mendoza", "San Luis", "San Juan", "Buenos Aires"};
        boolean a;

        for (String ciudad : ciudades) {
            a = Directorio.agregarCiudad(ciudad);
        }

    }
}
