/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Socket;
import java.net.*;
import java.io.*;

/**
 *
 * @author nasr_
 */
public class MYserver {
     public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(3335);
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String  str1 = "", str2 = "";

            while (!str1.equals("stop")) {
                str1=(String)dis.readUTF();

                System.out.println("Client says: " + str1);
                if(!str1.equals("stop")) {
                    str2 = br.readLine();
                    dout.writeUTF(str2);
                    dout.flush();
                }
            }
            ss.close();
        }catch(Exception e){System.out.println(e);}
    }
    
}
