package org;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.connection.Client;

/**
 *
 * @author John Maynard
 *
 */
public class OpenBotGUI extends Application {
    private Client client = new Client(this);
    private Label x = new Label("temp");
    private Label y = new Label("temp");
    private Label z = new Label("temp");
    private Label rx = new Label("temp");
    private Label ry = new Label("temp");
    private Label rz = new Label("temp");


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("OpenBot");
        primaryStage.setResizable(false);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Label scenetitle = new Label("Move Joints");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 2, 0, 5, 1);
        
        Image imgRight = new Image("images/arrowRight.png");
        Image imgLeft = new Image("images/arrowLeft.png");
        
        Button baseLeft = new Button();
        baseLeft.setGraphic(new ImageView(imgLeft));
        HBox hbbaseLeft = new HBox(10);
        hbbaseLeft.setAlignment(Pos.CENTER_LEFT);
        hbbaseLeft.getChildren().add(baseLeft);
        grid.add(hbbaseLeft,0,1);
        
        Label baseLabel = new Label("BASE");
        grid.add(baseLabel, 5 , 1);
        
        Button baseRight = new Button();
        baseRight.setGraphic(new ImageView(imgRight));
        HBox hbbaseRight = new HBox(10);
        hbbaseRight.setAlignment(Pos.CENTER_RIGHT);
        hbbaseRight.getChildren().add(baseRight);
        grid.add(hbbaseRight,7,1);
        
        TextField baseText = new TextField();
        baseText.setPromptText("Base angle");
        grid.add(baseText,8,1);
        
        Button shoulderLeft = new Button();
        shoulderLeft.setGraphic(new ImageView(imgLeft));
        HBox hbshoulderLeft = new HBox(10);
        hbshoulderLeft.setAlignment(Pos.CENTER_LEFT);
        hbshoulderLeft.getChildren().add(shoulderLeft);
        grid.add(hbshoulderLeft,0,2);
        
        Label shoulderLabel = new Label("SHOULDER");
        grid.add(shoulderLabel, 5 , 2); 
        
        Button shoulderRight = new Button();
        shoulderRight.setGraphic(new ImageView(imgRight));
        HBox hbshoulderRight = new HBox(10);
        hbshoulderRight.setAlignment(Pos.CENTER_RIGHT);
        hbshoulderRight.getChildren().add(shoulderRight);
        grid.add(hbshoulderRight,7,2);
         
        TextField shoulderText = new TextField();
        shoulderText.setPromptText("Shoulder angle");
        grid.add(shoulderText,8,2);
        
        Button elbowLeft = new Button();
        elbowLeft.setGraphic(new ImageView(imgLeft));
        HBox hbelbowLeft = new HBox(10);
        hbelbowLeft.setAlignment(Pos.CENTER_LEFT);
        hbelbowLeft.getChildren().add(elbowLeft);
        grid.add(hbelbowLeft,0,3);
        
        Label elbowLabel = new Label("ELBOW");
        grid.add(elbowLabel, 5 , 3); 
               
        Button elbowRight = new Button();
        elbowRight.setGraphic(new ImageView(imgRight));
        HBox hbelbowRight = new HBox(10);
        hbelbowRight.setAlignment(Pos.CENTER_RIGHT);
        hbelbowRight.getChildren().add(elbowRight);
        grid.add(hbelbowRight,7,3);
         
        TextField elbowText = new TextField();
        elbowText.setPromptText("Elbow angle");
        grid.add(elbowText,8,3);
        
        Button wrist1Left = new Button();
        wrist1Left.setGraphic(new ImageView(imgLeft));
        HBox hbwrist1Left = new HBox(10);
        hbwrist1Left.setAlignment(Pos.CENTER_LEFT);
        hbwrist1Left.getChildren().add(wrist1Left);
        grid.add(hbwrist1Left,0,4);
        
        Label wrist1Label = new Label("WRIST 1");
        grid.add(wrist1Label, 5 , 4); 
               
        Button wrist1Right = new Button();
        wrist1Right.setGraphic(new ImageView(imgRight));
        HBox hbwrist1Right = new HBox(10);
        hbwrist1Right.setAlignment(Pos.CENTER_RIGHT);
        hbwrist1Right.getChildren().add(wrist1Right);
        grid.add(hbwrist1Right,7,4);        
         
        TextField wrist1Text = new TextField();
        wrist1Text.setPromptText("Wrist 1 angle");
        grid.add(wrist1Text,8,4);
        
        Button wrist2Left = new Button();
        wrist2Left.setGraphic(new ImageView(imgLeft));
        HBox hbwrist2Left = new HBox(10);
        hbwrist2Left.setAlignment(Pos.CENTER_LEFT);
        hbwrist2Left.getChildren().add(wrist2Left);
        grid.add(hbwrist2Left,0,5);
        
        Label wrist2Label = new Label("WRIST 2");
        grid.add(wrist2Label, 5 , 5); 
                    
        Button wrist2Right = new Button();
        wrist2Right.setGraphic(new ImageView(imgRight));
        HBox hbwrist2Right = new HBox(10);
        hbwrist2Right.setAlignment(Pos.CENTER_RIGHT);
        hbwrist2Right.getChildren().add(wrist2Right);
        grid.add(hbwrist2Right,7,5);    
          
        TextField wrist2Text = new TextField();
        wrist2Text.setPromptText("Wrist 2 angle");
        grid.add(wrist2Text,8,5);
        
        Button wrist3Left = new Button();
        wrist3Left.setGraphic(new ImageView(imgLeft));
        HBox hbwrist3Left = new HBox(10);
        hbwrist3Left.setAlignment(Pos.CENTER_LEFT);
        hbwrist3Left.getChildren().add(wrist3Left);
        grid.add(hbwrist3Left,0,6);
        
        Label wrist3Label = new Label("WRIST 3");
        grid.add(wrist3Label, 5 , 6); 
                     
        Button wrist3Right = new Button();
        wrist3Right.setGraphic(new ImageView(imgRight));
        HBox hbwrist3Right = new HBox(10);
        hbwrist3Right.setAlignment(Pos.CENTER_RIGHT);
        hbwrist3Right.getChildren().add(wrist3Right);
        grid.add(hbwrist3Right,7,6);            
         
        TextField wrist3Text = new TextField();
        wrist3Text.setPromptText("Wrist 3 angle");
        grid.add(wrist3Text,8,6);

        Button sendAllAnglesButton = new Button("Send All Angles");
        grid.add(sendAllAnglesButton, 8, 7);

        sendAllAnglesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(baseText.getText());
                if(currentValue != -1){
                    client.moveBaseHorizontalTo(currentValue);
                }
                currentValue = parseInt(shoulderText.getText());
                if(currentValue != -1){
                    client.moveShoulderTo(currentValue);
                }
                currentValue = parseInt(elbowText.getText());
                if(currentValue != -1){
                    client.moveElbowTo(currentValue);
                }
                currentValue = parseInt(wrist1Text.getText());
                if(currentValue != -1){
                    client.moveWristOneTo(currentValue);
                }
                currentValue = parseInt(wrist2Text.getText());
                if(currentValue != -1){
                    client.moveWristTwoTo(currentValue);
                }
                currentValue = parseInt(wrist3Text.getText());
                if(currentValue != -1){
                    client.moveWristThreeTo(currentValue);
                }
            }
        });

        baseLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(baseText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    baseText.setText(String.valueOf(targetValue));
                    client.moveBaseHorizontalTo(targetValue);
                }
            }
        });

        baseRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(baseText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue + 1;
                    baseText.setText(String.valueOf(targetValue));
                    client.moveBaseHorizontalTo(targetValue);
                }
            }
        });

        shoulderLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(shoulderText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    shoulderText.setText(String.valueOf(targetValue));
                    client.moveShoulderTo(targetValue);
                }
            }
        });

        shoulderRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(shoulderText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue + 1;
                    shoulderText.setText(String.valueOf(targetValue));
                    client.moveShoulderTo(targetValue);
                }
            }
        });

        elbowLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(elbowText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    elbowText.setText(String.valueOf(targetValue));
                    client.moveElbowTo(targetValue);
                }
            }
        });

        elbowRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(elbowText.getText());
                if(currentValue != -1){
                    int targetValue = currentValue + 1;
                    elbowText.setText(String.valueOf(targetValue));
                    client.moveElbowTo(targetValue);
                }
            }
        });

        wrist1Left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist1Text.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    wrist1Text.setText(String.valueOf(targetValue));
                    client.moveWristOneTo(targetValue);
                }
            }
        });

        wrist1Right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist1Text.getText());
                if(currentValue != -1){
                    int targetValue = currentValue + 1;
                    wrist1Text.setText(String.valueOf(targetValue));
                    client.moveWristOneTo(targetValue);
                }
            }
        });

        wrist2Left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist2Text.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    wrist2Text.setText(String.valueOf(targetValue));
                    client.moveWristTwoTo(targetValue);
                }
            }
        });

        wrist2Right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist2Text.getText());
                if (currentValue != -1) {
                    int targetValue = currentValue + 1;
                    wrist2Text.setText(String.valueOf(targetValue));
                    client.moveWristTwoTo(targetValue);
                }
            }
        });

        wrist3Left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist3Text.getText());
                if(currentValue != -1){
                    int targetValue = currentValue - 1;
                    wrist3Text.setText(String.valueOf(targetValue));
                    client.moveWristThreeTo(targetValue);
                }
            }
        });

        wrist3Right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int currentValue = parseInt(wrist3Text.getText());
                if(currentValue != -1){
                    int targetValue = currentValue + 1;
                    wrist3Text.setText(String.valueOf(targetValue));
                    client.moveWristThreeTo(targetValue);
                }
            }
        });


        Label scenetitle2 = new Label("Enter Angle");
        scenetitle2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle2, 8, 0, 5, 1);

        Label scenetitle3 = new Label("Tool Position");
        scenetitle3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle3, 10, 0, 5, 1);
        
        String xValue = "360.0";
        grid.add(x, 11, 1);
        x.setText("X :  "+ xValue);

        String yValue = "360.0";
        grid.add(y, 11, 2);
        y.setText("Y :  "+ yValue);        

        String zValue = "360.0";
        grid.add(z, 11, 3);
        z.setText("Z :  "+ zValue);
        
        String rxValue = "360.0";
        grid.add(rx, 11, 4);
        rx.setText("RX :  "+ rxValue);
        
        String ryValue = "360.0";
        grid.add(ry, 11, 5);
        ry.setText("RY :  "+ ryValue);
        
        String rzValue = "360.0";
        grid.add(rz, 11, 6);
        rz.setText("RZ :  "+ rzValue);
        
        //Scene
        Scene scene = new Scene(grid, 700, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                client.killClient();
            }
        });


        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        StyleManager.getInstance().addUserAgentStylesheet(this.getClass().getResource("/resources/styleSheet.css").toExternalForm());
    }

    private int parseInt(String text){
        int parsedInt = -1;
        try{
            parsedInt = Integer.parseInt(text);
        }
        catch (NumberFormatException e){
            System.out.println("Could not convert to int: " + text);
        }
        return parsedInt;
    }

    public void updateJointNumber(int jointNumber, int newPosition){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                switch (jointNumber){
                    case 0:
                        updateBasePosition(newPosition);
                        break;
                    case 1:
                        updateShoulderPosition(newPosition);
                        break;
                    case 2:
                        updateElbowPosition(newPosition);
                        break;
                    case 3:
                        updateWristOnePosition(newPosition);
                        break;
                    case 4:
                        updateWristTwoPosition(newPosition);
                        break;
                    case 5:
                        updateWristThreePosition(newPosition);
                        break;
                }
            }
        });
    }

    private void updateBasePosition(int newPosition){
        this.x.setText(String.valueOf(newPosition));
    }

    private void updateShoulderPosition(int newPosition){
        this.y.setText(String.valueOf(newPosition));
    }

    private void updateElbowPosition(int newPosition){
        this.z.setText(String.valueOf(newPosition));
    }

    private void updateWristOnePosition(int newPosition){
        this.rx.setText(String.valueOf(newPosition));
    }

    private void updateWristTwoPosition(int newPosition){
        this.ry.setText(String.valueOf(newPosition));
    }

    private void updateWristThreePosition(int newPosition){
        this.rz.setText(String.valueOf(newPosition));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
