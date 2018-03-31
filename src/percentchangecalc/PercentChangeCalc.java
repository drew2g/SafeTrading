/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percentchangecalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
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
        //Fee
        Label enterFee = new Label();
        TextField feeInput = new TextField();
        //PercentButtons
        Button onePercent = new Button();
        Button twoPercent = new Button();
        Button threePercent = new Button();
        
        Label outputEnd = new Label();
        
        
        calcSell.setText("Calc Sell");
        enterStart.setText("Enter Starting Price");
        enterPercent.setText("Enter Target Percent [0-1]");
        percentGain.setText("0.03");
        enterFee.setText("Enter Transaction Fee Percent [0-1]");
        feeInput.setText("0.001");
        onePercent.setText("1%");
        twoPercent.setText("2%");
        threePercent.setText("3%");
        
        enterStart.setMaxWidth(Double.MAX_VALUE);
        enterPercent.setMaxWidth(Double.MAX_VALUE);
        enterFee.setMaxWidth(Double.MAX_VALUE);
        enterStart.setAlignment(Pos.CENTER);
        enterPercent.setAlignment(Pos.CENTER);
        enterFee.setAlignment(Pos.CENTER);
        

        calcSell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double out;
                if(feeInput.getText().equals(""))
                {
                    out = CalcChange.calcSellPoint(Double.parseDouble(textStart.getText()), Double.parseDouble(percentGain.getText()));
                }
                else{
                    out = CalcChange.calcSellPoint(Double.parseDouble(textStart.getText()), Double.parseDouble(percentGain.getText()), Double.parseDouble(feeInput.getText()));
                }
               System.out.println(out);
               outputEnd.setText(Double.toString(out));
            }
        });
        onePercent.setOnAction(event -> percentGain.setText("0.01"));
        twoPercent.setOnAction(event -> percentGain.setText("0.02"));
        threePercent.setOnAction(event -> percentGain.setText("0.03"));
        
        GridPane root = new GridPane();
        root.getChildren().addAll(calcSell,enterStart,textStart,enterPercent,percentGain,outputEnd,enterFee,feeInput,onePercent,twoPercent,
                                threePercent);
        
        root.setConstraints(enterStart, 0, 0);
        root.setConstraints(textStart, 0, 1);
        root.setConstraints(enterPercent, 0, 2);
        root.setConstraints(percentGain, 0,3);
        root.setConstraints(onePercent,1,3);
        root.setConstraints(twoPercent,2,3);
        root.setConstraints(threePercent,3,3);
        root.setConstraints(enterFee, 0,4);
        root.setConstraints(feeInput,0,5);
        root.setConstraints(calcSell, 0, 6);
        root.setConstraints(outputEnd, 0, 7);
        
        root.setVgap(10);
        root.setHgap(2);
        
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
