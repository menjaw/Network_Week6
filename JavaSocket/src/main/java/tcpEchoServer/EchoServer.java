/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpEchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class EchoServer {

    public static void main(String[] args) {
        try {
            //First make a server socket
            //Second make a Socket (this is the client socket)
            //Then we have a server handshake between the server and the client
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket clientSocket = serverSocket.accept(); //the accept() blocks the program until a client make a request

            //request from the client
            System.out.println("The connection to the server is created");
            InputStream userInput = clientSocket.getInputStream();

            //make a BufferedReader to read the text from the user and create a new inputStreamReader to build a bridge from byteStream to characterStream 
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(userInput));
            String textLine = userInputReader.readLine();

            //make an outPutStream to get the input from the clientSocket and send information back
            OutputStream outputToUser = clientSocket.getOutputStream();

            //create a printwriter to echo back
            PrintWriter printWriter = new PrintWriter(outputToUser, true);
            while ((textLine) != null) {
                printWriter.println("MSG: " + textLine);
                printWriter.flush();
                System.out.println("Menjas server answering back: " + textLine.toUpperCase());
                if (textLine.equals("Stop")) {
                    break;
                }
                textLine = userInputReader.readLine();
            }

            //close for all connections
            printWriter.close();
            serverSocket.close();
            clientSocket.close();

        } catch (IOException ex) {
            ex.printStackTrace();//fejl og alle mellemled printes ud
        }

    }

}
