package ServerCommunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LeaderboardClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {

        try (

                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            // Handle communication with the server


        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}