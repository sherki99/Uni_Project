package Client;
import main.DataPanel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws RuntimeException {
        try {

            RacingClient client = new RacingClient("localhost", 5001);
            // Main main = new Main();
            client.start();
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}