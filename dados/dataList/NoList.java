package dados.dataList;

import dados.dataTree.Nodo;
import java.io.Serializable;

public class NoList implements Serializable{

    private DadoList nodoTree;
    private NoList proximo;

    public NoList(Nodo nodoTree) {

        DadoList u = new DadoList(nodoTree);
        this.nodoTree = u;

    }


    public DadoList getNoTree() {
        return nodoTree;
    }

    public NoList getProximo() {
        return proximo;
    }

    public void setProximo(NoList proximo) {
        this.proximo = proximo;
    }

}
