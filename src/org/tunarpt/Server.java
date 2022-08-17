package org.tunarpt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int SERVER_PORT = 8080;
    private Socket socket;
    private ServerSocket serverSocket;

    private PrintWriter out;
    private BufferedReader in;
    public void start() {
        try {
            init();
            while(true){
                listen();
                wireConnections();
                handleRequest();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() throws IOException {
        serverSocket = new ServerSocket(SERVER_PORT);
    }

    private void listen() throws IOException {
        socket = serverSocket.accept();
    }

    private void wireConnections() throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void handleRequest() throws IOException {
        String[] request = in.readLine().split(" ");
        int ACTION_INDEX = 0;
        int URL_INDEX = 1;

        String action = request[ACTION_INDEX];
        String url = request[URL_INDEX];
    }
}
