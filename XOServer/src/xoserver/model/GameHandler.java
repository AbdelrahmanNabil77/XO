/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoserver.model;

/**
 *
 * @author Amr & abdelrahman
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr
 */
public class GameHandler extends Thread {

    private DataInputStream dis;
    private PrintStream ps;
    static Vector<GameHandler> clientVector = new Vector<>();
    private DatabaseConnection databaseConnection;
    private String[] parsedMsg;

    public GameHandler(Socket s) {
        try {
            databaseConnection = DatabaseConnection.getDatabaseInstance();
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            clientVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        initializeDatabase();
        while (true) {
            try {
                String msg = dis.readLine();
                //sendMessageToAll(msg);
                if (msg == null); else if (parsing(msg) == 1) {
                    if (!isUserExists(parsedMsg[1])) {
                        addUserToDatabase(parsedMsg[1], parsedMsg[2], parsedMsg[3]);
                        System.out.println("done added");
                        ++MainServer.offlinePlayers;
                        signInPlayer(parsedMsg[1]);
                        ps.println("Register Confirmed");
                    } else {
                        System.out.println("user exists");
                        ps.println("Register Not Confirmed");    //send false to client to reset text fields as username exists
                    }
                } else if (parsing(msg) == 2) {
                    if (isUserExists(parsedMsg[1])) {
                        if (isPasswordCorrect(parsedMsg[1], parsedMsg[2])) {
                            signInPlayer(parsedMsg[1]);
                            System.out.println("username correct and password is correct"); //send true to client
                            ++MainServer.onlinePlayers;
                            ps.println("SignIN Confirmed#" + getScore(parsedMsg[1]));
                        } else {
                            System.out.println("username correct and password is not correct");
                            ps.println("SignIN not Confirmed");        //send false to client to reset text fields as password is false
                        }
                    } else {
                        System.out.println("username is not correct");
                        ps.println("SignIN not Confirmed");      //send false to client to reset text fields as username doesn't exists
                    }
                } else if (parsing(msg) == 3) {
                    signOutPLayer(parsedMsg[1]);
                } else if (parsing(msg) == 5) {
                    ps.println(getPlayersList()); //sends players list to player
                } else if (parsing(msg) == 6) {
                    System.out.println(msg);
                    sendMessageToAll(msg); //sends players list to player
                }
            } catch (IOException ex) {
                stop(); //handling exception when closing clients
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendMessageToAll(String msg) {
        for (GameHandler s : clientVector) {
            s.ps.println(msg);
        }
    }

    public void initializeDatabase() {
        databaseConnection.openConnection();
    }

    public void addUserToDatabase(String user, String pass, String ip) {
        databaseConnection.addUser(user, pass, ip);
    }

    public boolean isUserExists(String user) {
        if (databaseConnection.checkUserExistance(user)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordCorrect(String user, String pass) {
        if (databaseConnection.checkUserPassword(user, pass)) {
            return true;
        } else {
            return false;
        }
    }

    public void signInPlayer(String user) {
        databaseConnection.signInPlayer(user);
    }

    public void signOutPLayer(String user) {
        databaseConnection.signOutPlayer(user);
    }

    public int parsing(String requestMessage) {
        if (requestMessage.equals(null)) {
            return -1;
        }
        parsedMsg = requestMessage.split("\\#");
        if (parsedMsg[0].equals("REG")) {
            return 1;     //register request
        } else if (parsedMsg[0].equals("SIN")) {
            return 2;     //sign in request
        } else if (parsedMsg[0].equals("SOUT")) {
            return 3; //sign out request
        } else if (parsedMsg[0].equals("NPLAY")) {
            return 4; // finished playing
        } else if (parsedMsg[0].equals("PLIST")) {
            return 5; //request playing list
        } else if (parsedMsg[0].equals("DUWTP") || parsedMsg[0].equals("PREQ")) {
            return 6; //request playing and answer
        } else {
            return 7; //sign out
        }
    }

    public int getScore(String username) {
        return databaseConnection.getScore(username);
    }

    public String getPlayersList() {
        return databaseConnection.getOnlinePlayersList();
    }
}
