
package Ruleta;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args){
        Lista obj = new Lista();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("\n\n  LISTAS CIRCULAR DOBLE");
            System.out.println("1. Ingresar Nodo");
            System.out.println("2. Buscar Nodo");
            System.out.println("3. Modificar Nodo");
            System.out.println("4. ELiminar Nodo");
            System.out.println("5. Desplegar Lista");
            System.out.println("6. Elegir al azar");
            System.out.println("7. Salir del programa");
            System.out.println("Elija una opción: ");
            
            opcion = teclado.nextInt();
           
            switch(opcion){
                case 1: 
                    System.out.println("\n\n INGRESAR NODO");
                    System.out.println("Ingrese el dato del nodo: ");
                    String dato = teclado.next();
                    obj.ingresarNodo(dato);
                    break;
                    
                case 2: 
                    System.out.println("\n BUSCAR NODO");
                    System.out.println("Ingrese el dato del nodo a buscar: ");
                    dato = teclado.next();
                    System.out.println("radio" == dato);
                    obj.buscarNodo(dato.trim());
                    break;
                    
                case 3: 
                    System.out.println("\n MODIFICAR NODO");
                    System.out.println("Ingrese el dato del nodo a modificar: ");
                    dato = teclado.next();
                    obj.modificarNodo(dato);
                    break;
                
                case 4: 
                    System.out.println("\n ELIMINAR NODO");
                    System.out.println("Ingrese el dato del nodo a eliminar: ");
                    dato = teclado.next();
                    obj.eliminarNodo(dato);
                    break;
                    
                case 5: 
                    System.out.println("\n LISTA DE NODOS");  
                    obj.desplegar();
                    break;
                
                case 6: 
                    obj.random();
                    break;
                    
                case 7:
                    System.out.println("PROGRAMA FINALIZADO...");
                    break;
                    
                    default:
                        System.out.println("OPCION NO VALIDA");
            }
            
        }while(opcion != 7);
    }
    
}
