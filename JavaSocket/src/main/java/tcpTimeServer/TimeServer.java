/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpTimeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class TimeServer {

    public static void main(String[] args) {
        try {
            //Make server handshake (ServerSocket and Socket)
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket clientSocket = serverSocket.accept();//Accept() blocks until connection is made.

            //Request from the client
            System.out.println("Connection made....");
            InputStream inputFromUser = clientSocket.getInputStream();

            //Make a bufferedReader to read and inputStreamReader to build a bridge from byteStream to characterStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFromUser));
            String textLine = bufferedReader.readLine();

            //make an outPutStream to get the input from the clientSocket and send information back to user
            OutputStream outputToUser = clientSocket.getOutputStream();

            //create a printwriter that prints the echo back
            PrintWriter printWriter = new PrintWriter(outputToUser, true);
            while (textLine != null) {
//                printWriter.println(textLine);
//                System.out.println(textLine);
                if (textLine.equals("Date")) {
                    GregorianCalendar calender = new GregorianCalendar();
                    printWriter.println(calender.get(Calendar.DATE) + "/" + (calender.get(Calendar.MONTH) + "/" + (calender.get(Calendar.YEAR))));
                    System.out.println(calender.get(Calendar.DATE) + "/" + (calender.get(Calendar.MONTH) + "/" + (calender.get(Calendar.YEAR))));
                    break;
                }
                if (textLine.equals("Stop")) {
                    break;
                }
            }

            //close for all connections
            printWriter.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException ex) {
            ex.printStackTrace();//Printer fejlen og mellemledene til fejlen
        }

    }

}
