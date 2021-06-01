package Arvore;

import Nodo.*;

public class Arvore {
    private No raiz;
    

    public Arvore() {
        this.raiz = null;
    }

    public boolean isEmpty(No analisar) {
        return analisar == null;
    }
}
