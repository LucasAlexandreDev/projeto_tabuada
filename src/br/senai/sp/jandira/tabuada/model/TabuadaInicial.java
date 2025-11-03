package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class TabuadaInicial {

    public int multiplicando;
    public int multiplicadorInicial;
    public int multiplicadorFInal;
    public String[] tabuada;

    public void receberDadosUsuario() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Qual é o valor do multiplicando? ");
        multiplicando = leitor.nextInt();

        System.out.print("Qual é o valor do multiplicador Inicial? ");
        multiplicadorInicial = leitor.nextInt();

        System.out.print("Qual é o valor do multiplicador Final? ");
        multiplicadorFInal = leitor.nextInt();

        calcularTabuada();
    }

    public void calcularTabuada(){

        int apoio = 0;
        if (multiplicadorFInal < multiplicadorInicial){
            apoio = multiplicadorFInal;
            multiplicadorFInal = multiplicadorInicial;
            multiplicadorInicial = apoio;
        }

        int tamanhoVetor= multiplicadorFInal - multiplicadorInicial + 1;
        tabuada = new String[tamanhoVetor];

        int i = 0;

        while (i < tamanhoVetor){
            int produto = multiplicando * multiplicadorInicial;
            tabuada[i] = multiplicando + " x " + multiplicadorInicial + " = " + produto;
            multiplicadorInicial = multiplicadorInicial + 1;
            i = i + 1;
        }
        exibirTabuada();
    }

    public void exibirTabuada(){
        int i = 0;
        while (i < tabuada.length){
            System.out.println(tabuada[i]);
            i++;
        }
    }
}



