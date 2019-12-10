package rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloService extends Remote {
  public String sayHello(String msg) throws RemoteException;
}
