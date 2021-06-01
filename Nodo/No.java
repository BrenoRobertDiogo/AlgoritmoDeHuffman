package Nodo;

public class No {
    private No direito;
    private No esquerdo;


    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No() {
        this.direito = null;
        this.esquerdo = null;
    }



    public No(No direito, No esquerdo) {
        this.direito = direito;
        this.esquerdo = direito;
    }

}
