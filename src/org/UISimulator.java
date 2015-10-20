package org;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.connection.Client;

/**
 * Created by zach on 9/10/2015.
 */
public class UISimulator extends Application{
    private GridPane gridPane = new GridPane();
    private Button sendButton = new Button("Send Command");
    private Button loadValuesButton = new Button("Load Queue Data");
    private TextArea commandText = new TextArea();
    private TextArea replyText = new TextArea();
    private Client client = new Client();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("UI Simulator");

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                client.killClient();
            }
        });

        gridPane.prefWidthProperty().bind(scene.widthProperty());
        gridPane.prefHeightProperty().bind(scene.heightProperty());

        commandText.prefWidthProperty().bind(scene.widthProperty());
        replyText.prefWidthProperty().bind(scene.widthProperty());

        commandText.prefHeightProperty().bind(scene.heightProperty().subtract(loadValuesButton.getHeight()).divide(2));
        replyText.prefHeightProperty().bind(scene.heightProperty().subtract(loadValuesButton.getHeight()).divide(2));

        replyText.setEditable(false);

        sendButton.prefWidthProperty().bind(scene.widthProperty().divide(2));
        loadValuesButton.prefWidthProperty().bind(scene.widthProperty().divide(2));


        registerListeners();

        gridPane.add(commandText, 0, 0, 2, 1);
        gridPane.add(replyText, 0, 1, 2, 1);
        gridPane.add(sendButton, 0, 2);
        gridPane.add(loadValuesButton, 1, 2);

        root.getChildren().add(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        StyleManager.getInstance().addUserAgentStylesheet(this.getClass().getResource("/resources/styleSheet.css").toExternalForm());
    }

    private void registerListeners(){

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button pressed");
                client.sendMessage(commandText.getText());
            }
        });

        loadValuesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String message = client.getMessage();
                if(message != null){
                    replyText.setText(message);
                } else{
                    replyText.setText("Empty inbound queue!");
                }
            }
        });


    }

    public static void main(String[] args){
        launch();
    }
}
