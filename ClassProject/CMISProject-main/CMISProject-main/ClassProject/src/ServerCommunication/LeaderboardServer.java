package ServerCommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LeaderboardServer {
    private static final int PORT = 8888;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/leaderboard";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Leaderboard server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Handle client requests (e.g., fetch leaderboard data, submit speed run record)
            // Example: Receive request from client, execute SQL queries, send response back to client

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}