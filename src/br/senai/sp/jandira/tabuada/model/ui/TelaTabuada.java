package br.senai.sp.jandira.tabuada.model.ui;

import br.senai.sp.jandira.tabuada.TabuadaApp;
import br.senai.sp.jandira.tabuada.model.TabuadaInicial;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

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
        root.setStyle("-fx-background-color: #7f00b2;");

        //criação do header da tela//
        VBox header = new VBox();
        header.setStyle("-fx-background-color: #7f00b2;");
        header.setPadding(new Insets(15));
        //header.setPrefHeight(70);

        //colocar o conteúdo no header//

        Label lbltitulo = new Label();
        lbltitulo.setText("Tabuada");
        lbltitulo.setStyle("-fx-text-fill: white; -fx-font-size: 20; -fx-font-weight: bold;");

        Label lblSubtitulo = new Label();
        lblSubtitulo.setText("Crie a sua tabuada de acordo com a sua imaginação");
        lblSubtitulo.setStyle("-fx-text-fill: black; -fx-font-size: 18;");

        //adicionando o conteúdo no header//
        header.getChildren().addAll(lbltitulo, lblSubtitulo);

        //criação do gridpane do formulário//
        GridPane grid = new GridPane();
        //grid.setPrefHeight(200);
        grid.setStyle("-fx-background-color: #7f00b2;");
        grid.setPadding(new Insets(15));
        grid.setHgap(15);
        grid.setVgap(15);


        //criação dos conteúdos no grid//
        Label lblMultiplicando = new Label("Multiplicando: ");
        TextField txtMultiplicando = new TextField();
        lblMultiplicando.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        Label lblMenorMultiplicador = new Label("Menor Multiplicandor: ");
        TextField txtMenorMultiplicador = new TextField();
        lblMenorMultiplicador.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        Label lblMaiorMultiplicador = new Label("Maior Multiplicandor: ");
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
        //boxBotoes.setPrefHeight(150);
        boxBotoes.setSpacing(20);
        boxBotoes.setAlignment(Pos.CENTER);

        Pane panebotao = new Pane();
        panebotao.setPadding(new Insets(20, 0, 20, 20));

        panebotao.getChildren().addAll(boxBotoes);

        //criação dos componentes dos botões//

        Button btnCalcular = new Button("Calcular");
        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");

        btnCalcular.setStyle("-fx-background-color: #00cc84");
        btnCalcular.setPrefHeight(40);
        btnCalcular.setPrefWidth(100);

        btnLimpar.setStyle("-fx-background-color: #fff06a");
        btnLimpar.setPrefHeight(40);
        btnLimpar.setPrefWidth(100);

        btnSair.setStyle("-fx-background-color: #ff4343");
        btnSair.setPrefHeight(40);
        btnSair.setPrefWidth(100);

        //adicionando os componentes no boxbotões//
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //criação da caixa Vbox dos resultados//

        VBox boxResultado = new VBox();
        //boxResultado.setPrefHeight(600);
        boxResultado.setStyle("-fx-background-color: #7f00b2;");

        //criação  dos componentes do resultados//
        Label lblResultado = new Label("Resultado: ");
        lblResultado.setStyle("-fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
        lblResultado.setPadding(new Insets(10, 0, 10, 15));

        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(10, 10, 10, 10));

        //adicionando os componentes no box resultados//
        boxResultado.getChildren().addAll(lblResultado, listaTabuada);

        //adicionando os componente no root//
        root.getChildren().add(header);
        root.getChildren().add(grid);
        root.getChildren().add(panebotao);
        root.getChildren().add(boxResultado);
        root.getChildren().add(listaTabuada);


        // criação da cena com o root dentro//
        Scene scene = new Scene(root);

        //colocamos a cena na tela//
        stage.setScene(scene);

        stage.show();

        btnCalcular.setOnAction(e -> {
            TabuadaInicial tabuada = new TabuadaInicial();

            tabuada.multiplicando =
                    Integer.parseInt(txtMultiplicando.getText());

            tabuada.multiplicadorInicial =
                    Integer.parseInt(txtMenorMultiplicador.getText());

            tabuada.multiplicadorFInal =
                    Integer.parseInt(txtMaiorMultiplicador.getText());

            String[] resultado = tabuada.calcularTabuada();

            listaTabuada.getItems().addAll(resultado);

            //gravar os dados da tabuada no arquivo dados_tabuada
            Path arquivo = Path.of("c:\\Users\\25203702\\DS1T\\Tabuada\\dados_tabuada.csv");

            String dados = txtMultiplicando.getText() + ";" + txtMenorMultiplicador.getText() + ";" + txtMaiorMultiplicador.getText() + ";" + LocalDateTime.now() + "\n";

            try {
                Files.writeString(arquivo, dados, StandardOpenOption.APPEND);
            } catch (IOException erro) {
                System.out.println(erro.getMessage());
            }

            btnLimpar.setOnAction(Aplicacao -> {
                txtMenorMultiplicador.clear();
                txtMaiorMultiplicador.clear();
                txtMultiplicando.clear();
                listaTabuada.getItems().clear();
                txtMultiplicando.requestFocus();
            });

            btnSair.setOnAction(Aplicacao -> {
                System.exit(0);
            });
        });
    }
}