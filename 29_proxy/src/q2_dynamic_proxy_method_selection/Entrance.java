package q2_dynamic_proxy_method_selection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Entrance {
    public static void main(String[] args){
//    	被代理对象
        A1 a1=new A1();
//      代理handler的初始化，代理对象的声成，代理对象成员变量的初始化
        ProxyA proxyA = new ProxyA();
        proxyA.object = a1;
//      代理实例化过程，代理的方法的调用
        A a1A = (A)Proxy.newProxyInstance(a1.getClass().getClassLoader(), a1.getClass().getInterfaces(), proxyA);
        a1A.test1();
    }
}

class ProxyA implements InvocationHandler{
	Object object;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
			if(method.getName().equals("test1")) {
				System.out.println("A1 Test1 Before");
				method.invoke(object, args);
				System.out.println("A1 Test1 After");
			}
			else if(method.getName().equals("test2")) {
				System.out.println("A1 Test2 Before");
				method.invoke(object, args);
				System.out.println("A1 Test2 After");
			}
			else if(method.getName().equals("test3")) {
				System.out.println("A1 Test3 Before");
				method.invoke(object, args);
				System.out.println("A1 Test3 After");
			}
		
		return null;
	}
}




