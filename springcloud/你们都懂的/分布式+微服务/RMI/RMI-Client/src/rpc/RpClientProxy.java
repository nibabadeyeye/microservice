package rpc;

import java.lang.reflect.Proxy;

/*ʵ�ֿͻ��˵Ķ�̬����,����ͻ��������˵ĵ���*/
public class RpClientProxy {
  @SuppressWarnings("unchecked")
public <T> T clientProxy(final Class<T> interfaceClass,final String host,int port)
   {
	   //�Ե�ǰ���õĽӿ�����̬����
	   return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), 
			   new Class[]{interfaceClass}, new RemoteInvocationHandler(host, port));
   }
}
