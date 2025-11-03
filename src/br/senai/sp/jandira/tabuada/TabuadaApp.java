package br.senai.sp.jandira.tabuada;

import br.senai.sp.jandira.tabuada.model.TabuadaInicial;

public class TabuadaApp {
    public static void main(String[] args) {
        System.out.println("teste");

        TabuadaInicial tabuada = new TabuadaInicial();
        tabuada.receberDadosUsuario();
    }
}
