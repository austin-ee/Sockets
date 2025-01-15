/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package udpserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Winston
 */
public class UDPServer extends Application {
    DatagramSocket socket;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("udpserver.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        try{
             socket=new DatagramSocket(1111);
        }
        catch(SocketException e){
            System.out.println(e.getMessage());
        }
        socket.setSoTimeout(40000);
        byte buffer[]=new byte[1024];
        DatagramPacket rpacket=new DatagramPacket(buffer,buffer.length);
        socket.receive(rpacket);
        String message=new String(rpacket.getData());
    
            byte []buffers=new byte[1024];
            buffers="Am proud network programmer".getBytes();
            DatagramPacket pkt=new DatagramPacket(buffers,buffers.length,rpacket.getAddress(),rpacket.getPort());
            socket.send(pkt);
        
        System.out.println(message);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public String analyse(String data){
        return "Length:"+data.length();
    }
    
}
