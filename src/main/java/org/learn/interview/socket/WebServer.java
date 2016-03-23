/**
 * 
 */
package org.learn.interview.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易web服务器
 * 
 * @author admin
 */
public class WebServer {
    
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            ServerSocket server = new ServerSocket(80);
            
            
            Socket s = null;
            while ((s = server.accept()) != null) {
                new Handler(s).start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

class Handler extends Thread {
    
    private Socket s;
    
    public Handler(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("<html>");
            pw.write("<body>");
            pw.write("hello world");
            pw.write("<body>");
            pw.write("<html>");
            pw.flush();
            pw.close();
            s.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
