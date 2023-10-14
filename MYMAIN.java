package com.internshala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MYMAIN extends Application {

    public static void main(String[] args) {
        System.out.println("MAIN");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("init");    //Starts an application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");  //Starts an application

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();

    }

    private MenuBar createMenu(){

        //File Menu
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");

        newMenuItem.setOnAction(Event -> {
            System.out.println("New Menu Item Clicked");
            //More Code
        } );

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("quit");

        quitMenuItem.setOnAction(event ->{
          Platform.exit();
          System.exit(0);
        } );






        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem,quitMenuItem);

        //Help Menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);




        //MenuBar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    public static void aboutApp() {

        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFx");
        alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome Java game");

        ButtonType yesBtn=new ButtonType("yes");
        ButtonType noBtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickBtn =alertDialog.showAndWait();
        if (clickBtn.isPresent()&&clickBtn.get()==yesBtn){
            System.out.println("Yes Button Clicked");
        } else
        {
            System.out.println("No Button clicked");
        }
    }


    @Override
    public void stop() throws Exception {
        System.out.println("stop");  //Called when appliaction is stopped and is about to shut down
        super.stop();
    }
}
