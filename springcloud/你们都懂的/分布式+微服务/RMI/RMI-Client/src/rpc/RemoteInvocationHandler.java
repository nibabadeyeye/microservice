package rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler{
    private String host;
    private int port;
    
	public RemoteInvocationHandler(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		RpcRequest request=new RpcRequest();
		request.setClassName(method.getDeclaringClass().getName());
		request.setMethodName(method.getName());
		request.setParameters(args);
		TcpTransant transport=new TcpTransant(host, port);
		return transport.send(request);
	}

}
