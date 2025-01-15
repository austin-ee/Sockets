/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package udpclient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Winston
 */
public class UDPClient extends Application {
    DatagramSocket socket;
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("udpclient.fxml"));
        Button btn=new Button("Server");
        root.add(btn, 0, 0);
         btn.setOnAction(e->{try {
             server();
            } catch (Exception ex) {
                System.out.println("Client not working");
            }
});
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
    
    public void server()throws Exception{
        socket=new DatagramSocket();
        byte []buffer=new byte[1024];
        buffer="Our UDP server is working".getBytes();
        DatagramPacket spacket=new DatagramPacket(buffer,buffer.length,InetAddress.getLocalHost(),1111);
        socket.send(spacket);
       
        
        byte []buffer1=new byte[1024];
        DatagramPacket rpacket=new DatagramPacket(buffer1,buffer1.length);
        socket.receive(rpacket);
        Alert alt=new Alert(Alert.AlertType.INFORMATION);
        String pkt=new String(rpacket.getData());
        System.out.println(pkt);
        alt.setContentText(pkt);
        alt.show();
    }
}