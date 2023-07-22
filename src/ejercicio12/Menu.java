package ejercicio12;

import ejercicio12.lista.ListaEnlazada;
import ejercicio12.arbolBinario.ABB;
import ejercicio12.arbolBinario.Nodo;
import java.util.Scanner;

public class Menu {
    /**
     * inicio del programa
     * 
     * @param args
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        ABB arbol = new ABB();
        Scanner sc = new Scanner(System.in);
        do {
        } while (menu(arbol, lista));
        System.out.println("Gracias por usar el programa");
        sc.close();
    }

    /**
     * Función que inserta una serie de nodos en el árbol
     * 
     * @param arbol
     * @return ABB
     */
    private static void insertar(ABB arbol, ListaEnlazada lista) {
        Scanner sc = new Scanner(System.in);
        String condition="n";
        String opcion;
        boolean bandera;
        do {
            System.out.println("Ingrese el valor del nodo a insertar");
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion)) {
                System.out.println("Error escoja un numero");
            } else {
                do  {
                    System.out.println("este es el numero que usted quiere ingresar: " + opcion);
                    System.out.println("¿Es correcto? (S/N)");
                    condition = sc.nextLine();
                    if (condition.equalsIgnoreCase("S"))
                        bandera = true;
                        else if (condition.equalsIgnoreCase("N")) {
                        bandera = true;
                    } else {
                        bandera = false;
                        System.out.println("Error escoja una opcion valida");
                    }
                    
                } while (bandera == false);
                }
        } while (!Validaciones.validarNumero(opcion) && (condition.equalsIgnoreCase("N")));
        int valor = Integer.parseInt(opcion);
        arbol.insertar(valor);
        lista.agregarAlFinal(valor);
        System.out.println("El nodo se ha insertado correctamente");
        return ;
    }

    /**
     * Función que calcula la cantidad de nodos en un nivel dado de un arbol
     * desbalanceado recorriendolo recursivamente
     * 
     * @param nivel
     * @return
     */
    private static int cantidadNodosEnNivel(int nivel, Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else if (nivel == 0) {
            return 1;
        } else {
            return cantidadNodosEnNivel(nivel - 1, nodo.getHijoIzquierdo())
                    + cantidadNodosEnNivel(nivel - 1, nodo.getHijoDerecho());
        }
    }

    /**
     * Función que dice cuantos nodos hay en un nivel dado
     * 
     * @param arbol
     */
    private static void poblacionEnNivel(ABB arbol, int nivel) {
        int cantidad = cantidadNodosEnNivel(nivel, arbol.getRaiz());
        System.out.println("La cantidad de nodos en el nivel " + nivel + " es: " + cantidad);
    }

    /**
     * Función que muestra el menú principal del programa
     * 
     * @param arbol
     */
    private static boolean menu(ABB arbol, ListaEnlazada lista) {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String opcion;
        boolean bandera;
        int numero;
        int numeroOpcion;
        System.out.println("Bienvenido al programa de árboles binarios de búsqueda");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Insertar varios nodos en el árbol");
        System.out.println("2. Dado un árbol binario de búsqueda de claves enteras, indique cual es la cantidad de nodos que hay en un nivel dado.");
        System.out.println("3. Mostrar la secuencia de nodos insertados");
        System.out.println("4. Mostrar el árbol");
        System.out.println("5. Salir");
        do {
            System.out.println("Ingrese una opción valida");
            opcion = sc.nextLine();
        } while (!Validaciones.validarNumero(opcion));
        numeroOpcion = Integer.parseInt(opcion);
        System.out.println();
        switch (numeroOpcion) {
            case 1:
                String condition;
                do {
                    Menu.insertar(arbol, lista);
                    do {
                        System.out.println("¿Desea ingresar otro nodo? (S/N)");
                        condition = sc.nextLine();
                        if (condition.equalsIgnoreCase("S"))
                            bandera = true;
                            else if (condition.equalsIgnoreCase("N")) {
                            bandera = true;
                        } else {
                            bandera = false;
                            System.out.println("Error escoja una opcion valida");
                        }
                        
                    } while (bandera == false);
                } while (condition.equalsIgnoreCase("S"));
                break;
            case 2:
                System.out.println("¿Qué nivel desea consultar?");
                do {
                    System.out.println("Ingrese una opción valida");
                    opcion = sc.nextLine();
                } while (!Validaciones.validarNumero(opcion));
                numero = Integer.parseInt(opcion);
                poblacionEnNivel(arbol, numero);
                System.out.println("Presione enter para continuar");
                sc.nextLine();
                break;
            case 3:
                System.out.println("mostrar la secuencia de nodos insertados");
                lista.imprimir();
                System.out.println("Presione enter para continuar");
                sc.nextLine();
                break;
            case 4:
                System.out.println("¿Qué recorrido desea hacer?");
                System.out.println("1. Preorden");
                System.out.println("2. Inorden");
                System.out.println("3. Postorden");
                int opcionRecorrido;
                do {
                    System.out.println("Ingrese una opción valida");
                    opcion = sc.nextLine();
                } while (!Validaciones.validarNumero(opcion));
                opcionRecorrido = Integer.parseInt(opcion);
                System.out.println();
                if (opcionRecorrido == 1)
                    arbol.preOrden();
                else if (opcionRecorrido == 2)
                    arbol.inOrden();
                else if (opcionRecorrido == 3)
                    arbol.postOrden();
                System.out.println("Presione enter para continuar");
                sc.nextLine();
                break;
            case 5:
                System.out.println("Gracias por usar el programa");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        if (numeroOpcion == 5) {
            return false;
        } else {
            return true;
        }
    }
}
