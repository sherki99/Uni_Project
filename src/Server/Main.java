package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    // I use thread to handle multiple client request

    public static void main(String[] args) throws IOException {

        int port = 5000;
        RacingServer server = new RacingServer(port);
        server.start();
    }

}