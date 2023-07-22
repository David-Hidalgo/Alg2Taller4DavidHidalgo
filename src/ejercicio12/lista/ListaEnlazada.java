/**
 * Esta clase representa una estructura de datos de lista enlazada simple.
 * Contiene métodos para agregar elementos al inicio y al final de la lista,
 * verificar si la lista está vacía, obtener el tamaño de la lista y imprimir los elementos de la lista.
 * La lista está compuesta por nodos, cada uno conteniendo un valor entero y una referencia al siguiente nodo.
 */
package ejercicio12.lista;

public class ListaEnlazada {
    private Nodo inicio;
    private int tamaño;

    /**
     * Constructor de la clase ListaEnlazada.
     * Inicializa el inicio de la lista como nulo y el tamaño como cero.
     */
    public ListaEnlazada() {
        inicio = null;
        tamaño = 0;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean estaVacia() {
        return inicio == null;
    }

    /**
     * Obtiene el tamaño de la lista.
     * @return el tamaño de la lista.
     */
    public int obtenerTamaño() {
        return tamaño;
    }

    /**
     * Agrega un nuevo nodo con el valor especificado al inicio de la lista.
     * @param valor el valor del nuevo nodo a agregar.
     */
    public void agregarAlInicio(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.prox = inicio;
        inicio = nuevoNodo;
        tamaño++;
    }

    /**
     * Agrega un nuevo nodo con el valor especificado al final de la lista.
     * @param valor el valor del nuevo nodo a agregar.
     */
    public void agregarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.prox != null) {
                actual = actual.prox;
            }
            actual.prox = nuevoNodo;
        }
        tamaño++;
    }

    /**
     * Imprime los valores de todos los nodos de la lista.
     */
    public void imprimir() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.prox;
        }
        System.out.println();
    }

    /**
     * Clase interna que representa un nodo de la lista enlazada.
     * Cada nodo contiene un valor entero y una referencia al siguiente nodo.
     */
    private class Nodo {
        int valor;
        Nodo prox;

        /**
         * Constructor de la clase Nodo.
         * @param valor el valor del nodo.
         */
        public Nodo(int valor) {
            this.valor = valor;
            prox = null;
        }
    }
}