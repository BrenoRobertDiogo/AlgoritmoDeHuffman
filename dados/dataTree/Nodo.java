package dados.dataTree;


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
            String noAtual = r.getDadoLetra() + r.getDadoFrequencia();
            // System.out.println("Freq: " + r.getDadoFrequencia() + " | Char: " +
            // r.getDadoLetra());
            System.out.print(noAtual);
            if (r.isFolha()) {
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

    

}