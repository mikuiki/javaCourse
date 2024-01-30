package q3_dynamic_proxy_return;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Entrance {
    public static void main(String[] args){
    	A1 a1 = new A1();
    	ProxyHandler pHandler = new ProxyHandler();
    	pHandler.object = a1;
    	A aproxyA = (A)Proxy.newProxyInstance(a1.getClass().getClassLoader(), a1.getClass().getInterfaces(), pHandler);

    	int result = (int)aproxyA.test();
    	System.out.println(result);
    
    }
}

class ProxyHandler implements InvocationHandler{
	Object object;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("A1 test before");
		Object result = method.invoke(object, args);
        // 执行结果存储在Object对象中，返回result		
		return result;
	}
}