package screen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
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
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class SingleGameBordController implements Initializable {
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
    String flag ;
    int turnFlag = 0;
    int oScore, xScore, tieScore = 0;
    int isWinner = -2;// 0 => x is winner / 1 => o is winner / -1 draw
    String finalResult;
    int cpuMove = 0;
    int i = 1;

   public ArrayList<Integer> gameMoves = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     public void setText(String text1 , String text2 , String text3 , String text4 )
    {
        player1.setText(text1);
        player2.setText(text2);
        player1Symbol.setText(text3);
        player2Symbol.setText(text4);
        
      
    }

   

    @FXML
    private void Done_btn(ActionEvent event) {
       
        try {
            mediaPlayer.stop();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/xoClientView/newGame.fxml"));
            Parent viewparent = loader.load();
            Scene viewscene = new Scene(viewparent);
            NewGameController controller = loader.getController();
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(viewscene);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(SingleGameBordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void Btn1_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn1.getText())) {
            gameMoves.add(1);
            Btn1.setText(getTurn());
            Btn1.setDisable(true);
//                    checkWinner();
            gameMoves.add(1);

            nextCpuMove();

        }
    }
     @FXML
     private void Btn2_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn2.getText())) {
            gameMoves.add(2);
            Btn2.setText(getTurn());
            Btn2.setDisable(true);
//                    checkWinner();
            gameMoves.add(2);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn3_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn3.getText())) {
            gameMoves.add(3);
            Btn3.setText(getTurn());
            Btn3.setDisable(true);
//                    checkWinner();
            gameMoves.add(3);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn4_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn4.getText())) {
            gameMoves.add(4);
            Btn4.setText(getTurn());
            Btn4.setDisable(true);
//                    checkWinner();
           gameMoves.add(4);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn5_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn5.getText())) {
            gameMoves.add(5);
            Btn5.setText(getTurn());
            Btn5.setDisable(true);
//                    checkWinner();
            gameMoves.add(5);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn6_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn6.getText())) {
            gameMoves.add(6);
            Btn6.setText(getTurn());
            Btn6.setDisable(true);
//                    checkWinner();
            gameMoves.add(6);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn7_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn7.getText())) {
            gameMoves.add(7);
            Btn7.setText(getTurn());
            Btn7.setDisable(true);
//                    checkWinner();
            gameMoves.add(7);

            nextCpuMove();

        }
    }
      @FXML
     private void Btn8_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn8.getText())) {
            gameMoves.add(8);
            Btn8.setText(getTurn());
            Btn8.setDisable(true);
//                    checkWinner();
            gameMoves.add(8);

            nextCpuMove();

        }
    }
      @FXML
      private void Btn9_action(ActionEvent event){
        setTurn();
        if ("".equals(Btn9.getText())) {
            gameMoves.add(9);
            Btn9.setText(getTurn());
            Btn9.setDisable(true);
//                    checkWinner();
            gameMoves.add(9);

            nextCpuMove();

        }
    }
      
       public void nextCpuMove() {
           checkTie2();
           if(gameMoves.contains(1) && gameMoves.contains(2)&& gameMoves.contains(3)&&gameMoves.contains(4)&&gameMoves.contains(5) && gameMoves.contains(6)&& gameMoves.contains(7)&&gameMoves.contains(8)&&gameMoves.contains(9)){
            System.out.println("draw");
            isWinner = -1;

            endGame();
        }
           else{
        

        System.out.println(gameMoves.size() + " size of moves : ");
       // if (!chk) {
            checkWinner();
            cpuMove = generateRand();
            System.out.println("this is cpu next move :" + cpuMove);
            if (gameMoves.contains(cpuMove)) {

                System.out.println( "cpu couldnt play in this move :" + cpuMove);
                nextCpuMove();
//                if(gameMoves.size() == 9){
//                    System.out.println("tie");   
//                }

            } else {

                switch (cpuMove) {
                    case 1:
                        if ("".equals(Btn1.getText())) {

                            setTurn();
                            Btn1.setText(getTurn());
                            Btn1.setDisable(true);
                            gameMoves.add(1);

                            checkWinner();

                        }
                        break;
                    case 2:

                        if ("".equals(Btn2.getText())) {
                            setTurn();
                            Btn2.setText(getTurn());
                            Btn2.setDisable(true);
                            gameMoves.add(2);
                            checkWinner();

                        }
                        break;
                    case 3:
                        if ("".equals(Btn3.getText())) {
                            setTurn();
                            Btn3.setText(getTurn());
                            Btn3.setDisable(true);
                            gameMoves.add(3);
                            checkWinner();

                        }
                        break;
                    case 4:
                        if ("".equals(Btn4.getText())) {
                            setTurn();
                            Btn4.setText(getTurn());
                            Btn4.setDisable(true);
                            gameMoves.add(4);
                            checkWinner();

                        }
                        break;
                    case 5:
                        if ("".equals(Btn5.getText())) {
                            setTurn();
                            Btn5.setText(getTurn());
                            Btn5.setDisable(true);
                            gameMoves.add(5);
                            checkWinner();

                        }
                        break;
                    case 6:
//                        checkWinner();
                        if ("".equals(Btn6.getText())) {
                            setTurn();
                            Btn6.setText(getTurn());
                            Btn6.setDisable(true);
                            gameMoves.add(6);
                            checkWinner();

                        }
                        break;
                    case 7:
//                        checkWinner();
                        if ("".equals(Btn7.getText())) {
                            setTurn();
                            Btn7.setText(getTurn());
                            Btn7.setDisable(true);
                            gameMoves.add(7);
                            checkWinner();

                        }
                        break;
                    case 8:
//                 checkWinner();
                        if ("".equals(Btn8.getText())) {
                            setTurn();

                            Btn8.setText(getTurn());
                            Btn8.setDisable(true);
                            gameMoves.add(8);
                            checkWinner();

                        }
                        break;

                    case 9:
//                        checkWinner();
                        if ("".equals(Btn9.getText())) {
                            setTurn();
                            Btn9.setText(getTurn());
                            Btn9.setDisable(true);
                            gameMoves.add(9);
                            checkWinner();

                        }
                        break;

                }
            }
       // }
    }
       }

    public void checkWinner() {

        if ("X".equals(Btn1.getText()) && "X".equals(Btn4.getText()) && "X".equals(Btn7.getText())) {
            System.out.println("X is the winner");
            isWinner = 0;
            color(Btn1, Btn4, Btn7);
            endGame();
        }
        if ("O".equals(Btn1.getText()) && "O".equals(Btn4.getText()) && "O".equals(Btn7.getText())) {
            System.out.println("O is the winner");
             color(Btn1, Btn4, Btn7);
            isWinner = 1;
            endGame();
        }

        ///////////////////////////////////////////////////////////////////
        if ("X".equals(Btn2.getText()) && "X".equals(Btn5.getText()) && "X".equals(Btn8.getText())) {
            System.out.println("X is the winner");
            isWinner = 0;
            color(Btn2, Btn5, Btn8);
            endGame();

        }
        if ("O".equals(Btn2.getText()) && "O".equals(Btn5.getText()) && "O".equals(Btn8.getText())) {
            System.out.println("O is the winner");
             color(Btn2, Btn5, Btn8);
            isWinner = 1;
            endGame();
        }
        ///////////////////////////////////////////////////////////////////////
        if ("X".equals(Btn3.getText()) && "X".equals(Btn6.getText()) && "X".equals(Btn9.getText())) {
            System.out.println("X is the winner");
            color(Btn3, Btn6, Btn9);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn3.getText()) && "O".equals(Btn6.getText()) && "O".equals(Btn9.getText())) {
            System.out.println("O is the winner");
            color(Btn3, Btn6, Btn9);
            isWinner = 1;
            endGame();
        }

        if ("X".equals(Btn3.getText()) && "X".equals(Btn5.getText()) && "X".equals(Btn7.getText())) {
            System.out.println("X is the winner");
            color(Btn3, Btn5, Btn7);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn3.getText()) && "O".equals(Btn5.getText()) && "O".equals(Btn7.getText())) {
            System.out.println("O is the winner");
            color(Btn3, Btn5, Btn7);
            isWinner = 1;
            endGame();
        }

        //////////////////////////////////////////////////
        if ("X".equals(Btn1.getText()) && "X".equals(Btn5.getText()) && "X".equals(Btn9.getText())) {
            System.out.println("X is the winner");
            color(Btn1, Btn5, Btn9);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn1.getText()) && "O".equals(Btn5.getText()) && "O".equals(Btn9.getText())) {
            System.out.println("O is the winner");
             color(Btn1, Btn5, Btn9);
            isWinner = 1;
            endGame();
        }

        if ("X".equals(Btn1.getText()) && "X".equals(Btn2.getText()) && "X".equals(Btn3.getText())) {
            System.out.println("X is the winner");
             color(Btn1, Btn2, Btn3);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn1.getText()) && "O".equals(Btn2.getText()) && "O".equals(Btn3.getText())) {
            System.out.println("O is the winner");
            color(Btn1, Btn2, Btn3);
            isWinner = 1;
            endGame();
        }

        ////////////////////////////////////
        if ("X".equals(Btn4.getText()) && "X".equals(Btn5.getText()) && "X".equals(Btn6.getText())) {
            System.out.println("X is the winner");
             color(Btn4, Btn5, Btn6);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn4.getText()) && "O".equals(Btn5.getText()) && "O".equals(Btn6.getText())) {
            System.out.println("O is the winner");
             color(Btn4, Btn5, Btn6);
            isWinner = 1;
            endGame();
        }
        ///////////////////////////////////////////
        if ("X".equals(Btn7.getText()) && "X".equals(Btn8.getText()) && "X".equals(Btn9 .getText())) {
            System.out.println("X is the winner");
             color(Btn7, Btn8, Btn9);
            isWinner = 0;
            endGame();
        }
        if ("O".equals(Btn7.getText()) && "O".equals(Btn8.getText()) && "O".equals(Btn9.getText())) {
            System.out.println("O is the winner");
            isWinner = 1;
             color(Btn7, Btn8, Btn9);
            endGame();
        }
        if(gameMoves.contains(1) && gameMoves.contains(2)&& gameMoves.contains(3)&&gameMoves.contains(4)&&gameMoves.contains(5) && gameMoves.contains(6)&& gameMoves.contains(7)&&gameMoves.contains(8)&&gameMoves.contains(9)){
            System.out.println("draw");
            isWinner = 1;
//                tieScore++;
            endGame();
        }

        if (!"".equals(Btn1.getText()) && !"".equals(Btn2.getText()) && !"".equals(Btn3.getText()) && !"".equals(Btn4.getText()) && !"".equals(Btn5.getText()) && !"".equals(Btn6.getText()) && !"".equals(Btn7.getText()) && !"".equals(Btn8.getText()) && !"".equals(Btn9.getText())) {
             isWinner = -1;
//                tieScore++;
            endGame();
            
        }

    }

    public void endGame() {

        System.out.println("iswinner = " + isWinner);

        Btn1.setDisable(true);
        Btn2.setDisable(true);
        Btn3.setDisable(true);
        Btn4.setDisable(true);
        Btn5.setDisable(true);
        Btn6.setDisable(true);
        Btn7.setDisable(true);
        Btn8.setDisable(true);
        Btn9.setDisable(true);

        switch (isWinner) {
            case 0:{
                finalResult = "Player X is the winner \n";
                if(player1Symbol.getText().equals("X")){
                    winner_loser_txt.setText(player1.getText()+" is winner");
                }
                else{
                    winner_loser_txt.setText(player2.getText()+" is winner");
                }
               
                break;
            }
            case 1:{
                finalResult = "Player O is the winner \n";
                if(player1Symbol.getText().equals("O")){
                    winner_loser_txt.setText(player1.getText()+" is winner");
                }
                else{
                    winner_loser_txt.setText(player2.getText()+" is winner");
                }
                break;
            }
            case -1:{
                finalResult = "That's a Draw \n";
                 winner_loser_txt.setText("That's a Draw ");
                break;
            }
        }
    //   String path = "F:\\vidoes2/VID-20201107-WA0012.mp4";
     /*  Timer timer = new Timer();
       TimerTask task = new TimerTask()
{
        public void run()
        {
         pane2.setVisible(true);
         Done_Btn.setVisible(true);
         winner_loser_txt.setVisible(true);
         mediaView.setVisible(true);
         player1.setVisible(false);
         player2.setVisible(false);
         player1Symbol.setVisible(false);
         player2Symbol.setVisible(false);
         Btns.setVisible(false);
         String path = "F:\\vidoes2/VID-20201107-WA0012.mp4";  
         media = new Media(new File(path).toURI().toString());  
        // animateUsingScaleTransition(mediaView);
         mediaPlayer = new MediaPlayer(media);
         mediaView.setMediaPlayer(mediaPlayer);
         mediaPlayer.setAutoPlay(true);
         
               
        }

};
    timer.schedule(task,500l);  */ 
         pane2.setVisible(true);
         Done_Btn.setVisible(true);
         winner_loser_txt.setVisible(true);
         mediaView.setVisible(true);
         player1.setVisible(false);
         player2.setVisible(false);
         player1Symbol.setVisible(false);
         player2Symbol.setVisible(false);
         Btns.setVisible(false);
         String path = "F:\\vidoes2/VID-20201107-WA0012.mp4";  
         media = new Media(new File(path).toURI().toString());  
        // animateUsingScaleTransition(mediaView);
         mediaPlayer = new MediaPlayer(media);
         mediaView.setMediaPlayer(mediaPlayer);
         mediaPlayer.setAutoPlay(true);
         
      
    }

    public void setTurn() {

        if (turnFlag == 0) {
            turnFlag = 1;
        } else {
            turnFlag = 0;
        }
    }

    public String getTurn() {
        if (turnFlag == 0) {
            return player2Symbol.getText();//"X";
        } else {
            return player1Symbol.getText();//"O";
        }

    }

    public int generateRand() {

        return (int) (Math.random() * ((9 - 1) + 1)) + 1;
    }

    public void checkTie2() {
        if (Btn1.getText() != "" && Btn2.getText() != "" && Btn3.getText() != "" && Btn4.getText() != "" && Btn5.getText() != "" && Btn6.getText() != "" && Btn7.getText() != "" && Btn8.getText() != "" && Btn9.getText() != "") {
            isWinner = -1;
//            tieScore++;
            endGame();
        }

    }
    public void color(Button b1,Button b2 , Button b3)
    {
        b1.setStyle("-fx-background-color: red");
        b2.setStyle("-fx-background-color: red");
        b3.setStyle("-fx-background-color: red");
    }
   private void animateUsingScaleTransition(MediaView heart) {
        ScaleTransition scaleTransition = new ScaleTransition(
            Duration.seconds(1), heart
        );
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setFromZ(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setToZ(1.1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.play();
    }

    
    
}
