/**
 * Clase que representa un árbol binario de búsqueda (ABB).
 * Un ABB es un tipo de árbol binario en el que para cada nodo, 
 * todos los nodos del subárbol izquierdo tienen un valor menor 
 * que el nodo y todos los nodos del subárbol derecho tienen un 
 * valor mayor que el nodo.
 */
package ejercicio12.arbolBinario;

public class ABB {
    protected Nodo raiz;

    /**
     * Constructor por defecto que inicializa la raíz del árbol como nula.
     */
    public ABB() {
        raiz = null;
    }

    /**
     * Constructor que inicializa la raíz del árbol con un valor dado.
     * @param valor El valor a asignar a la raíz del árbol.
     */
    public ABB(int valor) {
        raiz = new Nodo(valor);
    }

    /**
     * Establece la raíz del árbol.
     * @param raiz La nueva raíz del árbol.
     */
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    /**
     * Obtiene la raíz del árbol.
     * @return La raíz del árbol.
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Inserta un nuevo nodo con un valor dado en el árbol.
     * @param valorInsertar El valor a insertar en el árbol.
     */
    public void insertar(int valorInsertar) {
        if (this.raiz == null) {
            this.raiz = new Nodo(valorInsertar);
        } else {
            this.raiz = insertar(valorInsertar, this.raiz);
        }
    }

    /**
     * Método privado que inserta un nuevo nodo con un valor dado en el árbol.
     * @param valorInsertar El valor a insertar en el árbol.
     * @param nodo El nodo actual en el que se está insertando el valor.
     * @return El nodo actualizado con el nuevo valor insertado.
     */
    private Nodo insertar(int valorInsertar, Nodo nodo) {
        if (nodo.getClave() == 0) {
            nodo.setClave(valorInsertar);
        } else {
            if (nodo.getClave() > valorInsertar) {
                if (nodo.getHijoIzquierdo() == null) {
                    nodo.setHijoIzquierdo(new Nodo(valorInsertar));
                } else {
                    nodo.setHijoIzquierdo(insertar(valorInsertar, nodo.getHijoIzquierdo()));
                }
            } else if (nodo.getClave() < valorInsertar) {
                if (nodo.getHijoDerecho() == null) {
                    nodo.setHijoDerecho(new Nodo(valorInsertar));
                } else {
                    nodo.setHijoDerecho(insertar(valorInsertar, nodo.getHijoDerecho()));
                }
            }
        }
        return nodo;
    }

    /**
     * Recorre el árbol en orden y muestra los valores de los nodos.
     */
    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    /**
     * Recorre el árbol en preorden y muestra los valores de los nodos.
     */
    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    /**
     * Recorre el árbol en postorden y muestra los valores de los nodos.
     */
    public void postOrden() {
        if (raiz != null) {
            raiz.postOrden();
        }
    }
}
