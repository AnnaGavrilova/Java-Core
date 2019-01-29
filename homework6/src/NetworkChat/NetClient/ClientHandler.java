package NetworkChat.NetClient;


import NetworkChat.NetServer.AuthService;
import NetworkChat.NetServer.ServerTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ServerTest server;
    private String nick;
    ArrayList<String> blackList;

    private Timer mTimer;

    public ClientHandler(ServerTest server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            this.blackList = new ArrayList<>();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();

                            mTimer = new Timer();
                            TimerTask timerTask = new TimerTask() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(120000);
                                        socket.close();
                                        System.out.println("Клиент отключился");
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            mTimer.schedule(timerTask, 0);

                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickLoginAndPass(tokens[1], tokens[2]);
                                if (newNick != null) {
                                    if (!server.isUserThere(newNick)) {
                                        sendMsg("/authok");
                                        ClientHandler.this.nick = newNick;
                                        mTimer.cancel();
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Пользователь " + newNick + " уже авторизован.");
                                        break;
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            String[] mass = str.split(" ", 3);
                            switch (mass[0]) {
                                case "/end":
                                    out.writeUTF("/serverClosed");
                                    break;
                                case "/w":
                                    String message = mass[2];
                                    server.privatMsg(message, mass[1], ClientHandler.this);
                                    break;
                                case "/blacklist":
                                    blackList.add(mass[1]);
                                    sendMsg("Вы добавили пользователя " + mass[1] + " в черный список");
                                    break;
                                default:
                                    server.broadcastMsg(ClientHandler.this, nick + ": " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return ClientHandler.this.nick;
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }
}
