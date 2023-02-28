package Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a socket, and Initiate the connection to my server by passing the ip address and port
        try (Socket socket = new Socket("localhost", 5000)){ //
            // first of  all, reading the input from server using buffer
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));



            // I use printwriter to return the output to the server
            //returning the output to the server : true statement is to flush(risaquare) the buffer otherwise I have to do it manuallyy
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

            //I used scanner to taking the user input
            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName = "empty";


          //  ClientRunnable clientRun = new ClientRunnable(socket);
            ClientThread clientThread = new ClientThread(socket);

            new Thread(clientThread).start();
            //loop closes when user enters exit command
            do {

                if (clientName.equals("empty")) { // In this case I will take the userName
                    System.out.println("Enter your name ");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                    output.println(userInput);
                    if (userInput.equals("exit")) {
                        break;
                    }
                }
                else {
                    String message = ( "(" + clientName + ")" + " message : " );
                    System.out.println(message);
                    userInput = scanner.nextLine();
                    output.println(message + " " + userInput);
                    if (userInput.equals("exit")) {
                        //reading the input from server
                        break;
                    }
                }

            } while (!userInput.equals("exit"));




        } catch (Exception e) {
            System.out.println("Exception occured in client main: " + e.getStackTrace());
        }
    }
}