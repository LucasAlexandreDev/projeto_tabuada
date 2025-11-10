package br.senai.sp.jandira.tabuada.model.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaTabuada extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //configurações do tamanho da tela//
        stage.setTitle("Tabuada");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setResizable(false);

        //criação do painel principal//
        VBox root = new VBox();

        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #1b004b;");

        //criação do header da tela//
        VBox header = new VBox();
        header.setStyle("-fx-background-color: #4c007d;");
        header.setPadding(new Insets(15));
        header.setPrefHeight(70);

        //colocar o conteúdo no header//

        Label lbltitulo = new Label();
        lbltitulo.setText("Tabuada");
        lbltitulo.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");

        Label lblSubtitulo = new Label();
        lblSubtitulo.setText("Crie a sua tabuada de acordo com a sua imaginação");
        lblSubtitulo.setStyle("-fx-text-fill: black; -fx-font-size: 18;");

        //adicionando o conteúdo no header//
        header.getChildren().addAll(lbltitulo,lblSubtitulo);

        //criação do gridpane do formulário//
        GridPane grid = new GridPane();
        grid.setPrefHeight(200);
        grid.setStyle("-fx-background-color: #7f00b2;");
        grid.setPadding(new Insets(15));


        //criação dos conteúdos no grid//
        Label lblMultiplicando = new Label("Multiplicando: ");
        TextField txtMultiplicando = new TextField();
        lblMultiplicando.setStyle("-fx-text-fill: white; -fx-font-size: 15");


        Label lblMenorMultiplicador = new Label("Menor Multiplicando: ");
        TextField txtMenorMultiplicador = new TextField();
        lblMenorMultiplicador.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        Label lblMaiorMultiplicador = new Label("Maior Multiplicando: ");
        TextField txtMaiorMultiplicador = new TextField();
        lblMaiorMultiplicador.setStyle("-fx-text-fill: white; -fx-font-size: 15");


        //colocar os componentes no grid//
        grid.add(lblMultiplicando, 0, 0);
        grid.add(txtMultiplicando, 1, 0);
        grid.add(lblMenorMultiplicador, 0, 1);
        grid.add(txtMenorMultiplicador, 1, 1);
        grid.add(lblMaiorMultiplicador, 0, 2);
        grid.add(txtMaiorMultiplicador, 1, 2);

        //criação da caixa Hbox dos botões//

        HBox boxBotoes = new HBox();
        boxBotoes.setStyle("-fx-background-color: #bc4ed8;");
        boxBotoes.setPrefHeight(100);

        //criação dos componentes dos botões//

         Button btnCalcular = new Button("Calcular");
         Button btnLimpar = new Button("Limpar");
         Button btnSair = new Button("Sair");

         //adicionando os componentes no boxbotões//
        boxBotoes.getChildren().addAll(btnCalcular,btnLimpar,btnSair);

        //criação da caixa Vbox dos resultados//

        VBox boxResultado = new VBox();
        boxResultado.setPrefHeight(200);
        boxResultado.setStyle("-fx-background-color: #f988ff;");

        //criação  dos componentes do resultados//
        Label lblResultado = new Label("Resultado: ");
        ListView listaTabuada = new ListView();



        //adicionando os componentes no box resultados//
        boxResultado.getChildren().addAll(lblResultado,listaTabuada);

        //adicionando os componente no root//
        root.getChildren().add(header);
        root.getChildren().add(grid);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);


        // criação da cena com o root dentro//
        Scene scene = new Scene(root);

        //colocamos a cena na tela//
        stage.setScene(scene);

        stage.show();

    }
}