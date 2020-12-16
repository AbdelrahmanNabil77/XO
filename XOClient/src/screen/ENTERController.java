package screen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ENTERController implements Initializable {

    @FXML
    private Label playerName;
    @FXML
    private Label score;
    @FXML
    private Button newGame_txt;
    @FXML
    private Button record_txt;
    String Name ;
    int s ;
    /**
     * Initializes the controller class.
     */
    public void nPlayerName(String name)
    {
        Name = name;
        playerName.setText(Name);
    }
    public void nPlayerScore(int scr)
    {
        s = scr;
        score.setText(""+scr);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

   

    @FXML
    private void recordAction(ActionEvent event) throws IOException {
        
          FXMLLoader loader =new FXMLLoader();
          loader.setLocation(getClass().getResource("/xoClientView/record.fxml"));
          Parent viewParent =loader.load();
          Scene viewscene =new Scene (viewParent);
          RecordController controller =loader.getController();
          controller.flag_value("guest");
          
          Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(viewscene);
          window.show();
    }
     @FXML
    private void log_out(ActionEvent event)  {
        
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("/xoClientView/signIN.fxml"));
            Parent viewParent =loader.load();
            Scene viewscene =new Scene (viewParent);
            SignINController controller =loader.getController();
            Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(viewscene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ENTERController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void NewGameAction(ActionEvent event)  {
       
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("/xoClientView/FreeOnlinePlayers.fxml"));
            Parent viewParent =loader.load();
            Scene viewscene =new Scene (viewParent);
            FreeOnlinePlayersController controller =loader.getController();
            controller.set_playerName(Name ,s );
            Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(viewscene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ENTERController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


    @FXML
    private void back_click(ActionEvent event) throws IOException {
        
         
          FXMLLoader loader =new FXMLLoader();
          loader.setLocation(getClass().getResource("/xoClientView/signIN2.fxml"));
          Parent viewParent =loader.load();
          Scene viewscene =new Scene (viewParent);
          SignIN2Controller controller =loader.getController();
          Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(viewscene);
          window.show();
    }

    
}
