/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */

public class NetworkGameBoardController implements Initializable {
@FXML
    private Label player1 , player2, player1Symbol ,player2Symbol;

@FXML
    private Button Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,Btn8,Btn9;
   @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;
    @FXML
    private Label winner_loser_txt;
    @FXML
    private Button Done_Btn;
    @FXML
    private GridPane Btns;
    @FXML
    private Pane pane2;
    int s;
    String name;
     public void setText(String text1 , String text2 , String text3 , String text4 , int score )
    {
        player1.setText(text1);
        player2.setText(text2);
        player1Symbol.setText(text3);
        player2Symbol.setText(text4);
        s = score;
        name = text1;
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void Done_btn(ActionEvent event) 
    {
    try {
      //  mediaPlayer.stop();
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("/xoClientView/ENTER.fxml"));
        Parent viewParent =loader.load();
        Scene viewscene =new Scene (viewParent);
        ENTERController controller =loader.getController();
        controller.nPlayerScore(s);
        controller.nPlayerName(name);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewscene);
        window.show();
    } catch (IOException ex) {
        Logger.getLogger(NetworkGameBoardController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }  
    
}
