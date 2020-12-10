/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class FreeOnlinePlayersController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private javafx.scene.control.ListView listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadDataTOListView(); 
    } 
    @FXML
    private void loadDataTOListView(){
    list.removeAll(list);
    String a = "marwa";
    String b = "norhan";
    String c = "amr";
    String d = "abdelrahman";
       list.addAll(a,b,c,d);
       listView.getItems().addAll(list);
}
    
     @FXML
    private void handleMouseClickAction(javafx.scene.input.MouseEvent event) throws IOException {
     
        
    String view1 = (String) listView.getSelectionModel().getSelectedItem();
    if(view1 == null||view1.isEmpty())
            {
               System.out.println("oooops it is empty");
            }
    else{
       
       
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameBord.fxml"));
        Parent viewparent = loader.load();
        Scene viewscene = new Scene(viewparent);
        GameBordController controller = loader.getController();
        controller.setText("player1" ,view1 ,"x" ,"o","online");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewscene);
        window.show();
    }
    }
    
     @FXML
     private void back_btn(ActionEvent event) throws IOException
     {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ENTER.fxml"));
        Parent viewparent = loader.load();
        Scene viewscene = new Scene(viewparent);
        ENTERController controller = loader.getController();
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewscene);
        window.show(); 
     }
     
         
     
    
}
