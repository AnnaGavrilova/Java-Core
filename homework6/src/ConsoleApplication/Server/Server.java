package ConsoleApplication.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static DataInputStream in;
    public static DataOutputStream out;

    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;
        Scanner sc = new Scanner(System.in);

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился");

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

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
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
                    if(textIn.equals("/end")) break;
                    System.out.println("Client: " + textIn);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
