/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package tcpclient;

import aus.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Winston
 */
public class TCPClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("tcpclient.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public static void server(Student student)throws Exception{
        Socket socket=new Socket("localhost",4003);
        
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(student);
        oos.flush();
        String msg=in.readLine();
        socket.close();
        System.out.println("message:"+msg);
        Alert alt=new Alert(Alert.AlertType.INFORMATION);
        alt.setContentText(msg);
        alt.show();
        
        
        
    } 
}
