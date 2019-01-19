package ConsoleApplication.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static DataInputStream in;
    public static DataOutputStream out;

    public static void main(String[] args) {

        Socket socket = null;

        final String ipAddress = "localhost";
        final int port = 8189;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(ipAddress, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            MyThread reader = new MyThread();
            reader.setDaemon(true);
            reader.start();

            String textOut = "";
            while (true) {
                textOut = sc.nextLine();
                if (textOut.equals("/end")) break;
                out.writeUTF(textOut);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            String textIn = null;
            try {
                while (true) {
                    textIn = in.readUTF();
                    if (textIn.equals("/end")) break;
                    System.out.println("Server: " + textIn);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


