package ejercicio12.arbolBinario;

public class Nodo {
    private int clave;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(int clave) {
        this.clave = clave;
        hijoIzquierdo = hijoDerecho = null;
    }

    public Nodo() {
        this.clave = 0;
        hijoIzquierdo = hijoDerecho = null;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int dato) {
        this.clave = dato;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return (1 + Math.max(altura(nodo.getHijoIzquierdo()), altura(nodo.getHijoDerecho())));
        }

    }

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

    public void inOrden() {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.inOrden();
        }
        System.out.println(clave);
        if (hijoDerecho != null) {
            hijoDerecho.inOrden();
        }
    }

    public void preOrden() {
        System.out.println(clave);
        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrden();
        }
        if (hijoDerecho != null) {
            hijoDerecho.preOrden();
        }
    }

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
