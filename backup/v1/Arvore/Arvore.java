package Arvore;

import Nodo.*;

public class Arvore {
    private NoList raiz;
    

    public Arvore() {
        this.raiz = null;
    }

    public boolean isEmpty(NoList analisar) {
        return analisar == null;
    }
}
