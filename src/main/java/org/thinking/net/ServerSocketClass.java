package org.thinking.net;

import java.net.ServerSocket;

/**
 * @author Daniel:)
 */
public class ServerSocketClass {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888, 5);
        while (true) {
            //因为accept()方法从全连接队列中取出了连接请求进行处理。
            //看得出来，backlog提供了容量限制功能，避免过多的客户端Socket占据大量的服务端资源。
            server.accept();
        }
    }
}
