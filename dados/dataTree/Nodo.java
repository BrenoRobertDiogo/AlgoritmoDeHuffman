package dados.dataTree;

import Funcionalidades.ManipulaTexto;

public class Nodo {

    private Nodo fE;
    private Dado objeto;
    private Nodo fD;

    public Nodo() {
    }

    public Nodo(int frequencia, char letra) {

        Dado u = new Dado(frequencia, letra);
        objeto = u;
        fE = null; // Não existe filho esquerdo.
        fD = null; // Não existe filho direito.

    }

    public String getDadoFrequencia() {
        return "" + this.objeto.getFrequencia();
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

    public boolean isEmpty(Nodo r) {
        return r == null;
    }

    public static void toString(Nodo r) {
        // String retornar = "";
        if (r != null) {
            String noAtual = r.getDadoLetra()+r.getDadoFrequencia();
            // System.out.println("Freq: " + r.getDadoFrequencia() + " | Char: " + r.getDadoLetra());
            System.out.print(noAtual);
            if(r.isFolha()) {
                System.out.print(")");
            } else {
                System.out.print("(");

            }
            toString(r.getFE());
            toString(r.getFD());
            
        }
        // return retornar;
    }

    public boolean isFolha() {
        return this.getFD() == null && this.getFE() == null;
    }

    public static String removerUltString(String passar) {
        return passar.substring(passar.length(), passar.length());
    }

    public static void binarioLetra2(Nodo r, int lado, String total) {
        if(r!= null){
            String retornar = total;
            if(lado == 0) {
                retornar += "0";
            } else if(lado == 1){
                retornar += "1";
                
            }
            if(r.isFolha()) {
                System.out.print(retornar+" ");
                System.out.println(r.getDadoLetra());
            }
            binarioLetra2(r.getFE(), 0, retornar);
            binarioLetra2(r.getFD(), 1, retornar);
        }
    }

    public void binarioLetra(Nodo r, String retornar, char procurando, ManipulaTexto mani) {
        
        /* if( r.isFolha() ) {
            System.out.print(r.getDadoLetra() +"\n"  );
        } else {
            System.out.print("1");
            binarioLetra(r.getFE(), retornar, procurando, mani);
            System.out.print("0");
            binarioLetra(r.getFD(), retornar, procurando, mani);
        } */
        
        
        /* if (r != null) {
            if (r.getDadoLetra() == procurando && r.isFolha()) {
                // return retornar;
                System.out.println("Achou:        " + retornar + "| "+r.getDadoLetra()+ " | "+r.getDadoFrequencia());
                mani.setBinarioAtual(retornar);
            } else {
                // if (r.getFE() != null) {
                if (isFolha()) {
                    return;
                }
                retornar += "0";
                binarioLetra(r.getFE(), retornar, procurando, mani);
                // } else if (r.getFD() != null) {
    
                retornar += "1";
                binarioLetra(r.getFD(), retornar, procurando, mani);
                // }
                // System.out.println(r.getDadoLetra());
                // return retornar+"";
                // return retornar;
    
            }

        } */

    }
}
