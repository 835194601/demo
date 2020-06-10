package com.io.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private Socket socket;
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in;
        OutputStream out;

        try {
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
}
