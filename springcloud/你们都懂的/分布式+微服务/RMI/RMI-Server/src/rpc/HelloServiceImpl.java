package rpc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(String msg) {
		// TODO Auto-generated method stub
		return "Hello,I 'm  "+msg;
	}

}
