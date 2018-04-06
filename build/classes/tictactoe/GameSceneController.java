/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author tyler
 * 
 */

public class GameSceneController implements Initializable {

    @FXML
    public TextField mPlayerOne;
    @FXML
    public TextField mPlayerTwo;
    @FXML
    private Button mStartButton;
    @FXML
    private Button button1;
    @FXML
    private Button button4;
    @FXML
    private Button button7;
    @FXML
    private Button button2;
    @FXML
    private Button button5;
    @FXML
    private Button button8;
    @FXML
    private Button button3;
    @FXML
    private Button button6;
    @FXML
    private Button button9;
    
    private int turns;

    private boolean won;
    private boolean player;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mPlayerOne.setDisable(true);
        mPlayerTwo.setDisable(true);
        
        mPlayerOne.setText(Tictactoe.playerName1);
        mPlayerTwo.setText(Tictactoe.playerName2);
        player = true;
        won = false;
        
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);

        
        
    } 
    
    private void nextPlayer(){
        player = !player;
        if(!player){
            mPlayerOne.setOpacity(0.9);
            mPlayerTwo.setOpacity(0.1);
        }else{
            mPlayerOne.setOpacity(0.1);
            mPlayerTwo.setOpacity(0.9);
        }
    }

    @FXML
    private void didClickStart(ActionEvent event) {
        nextPlayer();
        
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        turns = 0;
    }
    private int getScore(){
        //bottom row
        if((button9.getText().equals(button7.getText()))&(button9.getText().equals(button8.getText())) ){
            if(button9.getText().equals("") || button7.getText().equals("") || button8.getText().equals("")){
                return 0;
            }
            else if(button9.getText().equals("X")){
                return 1;
            }else if(button9.getText().equals("O")){
                return 2;
            }
        }
        //middle row
        if((button6.getText().equals(button5.getText()))&(button6.getText().equals(button4.getText()))){
            if(button6.getText().equals("") || button5.getText().equals("") || button4.getText().equals("")){
                return 0;
            }
            else if(button6.getText().equals("X")){
                return 1;
            }else if(button6.getText().equals("O")){
                return 2;
            }
        }
        //top row
        if((button3.getText().equals(button2.getText()))&(button3.getText().equals(button1.getText()))){
            if(button3.getText().equals("") || button2.getText().equals("") || button1.getText().equals("")){
                return 0;
            }
            else if(button3.getText().equals("X")){
                return 1;
            }else if(button3.getText().equals("O")){
                return 2;
            }
        }
        //right col
        if((button3.getText().equals(button6.getText()))&(button3.getText().equals(button9.getText()))){
            if(button3.getText().equals("") || button6.getText().equals("") || button9.getText().equals("")){
                return 0;
            }
            else if(button3.getText().equals("X")){
                return 1;
            }else if(button3.getText().equals("O")){
                return 2;
            }
        }
        //mid col`
        if((button2.getText().equals(button5.getText()))&(button2.getText().equals(button8.getText()))){
            if(button2.getText().equals("") || button5.getText().equals("") || button8.getText().equals("")){
                return 0;
            }
            else if(button2.getText().equals("X")){
                return 1;
            }else if(button2.getText().equals("O")){
                return 2;
            }
        }
        //left col
        if((button1.getText().equals(button4.getText()))&(button1.getText().equals(button7.getText()))){
            if(button1.getText().equals("") || button4.getText().equals("") || button7.getText().equals("")){
                return 0;
            }
            else if(button1.getText().equals("X")){
                return 1;
            }else if(button1.getText().equals("O")){
                return 2;
            }
        }
        //tl to br diagonal
        if((button1.getText().equals(button5.getText()))&(button1.getText().equals(button9.getText()))){
            if(button1.getText().equals("") || button5.getText().equals("") || button9.getText().equals("")){
                return 0;
            }else if(button1.getText().equals("X")){
                return 1;
            }else if(button1.getText().equals("O")){
                return 2;
            }
        }
        //tr to bl diagonal
        if((button3.getText().equals(button5.getText()))&(button3.getText().equals(button7.getText()))){
            if(button3.getText().equals("") || button5.getText().equals("") || button7.getText().equals("")){
                return 0;
            }else if(button3.getText().equals("X")){
                return 1;
            }else if(button3.getText().equals("O")){
                return 2;
            }
            
        }
        else{
            return 0;
        }
        return 0;
    }
    private void popupWinner(String name){
        won = true;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner!");
        alert.setHeaderText("Three in a row!");
        alert.setContentText("Player: " + name + " has won!");
        alert.showAndWait();
    }
    private void popupCatgame(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Cat Game!");
        alert.setHeaderText("No one was able to win this game.");
        alert.setContentText("You both are losers.");
        alert.showAndWait();
    }

    @FXML
    private void didClickGrid(ActionEvent event) {
        turns++;
        nextPlayer();
        if(event.getTarget().equals(button9)){
            if(player){
               button9.setText("X"); 
            }else{
                button9.setText("O");
            }
            button9.setDisable(true);
        }else if(event.getTarget().equals(button8)){
            if(player){
               button8.setText("X"); 
            }else{
                button8.setText("O");
            }
            button8.setDisable(true);
        }else if(event.getTarget().equals(button7)){
            if(player){
               button7.setText("X"); 
            }else{
                button7.setText("O");
            }
            button7.setDisable(true);
        }else if(event.getTarget().equals(button6)){
            if(player){
               button6.setText("X"); 
            }else{
                button6.setText("O");
            }
            button6.setDisable(true);
        }else if(event.getTarget().equals(button5)){
            if(player){
               button5.setText("X"); 
            }else{
                button5.setText("O");
            }
            button5.setDisable(true);
        }else if(event.getTarget().equals(button4)){
            if(player){
               button4.setText("X"); 
            }else{
                button4.setText("O");
            }
            button4.setDisable(true);
        }else if(event.getTarget().equals(button3)){
            if(player){
               button3.setText("X"); 
            }else{
                button3.setText("O");
            }
            button3.setDisable(true);
        }else if(event.getTarget().equals(button2)){
            if(player){
               button2.setText("X"); 
            }else{
                button2.setText("O");
            }
            button2.setDisable(true);
        }else if(event.getTarget().equals(button1)){
            if(player){
               button1.setText("X"); 
            }else{
                button1.setText("O");
            }
            button1.setDisable(true);
        }
        if(getScore() == 2){
            System.out.print("Player Two Wins");
            popupWinner(Tictactoe.playerName2);
            
        }else if(getScore() == 1){
            System.out.print("Player One Wins");
            popupWinner(Tictactoe.playerName1);
        }
        if(turns>=9 && won == false){
            popupCatgame();
        }
    }
    
}
