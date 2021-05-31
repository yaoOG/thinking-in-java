package org.thinking.net;

import java.net.Socket;

/**
 * @author Daniel:)
 */
public class ClientSocketClass {

    private static Socket[] clients = new Socket[30];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            clients[i] = new Socket("127.0.0.1", 8888);
            System.out.println("Client:" + i);
        }
    }
}
