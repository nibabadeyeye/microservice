package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*��Socket���й���*/
public class TcpTransant {
	private String host;
	private int port;

	public TcpTransant(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
    public Socket newSocket()
    {
    	Socket socket = null;
    	System.out.println("����һ������");
    	try {
			socket=new Socket(host,port);
			return socket;
		} catch (Exception e) {
			
		}
		return socket;
    	
    }
    
    public Object send(RpcRequest request)
    {
    	Socket socket=null;
    	try {
			socket=newSocket();
			//�õ������Socket֮�����ǿ����õ���������InputStream��OutPutStream(���л���)
			ObjectOutputStream outPutStream=new ObjectOutputStream(socket.getOutputStream());
			outPutStream.writeObject(request);
			outPutStream.flush();//ǿ���������ˢ�¶���
			//��������ȥ
			ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
			Object result=inputStream.readObject();
			inputStream.close();
			outPutStream.close();
			return result;
			
		} catch (Exception e) {
			
		}finally {
			
		}
		return socket;
    	
    }
}
