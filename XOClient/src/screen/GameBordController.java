package screen;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class GameBordController implements Initializable {

@FXML
    private Label player1;
@FXML
    private Label player2;
@FXML
    private Label player1Symbol;
@FXML
    private Label player2Symbol;


     public void setText(String text1 , String text2 , String text3 , String text4 )
    {
        player1.setText(text1);
        player2.setText(text2);
        player1Symbol.setText(text3);
        player2Symbol.setText(text4);
        
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   
    
}
