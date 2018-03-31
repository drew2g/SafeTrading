/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percentchangecalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author nyand
 */
public class PercentChangeCalc extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button calcSell = new Button();
        Label enterStart = new Label();
        TextField textStart = new TextField();
        Label enterPercent = new Label();
        TextField percentGain = new TextField();
        
        Label outputEnd = new Label();
        
        
        calcSell.setText("Calc Sell");
        enterStart.setText("Enter Starting Price");
        enterPercent.setText("Enter Percent");

        calcSell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               double out = CalcChange.calcSellPoint(Double.parseDouble(textStart.getText()), Integer.parseInt(percentGain.getText()));
               System.out.println(out);
               outputEnd.setText(Double.toString(out));
            }
        });
        
        GridPane root = new GridPane();
        root.getChildren().addAll(calcSell,enterStart,textStart,enterPercent,percentGain,outputEnd);
        
        root.setConstraints(enterStart, 0, 0);
        root.setConstraints(textStart, 0, 1);
        root.setConstraints(enterPercent, 0, 2);
        root.setConstraints(percentGain, 0,3);
        root.setConstraints(calcSell, 0, 4);
        root.setConstraints(outputEnd, 0, 5);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Calc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double input = 87580;
        int percent = 2;
        double output = CalcChange.calcSellPoint(input, percent);
        //System.out.println(output);
        
        launch(args);
    }
    
}
