package rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDemo {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHelloService helloService= (IHelloService)Naming.lookup("rmi://127.0.0.1/Hello");
        System.out.println(helloService.sayHello("终于找到你了"));
    }
}
