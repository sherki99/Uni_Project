package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class GameServer {
    private ServerSocket ss; // the game need a server socket
    private int numPlayer; // the field of number of player, two player

    public GameServer(){
        numPlayer = 0;// num of players start with 0

        try {
            ss = new ServerSocket(51734);  // when the player want to connect has to specify the same port number
        }catch (IOException ex){
            System.out.println("error from game server constructor");
        }
    }

    // method is going incapsulate the instructions for the server waiting for connections

    public void acceptConnections(){
        try{
       //     System.out.println();
            while(numPlayer <  2) // loop limits the connection up to 2 players only
            {
                Socket s =ss.accept();// line tells the server to begin
           
                // once the client connected get the input and output streams 
                DataInputStream in = new DataInputStream(s.getInputStream()); // get the input steam
                DataOutputStream out = new DataOutputStream(s.getOutputStream()); // get the output steam
                
                numPlayer++; // after accepiting the connection, increment the numpPlayer
                // I use numPlayer to determine the player number
                //in.readInt();
                // first thing the server does is to sends an integer for the number of playerID
                out.writeInt(numPlayer);
                System.out.println("Player num" + numPlayer + "has connected");
            }
        }catch (IOException ex){
            System.out.println("from acceptConnections");
        }

    }


    public static void main(String[] args){
        GameServer gs = new GameServer(); // initiate game server
        gs.acceptConnections(); // connect to the server
    }

}
