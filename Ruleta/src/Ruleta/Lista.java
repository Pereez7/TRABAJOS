package Ruleta;

import java.util.Scanner;
import java.util.Random;

public class Lista {

    Scanner teclado = new Scanner(System.in);
    Nodo primero;
    Nodo ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    public void ingresarNodo(String x) {
        Nodo nuevo = new Nodo();
        nuevo.dato = x;
        if (primero == null) {
            primero = nuevo;
            primero.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
            primero.anterior = ultimo;
        }
    }

    public void buscarNodo(String x) {
        System.out.println(x);
        System.out.println("radio" == x);
//        System.out.println("radio" == "radio");
        Nodo actual = new Nodo();
        actual = ultimo;
        boolean encontrado = false;
        do {
            if (actual.dato == x) {
                encontrado = true;
            } else {
                actual = actual.anterior;
            }
        } while (actual != ultimo && encontrado == false);

        if (encontrado == true) {
            System.out.println("\n NODO ENCONTRADO");
        } else {
            System.out.println("\n NODO NO ENCONTRADO");
        }
    }

    public void desplegar() {
        Nodo actual = new Nodo();
        actual = primero;
        int i = 1;
        do {
            System.out.println(i + " - " + actual.dato);
            actual = actual.siguiente;
            i++;
        } while (actual != primero);
    }

    public void random() {
        int max = longitud();
        int min = 1;
        if (max == 0) {
            System.out.println("No exite valor en la lista");
        } else {
            double x =(Math.random() * (max - min));
            int random = (int)Math.round(x) + 1;
            
            
            Nodo actual = new Nodo();
            actual = primero;
            int i = 1;
            do{
                if(i == random){
                    desplegar();
                    System.out.println("Posicion aleatoria: " + random + "\nDato: "+actual.dato);
                    return;
                }else{
                    actual = actual.siguiente;
                    i++;
                }              
            }
            while(actual != primero);
                
        }

    }

    public int longitud() {
        int longitud = 0;
        if (primero != null) {
            longitud++;
            Nodo actual = new Nodo();
            actual = primero;

            while (actual != ultimo) {
                longitud++;
                actual = actual.siguiente;
            }
        }

        return longitud;
    }

    public void modificarNodo(String x) {
        Nodo actual = new Nodo();
        actual = primero;
        boolean encontrado = false;
        do {
            if (actual.dato == null ? x == null : actual.dato.equals(x)) {
                System.out.println("Ingrese un nuevo premio: ");
                actual.dato = teclado.next();
            }
            actual = actual.siguiente;
        } while (actual != primero);
    }

    public void eliminarNodo(String x) {
        Nodo actual = new Nodo();
        Nodo anterior = new Nodo();
        actual = primero;
        anterior = ultimo;

        do {
            if (actual.dato == null ? x == null : actual.dato.equals(x)) {
                if (actual == primero) {
                    primero = primero.siguiente;
                    ultimo.siguiente = primero;
                    primero.anterior = ultimo;
                } else if (actual == ultimo) {
                    ultimo = anterior;
                    primero.anterior = ultimo;
                    ultimo.siguiente = primero;
                } else {
                    anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = anterior;
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != primero);
    }
}
