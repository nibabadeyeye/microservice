package rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;


public class ProcessOnHandler implements  Runnable {
	private Socket socket=null;
	private Object service=null;
	
	public ProcessOnHandler(Socket socket, Object service) {
		super();
		this.socket = socket;
		this.service = service;
	}

	public void run() 
	{

		ObjectInputStream inputStream=null;
		try {
			 inputStream=new ObjectInputStream(socket.getInputStream());

			RpcRequest request=(RpcRequest) inputStream.readObject();
			try 
			{
				Object result=invoke(request);
				ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
				outputStream.writeObject(result);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		} catch (IOException e)
		{
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			if(inputStream!=null)
			{
				try 
				{
					inputStream.close();
				} catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
	public Object invoke(RpcRequest request) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Object[]args=request.getParameters();
		Class<?>[]types=new Class[args.length];
		for(int i=0;i<args.length;i++)
		{
			types[i]=args[i].getClass();
		}
		Method method=service.getClass().getMethod(request.getMethodName(), types);
	   return method.invoke(service, args);
	}
}


