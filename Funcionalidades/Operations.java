package Funcionalidades;

import TAD.LE;
import dados.dataTree.Nodo;

import dados.dataList.NoList;
import java.io.IOException;
// Escrever objetos
import java.io.BufferedWriter;
import java.io.FileWriter;

// Ler objetos
import java.io.FileReader;
import java.io.BufferedReader;

public class Operations {

    private static NoList criaArvore(LE listaEncadeada, ManipulaTexto manipulaTexto) {

        NoList[] baiocco2;
        int tamanhoLE = listaEncadeada.getQuantidadeDeNos() - 1;
        NoList pai = null;

        for (int i = 0; i < tamanhoLE; i++) {
            // System.out.println(listaEncadeada.toString());
            baiocco2 = manipulaTexto.doisMenores(listaEncadeada);
            pai = manipulaTexto.adicionaPai(baiocco2);
            listaEncadeada.inserirLogica(pai);
        }
        return pai;
    }

    public static void printaArvore(String[] arrayFrequencia, LE listaEncadeada) {
        int temp;
        char letra;
        for (String i : arrayFrequencia) {
            temp = Integer.parseInt(i.split("ϡ,")[0]);
            letra = i.split("ϡ,")[1].charAt(0);
            listaEncadeada.inserir(temp, letra);
        }
    }

    private static void binarioLetra(Nodo r, int lado, String total, BufferedWriter buffWrite) {
        if (r != null) {
            String retornar = total;
            if (lado == 0) {
                retornar += "0";
            } else if (lado == 1) {
                retornar += "1";

            }
            if (r.isFolha()) {
                try {

                    buffWrite.append(retornar + "" + r.getDadoLetra() + "S2");
                } catch (Exception e) {
                }

            }
            binarioLetra(r.getFE(), 0, retornar, buffWrite);
            binarioLetra(r.getFD(), 1, retornar, buffWrite);
        }
    }

    private static String[] pegaCabecalho(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        String[] retornar = new String[2];
        int cont = 0;
        while (true) {
            if (linha != null) {
                linha = buffRead.readLine();
                retornar[cont] = linha;

            } else
                break;
            cont++;
        }
        buffRead.close();
        return retornar;
    }

    private static int estaContido(String valor, String[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            if(valor.equals(vetor[i])  ) {
                return i;
            }
        }
        return -1;
    }
    
    public static String descompactaTexto(String texto, String path) {
        String retorna = "";
        String[] linesFile = new String[2];
        try {
            linesFile = pegaCabecalho(path);

        } catch (IOException e) {}

        String[] cabecalho = linesFile[0].split("S2");
        String[] binarios = new String[cabecalho.length] ;
        char[] caracter = new char[cabecalho.length] ;

        for (int i = 0; i < cabecalho.length; i++) {
            binarios[i] = cabecalho[i].substring(0, cabecalho[i].length()-1);
            caracter[i] = cabecalho[i].charAt(cabecalho[i].length()-1);
        }
        String aux = "";
        for (int i = 0; i < texto.length() ; i++) {
            aux += texto.charAt(i)+"";
            int numeroContido = estaContido(aux, binarios);
            if(numeroContido!=-1){
                retorna+=caracter[numeroContido];
                aux = "";
            }

        }
        return retorna;

    }

    public static String compactaTexto(String texto, String path) {
        String[] linesFile = new String[2];
        String retorna = "";
        try {
            linesFile = pegaCabecalho(path);

        } catch (IOException e) {}

        String[] cabecalho = linesFile[0].split("S2");
        String[] binarios = new String[cabecalho.length] ;
        char[] caracter = new char[cabecalho.length] ;
        for (int i = 0; i < cabecalho.length; i++) {
            binarios[i] = cabecalho[i].substring(0, cabecalho[i].length()-1);
            caracter[i] = cabecalho[i].charAt(cabecalho[i].length()-1);
        }

        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < caracter.length; j++) {
                String letraAtual = ""+texto.charAt(i);
                String binarioAtual = binarios[j];
                if(letraAtual.equals((caracter[j])+"")){
                    retorna += binarioAtual;
                    break;
                }
            }
        }
        return retorna;
    }

    

    public static String ExcutaBinario(String texto,String nomearq,String path) throws IOException{
        ManipulaTexto manipulaTexto = new ManipulaTexto(texto);
        String[] arrayFrequencia = manipulaTexto.frequencia();
        LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);
        NoList pai = criaArvore(listaEncadeada, manipulaTexto);

        BufferedWriter buffWrite;

        buffWrite = new BufferedWriter(new FileWriter(path+"\\"+nomearq+".mexirica"));
        Operations.binarioLetra(pai.getNoTree().getFrequencia(), 2, "", buffWrite);
        buffWrite.close();
        binarioLetra(pai.getNoTree().getFrequencia(), 2, "",buffWrite);

        return path+"\\"+nomearq+".mexirica";
    }

}
