package Server;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ServerThread extends Thread {  //  class is used in a multi-threaded server application to handle incoming client connections. When a new client connection is established, a new instance of ServerThread is created for that client.


    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;

    // server receive socket and list
    public ServerThread(Socket var1, ArrayList<ServerThread> var2) {
        this.socket = var1;
        this.threadList = var2;
    }

    public void run() {  // read the input from client I used the bufferreader
        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            // to the return the output to the client, I use Printwriter
            this.output = new PrintWriter(this.socket.getOutputStream(), true);

            while(true) {  // this one connet to all client requenst
                String var2 = var1.readLine();
                if (var2.equals("exit")) {
                    break;
                }

                // this method send output to each client in the tread
                this.printToALlClients(var2);
                System.out.println("Server received " + var2);
            }
        } catch (Exception var3) { // throw an exc in case I get an error
            System.out.println("Error occured " + var3.getStackTrace());
        }

    }

    private void printToALlClients(String var1) {
        Iterator var2 = this.threadList.iterator();

        while(var2.hasNext()) {  // loop so that can send message to all the clients
            ServerThread var3 = (ServerThread)var2.next();
            var3.output.println(var1);
        }

    }
}
