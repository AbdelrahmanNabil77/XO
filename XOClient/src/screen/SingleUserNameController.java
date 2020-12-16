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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
     
public class SingleUserNameController implements Initializable {
@FXML 
private  RadioButton x , o ;
@FXML 
private  TextField playerName ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
@FXML 
private void handleStartSinglePlayer (ActionEvent event) throws IOException
{
     String symbole1 = " ";
     String symbole2 = " ";
     
   if (x.isSelected())
        {
             symbole1 = "X";
             symbole2 = "O";
        }
   else if(o.isSelected())
   {
             symbole1 = "O";
             symbole2 = "X";
   }
   if(playerName.getText().isEmpty() || playerName.getText().contains(" "))
   {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "your name is required without spaces.", ButtonType.OK);
                                            alert.getDialogPane().setMinHeight(Region.USE_COMPUTED_SIZE);
                                            alert.show();
   }
   else
   {
   
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/xoClientView/SingleGameBord.fxml"));
        Parent viewparent = loader.load();
        Scene viewscene = new Scene(viewparent);
        SingleGameBordController controller = loader.getController();
        controller.setText(playerName.getText() , "computer" ,symbole1 ,symbole2 );
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewscene);
        window.show();
   }
}
 @FXML
    private void back_btn(ActionEvent event) throws IOException{
      
        FXMLLoader loader =new FXMLLoader();
          loader.setLocation(getClass().getResource("/xoClientView/newGame.fxml"));
          Parent viewParent =loader.load();
          Scene viewscene =new Scene (viewParent);
          NewGameController controller =loader.getController();
          Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(viewscene);
          window.show();
    }
    
}
