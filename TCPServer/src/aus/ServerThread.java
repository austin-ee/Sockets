/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Winston
 */
public class ServerThread extends Thread {

    @Override
    public void run(){
        System.out.print("its running");
       // super.run(); 
      try{  
           ServerSocket socket=new ServerSocket(4003);
          while(true){
             Socket con = socket.accept();
              BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
              PrintWriter out=new PrintWriter(con.getOutputStream(),true);
              ObjectInputStream ois=new ObjectInputStream(con.getInputStream());
              Student st=(Student)ois.readObject();
              con.close();
             /* Alert alt=new Alert(Alert.AlertType.INFORMATION);
              alt.setContentText("Hello"+st.getName()+". RegNo:"+st.getReg()+"  "+st.getAge()+" years old");
              alt.setWidth(15);
              alt.show();**/
              System.out.println("Hello"+st.getName()+". RegNo:"+st.getReg()+"  "+st.getAge()+" years old");
              out.flush();
              //System.out.println(in.readLine());
          }
}
      catch(IOException | ClassNotFoundException e){}
    }
    
    
}
