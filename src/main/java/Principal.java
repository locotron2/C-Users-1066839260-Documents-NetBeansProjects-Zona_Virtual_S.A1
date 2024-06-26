/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 1066839260
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





public class Principal {
    public static final ArrayList<Contacto> listaContactos = new ArrayList<>();
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println( "Zona Virtual S.A");
      
            System.out.println("1. Agregar un Nuevo Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja   los nombres");
            System.out.println("5. Ordenar por Inserción  números Telefónicos");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opción:");

            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarListaContactos();
                    
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    ordenarPorNombre();
                    mostrarListaContactos();
                   
                    break;
                case 5:
                    ordenarPorTelefono();
                     mostrarListaContactos();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar nuestra aplicacion");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 6.");
            }
        } while (opcion != 6);
    }

    public static void agregarContacto() {
        System.out.println("Ingrese el nombre del contacto:");
        String nombre = scan.nextLine();
        System.out.println("Ingrese el número de teléfono del contacto:");
        double telefono = scan.nextDouble();
        scan.nextLine(); 

        Contacto nuevoContacto = new Contacto(nombre, (int) telefono);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado correctamente.");
    }

    public static void mostrarListaContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("La lista de contactos está vacía.");
        } else {
            System.out.println("Lista de Contactos:");
            for (int i = 0; i < listaContactos.size(); i++) {
                Contacto contacto = listaContactos.get(i);
                System.out.println((i + 1) + ". " + contacto.getNombre() + " - " + contacto.getNumeroTelefono());
            }
        }
    }

    public static void buscarContacto() {
        System.out.println("Ingrese el nombre del contacto a buscar:");
        String nombreBuscar = scan.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                
                System.out.println("Contacto encontrado:");
                System.out.println((i + 1 )+"." +contacto.getNombre() + " - " + contacto.getNumeroTelefono());
                encontrado = true;
                
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }

    public static void ordenarPorNombre() {
       
    int n = listaContactos.size();
    for (int i = 1; i < n; ++i) {
        Contacto key = listaContactos.get(i);
        int j = i - 1;

       if(j >= 0 && listaContactos.get(j).getNombre().compareToIgnoreCase(key.getNombre()) > 0){ 
        
            listaContactos.set(j + 1, listaContactos.get(j));
            j = j - 1;
            listaContactos.set(j + 1, key);
        System.out.println("la lista esta vacia");
        }else { 
        System.out.println("Lista de nombres ordenadas");
            }
        
    } 
    }

    public static void  ordenarPorTelefono() {
        for (int i = 1; i < listaContactos.size(); i++) {
            Contacto actual = listaContactos.get(i);
            int j = i - 1;
            while (j >= 0 && listaContactos.get(j).getNumeroTelefono() > actual.getNumeroTelefono()) {
                listaContactos.set(j + 1, listaContactos.get(j));
                j--;
            }
            listaContactos.set(j + 1, actual);
        }
        System.out.println("Lista de contactos ordenada por números telefónicos (ascendente):");
        
    }
}
   //

