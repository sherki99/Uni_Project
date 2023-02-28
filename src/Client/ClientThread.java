package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// I use thread to handle multiple client request
public class ClientThread extends Thread{ // I have created the client thread in order to listen to the results from the server
    // without getting blocked or reading from the scanner

    public Socket socket;
    public BufferedReader input; // I have used input for the data to get information from the client

    public ClientThread(Socket s) throws IOException{ // create a constructor that will pass socket from the client side to the main class
        this.socket = s;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


    }


    public void run(){ // here I will be listening to the response from the server.
        try{
            while(true){
                String response = input.readLine();
                System.out.println(response);
            }
        }catch(IOException e){
            e.printStackTrace();
        } finally { // last I will close my input

            try{
                input.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
