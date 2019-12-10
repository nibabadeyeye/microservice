package rpc.server;
import rpc.HelloServiceImpl;
import rpc.IHelloService;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerDemo {
public static void main(String[] args) {
	        try {
	            IHelloService helloService=new HelloServiceImpl();//�Ѿ�������һ��Զ�̶���
	            LocateRegistry.createRegistry(1099);//IHelloService ��stoken
                Naming.rebind("rmi://127.0.0.1/Hello", helloService); //ע������ key - value
	            System.out.println("发布服务成功！！！");
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	        
	        }

	    }
	
	/* public static void main(String[] args) {
	        IGpHello iGpHello=new GpHelloImpl();
	        RpcServer rpcServer=new RpcServer();
	        rpcServer.publisher(iGpHello,8888);
	    }*/
}
