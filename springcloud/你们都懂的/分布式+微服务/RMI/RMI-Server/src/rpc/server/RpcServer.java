package rpc.server;

import rpc.ProcessOnHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class RpcServer {
    //定义一个线程连接池
    private static final ExecutorService executorService=Executors.newCachedThreadPool();
    //发布一个服务
    public void publisher(final Object service,int port){
        ServerSocket serverSocket=null;
        try{
            serverSocket=new ServerSocket(port);  

            while(true){ 
                Socket socket=serverSocket.accept(); 
               
                executorService.execute(new ProcessOnHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
