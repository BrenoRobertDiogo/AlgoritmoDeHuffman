package dados.dataList;
import dados.dataTree.Nodo;


public class DadoList{

    /*-----------------------------------
              ATRIBUTOS DA CLASSE
      -----------------------------------*/

    private Nodo nodoTree;

    /*-----------------------------------
             CONSTRUTORES DA CLASSE
      -----------------------------------*/

    public DadoList(Nodo nodoTree){
        this.nodoTree = nodoTree;
    }

    /*-----------------------------------
            MÉTODOS get | set DA CLASSE
      -----------------------------------*/

    public Nodo getFrequencia() {
        return nodoTree;
    }

    public String toString(){

        return " [ Código: " + nodoTree + " |  ]\n";

    }
    
}