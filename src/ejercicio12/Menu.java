package ejercicio12;

import ejercicio12.arbolBinario.ABB;
import ejercicio12.arbolBinario.Nodo;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        Scanner sc = new Scanner(System.in);
        do {
            
        } while (menu(arbol));
        System.out.println("Gracias por usar el programa");
        sc.close();
    }
    private static ABB insertar(ABB arbol) {
        Scanner sc = new Scanner(System.in);
        String condition = "S";
        String opcion = "S";
        do{

            System.out.println("Ingrese el valor del nodo a insertar");
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion)) {
                System.out.println("Error escoja un numero");
            } else {
                System.out.println("este es el numero que usted quiere ingresar: " + opcion);
                System.out.println("¿Es correcto? (S/N)");
                condition = sc.nextLine();
            }
        } while (!Validaciones.validarNumero(opcion) && (condition.equalsIgnoreCase("N")));
            int valor = Integer.parseInt(opcion);
            arbol.insertar(valor);
        return arbol;
    }
    /**
     * Función que calcula la cantidad de nodos en un nivel dado de un arbol desbalanceado recorriendolo recursivamente
     * @param nivel
     * @return
     */
    private static int cantidadNodosEnNivel(int nivel, Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else if (nivel == 0) {
            return 1;
        } else {
            return cantidadNodosEnNivel(nivel - 1, nodo.getHijoIzquierdo()) + cantidadNodosEnNivel(nivel - 1, nodo.getHijoDerecho());
        }
    }
    /**
     * Función que dice cuantos nodos hay en un nivel dado
     * @param arbol
     */
    private static void poblacionEnNivel(ABB arbol, int nivel) {
        int cantidad = cantidadNodosEnNivel(nivel, arbol.getRaiz());
        System.out.println("La cantidad de nodos en el nivel " + nivel + " es: " + cantidad);
    }
    /**
     * Función que muestra el menú principal del programa
     * @param arbol
     */
    private static boolean menu(ABB arbol) {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String opcion;
        int numero;
        int numeroOpcion ;
        System.out.println("Bienvenido al programa de árboles binarios de búsqueda");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Insertar varios nodos en el árbol");
        System.out.println("2. Dado un árbol binario de búsqueda de claves enteras, indique cual es la cantidad de nodos que hay en un nivel dado.");
        System.out.println("3. Mostrar el árbol");
        System.out.println("4. Salir");
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
                    Menu.insertar(arbol);
                    System.out.println("¿Desea ingresar otro nodo? (S/N)");
                    condition = sc.nextLine();
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
                break;
            case 3:
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
            case 4:
            System.out.println("Gracias por usar el programa");
            System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        if (numeroOpcion == 4) {
            return false;
        } else {
            return true;
        }
    }
}
