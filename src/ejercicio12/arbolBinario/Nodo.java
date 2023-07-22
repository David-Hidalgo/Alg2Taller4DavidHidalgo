/**
 * Esta clase representa un nodo en un árbol binario. Contiene un valor de clave, un nodo hijo izquierdo y un nodo hijo derecho.
 */
package ejercicio12.arbolBinario;

public class Nodo {
    private int clave;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    /**
     * Constructor para un nodo con un valor de clave dado.
     * @param clave el valor de clave para el nodo.
     */
    public Nodo(int clave) {
        this.clave = clave;
        hijoIzquierdo = hijoDerecho = null;
    }

    /**
     * Constructor predeterminado para un nodo con un valor de clave de 0.
     */
    public Nodo() {
        this.clave = 0;
        hijoIzquierdo = hijoDerecho = null;
    }

    /**
     * Método getter para el valor de clave del nodo.
     * @return el valor de clave del nodo.
     */
    public int getClave() {
        return clave;
    }

    /**
     * Método setter para el valor de clave del nodo.
     * @param dato el nuevo valor de clave para el nodo.
     */
    public void setClave(int dato) {
        this.clave = dato;
    }

    /**
     * Método getter para el nodo hijo derecho.
     * @return el nodo hijo derecho.
     */
    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     * Método setter para el nodo hijo derecho.
     * @param hijoDerecho el nuevo nodo hijo derecho.
     */
    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    /**
     * Método getter para el nodo hijo izquierdo.
     * @return el nodo hijo izquierdo.
     */
    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     * Método setter para el nodo hijo izquierdo.
     * @param hijoIzquierdo el nuevo nodo hijo izquierdo.
     */
    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     * Calcula la altura del nodo.
     * @param nodo el nodo para calcular la altura.
     * @return la altura del nodo.
     */
    public int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return (1 + Math.max(altura(nodo.getHijoIzquierdo()), altura(nodo.getHijoDerecho())));
        }
    }

    /**
     * Busca un nodo con un valor de clave dado.
     * @param valorABuscar el valor de clave a buscar.
     * @return el nodo con el valor de clave dado, o null si no se encuentra.
     */
    public Nodo buscarNodo(int valorABuscar) {
        Nodo aux;
        if (this.clave == valorABuscar)
            aux = this;
        else {
            if (clave > valorABuscar)
                if (hijoIzquierdo == null)
                    return null;
                else
                    aux = this.hijoIzquierdo.buscarNodo(valorABuscar);
            else {
                if (hijoDerecho == null)
                    return null;
                else
                    aux = this.hijoDerecho.buscarNodo(valorABuscar);
            }
        }
        return aux;
    }

    /**
     * Imprime los nodos del árbol en recorrido in-order.
     */
    public void inOrden() {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.inOrden();
        }
        System.out.println(clave);
        if (hijoDerecho != null) {
            hijoDerecho.inOrden();
        }
    }

    /**
     * Imprime los nodos del árbol en recorrido pre-order.
     */
    public void preOrden() {
        System.out.println(clave);
        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrden();
        }
        if (hijoDerecho != null) {
            hijoDerecho.preOrden();
        }
    }

    /**
     * Imprime los nodos del árbol en recorrido post-order.
     */
    public void postOrden() {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.postOrden();
        }
        if (hijoDerecho != null) {
            hijoDerecho.postOrden();
        }
        System.out.println(clave);
    }
}
