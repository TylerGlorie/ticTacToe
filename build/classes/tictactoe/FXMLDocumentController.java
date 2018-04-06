/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.*;


/**
 *
 * @author tyler
 */
public class FXMLDocumentController implements Initializable {

    
    private Label label;
    @FXML
    private Button button;
    @FXML
    public TextField mPlayerOneBox;
    @FXML
    public TextField mPlayerTwoBox;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void didClickStartButton(ActionEvent event) throws IOException {
       
        Tictactoe.playerName1 = mPlayerOneBox.getText();
        Tictactoe.playerName2 = mPlayerTwoBox.getText();
        
        
        Parent GameParent = FXMLLoader.load(getClass().getResource("GameScene.fxml"));

        Scene GameScene = new Scene(GameParent);

        Stage GameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        GameStage.setScene(GameScene);
        
        GameStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String playerName1 = "";
        String playerName2 = "";
    }    

    @FXML
    private void didClickCloseButton(ActionEvent event) {
        Stage Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage.close();
    }
    
}
