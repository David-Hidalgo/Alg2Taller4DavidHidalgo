package ejercicio12.arbolBinario;

public class ABB {
    protected Nodo raiz;

    public ABB() {
        raiz = null;
    }

    public ABB(int valor) {
        raiz = new Nodo(valor);
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int valorInsertar) {
        if (this.raiz == null) {
            this.raiz = new Nodo(valorInsertar);
        } else {
            this.raiz = insertar(valorInsertar, this.raiz);
        }
    }
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
    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }
    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }
    public void postOrden() {
        if (raiz != null) {
            raiz.postOrden();
        }
    }

}
