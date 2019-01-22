package NetworkChat.NetServer;

import NetworkChat.NetClient.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerTest {
    private Vector<ClientHandler> clients;

    public ServerTest() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public void privatMsg(String msg, String nickName, String myNick) {
        boolean flag = false;
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickName)) {
                msg = myNick + ": " + msg;
                o.sendMsg(msg);
                flag = true;
            }
        }
        if (!flag) {
            for (ClientHandler o : clients) {
                if (o.getNick().equals(myNick)) {
                    o.sendMsg("Нет пользователя в сети!");
                }
            }
        }
    }

    public boolean isUserThere(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) return true;
        }
        return false;
    }
}
