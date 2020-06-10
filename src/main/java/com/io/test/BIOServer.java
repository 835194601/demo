package com.io.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class BIOServer {
    public static void main(String[] args) {
        server1();
    }

    public static void server1() {
        ServerSocket server;
        Socket socket;
        InputStream in;
        OutputStream out;

        try {
            server = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000，等待客户端连接...");
            socket = server.accept();
            in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, len));
            }

            out = socket.getOutputStream();
            out.write("hello everyBody".getBytes());
        } catch (Exception e) {
        }
    }

    public void server2() {
        ServerSocket server;
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000，等待客户端连接...");
            while (true) {
                Socket socket = server.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        } catch (Exception e) {

        }
    }

    public void server3() {
        ServerSocket server;
        ExecutorService executorService = new ThreadPoolExecutor(5,
                5, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10));
        try {
            server = new ServerSocket(8000);
            System.out.println("服务器启动成功，监听端口8000，等待客户端连接...");
            while (true) {
                Socket socket = server.accept();
                executorService.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {

        }
    }
}
