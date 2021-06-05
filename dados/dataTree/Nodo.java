package dados.dataTree;

public class Nodo {
    
    private Nodo fE;
    private Dado objeto;
    private Nodo fD;

    public Nodo(){ }

    public Nodo(int frequencia, char letra){

        Dado u = new Dado(frequencia, letra);
        objeto = u;
        fE = null; // Não existe filho esquerdo.
        fD = null; // Não existe filho direito.

    }



    public String getDadoFrequencia() {
        return  ""+this.objeto.getFrequencia();
    }

    public char getDadoLetra() {
        return this.objeto.getLetra();
    }

    public Nodo getFE() {
        return fE;
    }

    public void setFE(Nodo fE) {
        this.fE = fE;
    }

    public Dado getObjeto() {
        return objeto;
    }

    public Nodo getFD() {
        return fD;
    }

    public void setFD(Nodo fD) {
        this.fD = fD;
    }

}
